package com.zking.ssm.util;

public class StringUtils {
	// 私有的构造方法，保护此类不能在外部实例化
	private StringUtils() {
	}

	/**
	 * 如果字符串等于null或去空格后等于""，则返回true，否则返回false
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isBlank(String s) {
		boolean b = false;
		if (null == s || s.trim().equals("")) {
			b = true;
		}
		return b;
	}
	
	/**
	 * 如果字符串不等于null或去空格后不等于""，则返回true，否则返回false
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isNotBlank(String s) {
		return !isBlank(s);
	}

}
