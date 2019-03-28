package com.work;

import java.util.Scanner;

public class Test1 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入字符串:");
		String s=sc.next();
		count(s);
	}
	public static void count(String s)
	{
		char[] a=s.toCharArray();
		int big=0,small=0,other=0;
		for(int i=0;i<s.length();i++)
		{
			if(a[i]>='A'&&a[i]<='Z') {
				big++;}
			else if(a[i]>='a'&&a[i]<='z') {
				small++;}
			else {
				other++;}
		}
		System.out.println("大写字母数:"+big+" 小写字母数:"+small+" 数字数:"+other);
	}



}
