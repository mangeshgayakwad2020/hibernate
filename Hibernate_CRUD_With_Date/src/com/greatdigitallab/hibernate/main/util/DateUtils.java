package com.greatdigitallab.hibernate.main.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	// Create a SimpleDateFormat for "dd/MM/YYYY" type
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
	
	// Read a String and parse/convert it to Date type
	public static Date parseDate(String dateString) throws ParseException{
		
		Date date = formatter.parse(dateString);
		
		return date;
	}
	
	// Read the Date and format/convert to a String
	public static String formatDate(Date date) {
		
		String result = null;
		
		if(date != null) {
			result = formatter.format(date);
		}
		
		return result;
	}
	
}
