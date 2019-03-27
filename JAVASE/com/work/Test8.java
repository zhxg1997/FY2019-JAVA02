package com.work;

public class Test8 {
	
	public static void main(String[] args) {
		String s = "To be or not to be";
		String ss[] = s.split(" ");
		StringBuffer sb2 = new StringBuffer();
		for (int i = 0; i < ss.length; i++) {
			StringBuffer sb = new StringBuffer(ss[i]);
			sb.reverse();
			sb2.append(sb);
			if(i == ss.length-1){
				sb2.append(".");
			}else{
				sb2.append(" ");
			}
		}
		System.out.println(sb2);
	}
}
