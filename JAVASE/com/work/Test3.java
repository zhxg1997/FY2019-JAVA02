package com.work;

public class Test3 {
	public static void main(String[] args) {
		 
        String a = "hello";
        String b = "hello1";
         if(equalsString(a, b)) {
        System.out.println("相等"); 
       }else {
           System.out.println("不相等");    
       }
    }
 
    public static boolean equalsString(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            char a1 = a.charAt(i);
            char b1 = b.charAt(i);
            if (a1 != b1) {
                return false;
            }
        }
        return true;
    }
}
