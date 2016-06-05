package bw.khpi.reqmit.des.utils;

public class FormatUtils {
	
	public static String convertPath(String oldString){
		String newString = "";
		newString = oldString.replace("\\", "/");
		return newString;
	}

}
