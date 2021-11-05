package com.app.libs.common;

public class StringUtils {

	public static boolean equals(String str1,String str2) {
		boolean result=false;
		if(str1.equals(str2)) {
			result=true;
		}
		return result;
	}
	
	public static boolean equalsIgnorecase(String str1,String str2) {
		boolean result=false;
		if(str1.equalsIgnoreCase(str2)) {
			result=true;
		}
		return result;
	}
	
	public static boolean contains(String str1,String str2) {
		boolean result=false;
		if(str1.contains(str2)) {
			result=true;
		}
		return result;
	}
	public static boolean isNullOrEmpty(String str) {
		boolean result=false;
		if(str.isEmpty() || str==null) {
			result=true;
		}else {
			result=false;
		}
		return result;
	}
	
	
	
}
