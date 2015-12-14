package com.abminvestama.hcms.common.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.codec.Hex;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * Utility to create and validate user's authentication token.
 *
 */
public class AuthTokenUtils {

	private static final SecureRandom SECURE_RANDOM = new SecureRandom();
	
	/**
	 * Create token based on supplied userDetails.
	 * 
	 * @param userDetails object that stores user information.
	 * @return String valid authentication token.
	 */
	public static String createToken(UserDetails userDetails) {
		//Build the token
		StringBuilder tokenBuilder = new StringBuilder();
		tokenBuilder.append(AuthTokenUtils.computeSignature(userDetails));
		return tokenBuilder.toString();
	}
	
	/**
	 * Computes signature that will be used as a part of the token.
	 * 
	 * @param userDetails object that stores user information.
	 * @return String valid authentication token signature.
	 */
	public static String computeSignature(UserDetails userDetails) {
		//Build the signature
		StringBuilder signatureBuilder = new StringBuilder();
		signatureBuilder.append(userDetails.getUsername());
		signatureBuilder.append(":");
		signatureBuilder.append(userDetails.getPassword());
		signatureBuilder.append(":");
		signatureBuilder.append(new BigInteger(130, SECURE_RANDOM).toString(16));
		
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException("No SHA-512 algorithm available");
		}
		
		return new String(Hex.encode(digest.digest(signatureBuilder.toString().getBytes())));
	}
	
	/**
	 * Validates supplied authToken with actual userDetails.
	 * 
	 * @param providedAuthToken Authentication Token provided by user.
	 * @param authTokenValidThru Authentication Token validity period.
	 * @param storedAuthToken Authentication Token stored in storage.
	 * @return boolean true if supplied authToken is valid againts actual userDetails, otherwise false is returned.
	 */
	public static boolean validateToken(String providedAuthToken, Date authTokenValidThru,
			String storedAuthToken) {
		if (providedAuthToken == null || storedAuthToken == null) {
			return false;
		}
		
		if (authTokenValidThru != null) {
			if (new Date().after(authTokenValidThru)) {
				return false;
			}
		}
		
		return providedAuthToken.equals(storedAuthToken);
	}
}