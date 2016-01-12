package com.abminvestama.hcms.rest.api.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public final class CommonRESTUtil {

	/**
	 * Method to convert dateRequest of String 'YYYY-MM-DD' formatted into java.util.Date object.
	 *  
	 * @param dateRequest
	 * @return
	 * @throws DateTimeException
	 */
	public static Date convertDateRequestParameterIntoDate(String dateRequest) 
			throws DateTimeException {
		String[] dates = dateRequest.split("-");
		if (dates.length < 3) {
			throw new DateTimeException(
					"Cannot parse " + dateRequest + " to Date object. Please use date in the format of 'yyyy-mm-dd'.E.g. : 2015-01-18");
		}
		
		Calendar cal = Calendar.getInstance();
		try {
			cal.set(Calendar.YEAR, Integer.valueOf(dates[0]));
			cal.set(Calendar.MONTH, Integer.valueOf(dates[1]) - 1);
			cal.set(Calendar.DATE, Integer.valueOf(dates[2]));
			cal.clear(Calendar.HOUR_OF_DAY);
			cal.clear(Calendar.HOUR);
			cal.clear(Calendar.AM_PM);
			cal.clear(Calendar.MINUTE);
			cal.clear(Calendar.SECOND);
			cal.clear(Calendar.MILLISECOND);					
		} catch (NumberFormatException nfe) {
			throw new DateTimeException("Year, Month, and Date should be in numeric. E.g. : 2015-01-18");
		}		
		
		return cal.getTime();
	}
	
	/**
	 * Return date as string in yyyy-MM-dd formatted.
	 * 
	 * @param date
	 * @return date in yyyy-MM-dd
	 */
	public static String convertDateToStringYMD(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}
}