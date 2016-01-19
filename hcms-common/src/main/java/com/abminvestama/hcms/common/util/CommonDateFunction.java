package com.abminvestama.hcms.common.util;

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
public final class CommonDateFunction {

	public static final String getMonthFullName(int month) {
		switch (month) {
		case 0: return "January";
		case 1: return "February";
		case 2: return "March";
		case 3: return "April";
		case 4: return "May";
		case 5: return "June";
		case 6: return "July";
		case 7: return "August";
		case 8: return "September";
		case 9: return "October";
		case 10: return "November";
		case 11: return "December";
		}
		
		return "";
	}
	
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