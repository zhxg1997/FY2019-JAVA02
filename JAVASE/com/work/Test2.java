package com.work;
import java.util.Scanner;
public class Test2 {
      public static void main(String args[]) {
    	  Scanner sc = new Scanner(System.in);
    	  System.out.println("请输入字符串");
          String str1 = sc.next();
          System.out.println("请输入字符串");
          String str2 = sc.next();
          int count = countString(str1,str2);
          System.out.print("字符串个数为： " + count);
      }
      
      public static int countString(String str1, String str2) {
         int count = 0; 
         int findIndex = 0;
         int findLen = str2.length();
         findIndex = str1.indexOf(str2);
         while(findIndex != -1){
             str1 = str1.substring(findIndex + findLen);
            findIndex = str1.indexOf(str2);
             count++;
         }
         return count;
     }
     
 }