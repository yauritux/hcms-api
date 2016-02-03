package com.abminvestama.hcms.core.model.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import nl.jqno.equalsverifier.EqualsVerifier;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@RunWith(JUnit4.class)
public class T519SKeyTest {

	@Test
	public void equalsContract() {
		EqualsVerifier.forClass(T591SKey.class).usingGetClass().verify();
	}
}