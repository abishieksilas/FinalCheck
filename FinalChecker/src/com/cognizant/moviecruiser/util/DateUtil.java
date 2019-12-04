/**
 * 
 */
package com.cognizant.moviecruiser.util;

/**
 * @author Abishiek
 *
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date convertToDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = sdf.parse(date);
		return d;

	}
}
