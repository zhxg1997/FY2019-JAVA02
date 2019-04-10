package com.work;

public class Test7 {
	public static void main(String[] args) {
		String str1 = "113@ ere qqq yyui";
		str1 = str1.replace("@", "");
		String[] strArray = str1.split(" ");

		for(int i = 0;i < strArray.length;i++) {
			System.out.print(strArray[i]+" ");
		}
	}
}
