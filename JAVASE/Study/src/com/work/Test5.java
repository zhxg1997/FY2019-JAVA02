package com.work;

public class Test5 {
	public static void main(String[] args) {
		
		String str1 = "test";
		StringBuffer str2 = new StringBuffer(str1);
		str2 = str2.reverse();
		str1 = str2.toString();
		System.out.println(str1);
	}
}
