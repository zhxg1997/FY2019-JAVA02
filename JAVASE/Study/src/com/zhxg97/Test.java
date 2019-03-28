package com.zhxg97;

import java.util.Scanner;


import javax.swing.plaf.synth.SynthSpinnerUI;

import com.zhxg97.exception.LoginException;
import com.zhxg97.exception.RegisterException;
import com.zhxg97.view.UserView;
import com.zhxg97.view.impl.UserViewimp;
import com.zhxg97.exception.LoginException;

public class Test {
	static UserView a = new UserViewimp();
		public static void main(String[] args) {
			System.out.println("=========1.登录    2.注册=========");
			Scanner s = new Scanner(System.in);
			System.out.println("请选择：");
			int int1 = s.nextInt();
			if(int1 == 1) {
				login();
			}else if(int1 == 2) {
				regist();
			}
			
		}
		public static void regist() {

			try {
				a.register();
			} catch (RegisterException e) {
				String a=e.getMessage();
				System.out.print(a);
				regist();
			}
		}
		public static void login() {

			try {
				a.login();
			} catch (LoginException e) {
				String a=e.getMessage();
				System.out.print(a);
				login();
			}
		}
}
