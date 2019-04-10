package com.work;
import java.util.Scanner;
public class Test6 {
	public static void main(String[] srgs) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入字符串");
		String str1 = sc.next();
		symmetric(str1);
	}
	
	public  static void symmetric(String str1) {
		StringBuffer str2 = new StringBuffer(str1);
		String str3 = str2.reverse().toString();
		if(str1.equals(str3)) {
			System.out.println("对称");
		}else {
			System.out.println("不对称");
		}
	}
}
