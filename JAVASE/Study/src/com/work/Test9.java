package com.work;

public class Test9 {
	public static void main(String[] args) {
		String s="name=zhangsan age=18 classNo=090728";
		String[] ss = s.split(" ");
		StringBuffer sb =new StringBuffer();
		for (int i = 0; i < ss.length; i++) {
			String[] ss2 =ss[i].split("=");
			sb.append(ss2[1]);
			sb.append(" ");
		}
		System.out.println(sb);
	}
}
