package com.zhxg97.service;

import com.zhxg97.exception.LoginException;
import com.zhxg97.exception.RegisterException;

public interface UserBiz {
	void register(String username, String password, String password2,
		    String name, String email) throws RegisterException;
	void login(String username, String password) throws LoginException;
}
