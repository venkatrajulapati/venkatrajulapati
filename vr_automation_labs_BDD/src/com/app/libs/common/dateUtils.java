package com.app.libs.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class dateUtils {
	
	/*
	 * d ---- number of days(+ or -) from today
	*/
	public static LocalDateTime getDate(int d) {
		LocalDateTime locDate = LocalDateTime.now();
		locDate.plusDays(d);
		return locDate;
	}
	/*
	 * dt --- date in LocaldateTimnem type
	 * dtFoemat --- specify the output date format(dd/MM/yy HH:mm:ss)
	*/
	public static String getFormattedDate(LocalDateTime dt, String dtFormat) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dtFormat);
		return dt.format(formatter);
	}
	
	/* 
	 * dt -- any date in String type(05-27-2021)
	 * dtFormatfrom --- current format of the give string date(MM-dd-yyyy)
	 * dtFormatTo --- output date format(dd-MM-yyyy)
	*/
	public static String getFormattedDate(String dt, String dtFormatFrom,String dtFormatTo) {
		DateTimeFormatter formatterTo = DateTimeFormatter.ofPattern(dtFormatTo);
		DateTimeFormatter formatterFrom = DateTimeFormatter.ofPattern(dtFormatFrom);
		LocalDate reqDt = LocalDate.parse(dt, formatterFrom);
		return  reqDt.format(formatterTo);
	}
	
	/* 
	 * dt -- any date in String type(05-27-2021)
	 * dtFormat --- current format of the give string date(MM-dd-yyyy)
	 * dayOrMonthOrYr --- days or months or years to add to the given date
	*/
	public static String dateAdd(String dt, String dtFormat, String dayOrMonthOrYr,int n) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dtFormat);
		LocalDate reqDt = LocalDate.parse(dt, formatter);
		String newDt="";
		switch (dayOrMonthOrYr) {
		case "d":
			newDt=reqDt.plusDays(n).format(formatter).toString();
			break;
		case "m":
			newDt=reqDt.plusMonths(n).format(formatter).toString();
			break;
		case "y":
			newDt=reqDt.plusYears(n).format(formatter).toString();
			break;
		default:
			break;
		}
		
		return newDt;
	}
	/* 
	 * dt -- any date in String type(05-27-2021)
	 * dtFormat --- current format of the give string date(MM-dd-yyyy)
	 * 
	*/
	public static String getWeekdayName(String dt, String dtformat) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dtformat);
		LocalDate reqDt = LocalDate.parse(dt, formatter);
		return reqDt.getDayOfWeek().getDisplayName(TextStyle.FULL,Locale.getDefault());
	}
	/* 
	 * dt -- any date in String type(05-27-2021)
	 * dtFormat --- current format of the give string date(MM-dd-yyyy)
	 * 
	*/
	public static boolean isWeekEnd(String dt, String dtformat) {
		String dayName="";
		boolean result=false;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dtformat);
		LocalDate reqDt = LocalDate.parse(dt, formatter);
		dayName=reqDt.getDayOfWeek().getDisplayName(TextStyle.FULL,Locale.getDefault());
		if(StringUtils.equals(dayName.toUpperCase(), "SATURDAY") || StringUtils.equals(dayName.toUpperCase(), "SUNDAY")) {
			result=true;
		}else {
			result=false;
		}
		
		return result;
	}
	/* 
	 * dt -- any date in String type(05-27-2021)
	 * dtFormat --- current format of the give string date(MM-dd-yyyy)
	 * 
	*/
	public static int getNumberOfdaysInMonth(String dt, String dtFormat) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dtFormat);
		LocalDate reqDt = LocalDate.parse(dt, formatter);
		int noofdays=reqDt.lengthOfMonth();
		return noofdays;
	}

}
