package com.zhxg97;

public class UserViewimp implements UserView{
	
	public static void main(String[] args) {
		UserViewimp a = new UserViewimp(); 
		a.register();

	
	}
	
	public void login() {

		
	}


	public void register() {
		UserBizimp a = new UserBizimp();
		try {
			a.register("username","password","password2","name","email");
		} catch (RegisterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
