package com.zhxg97.view;

import com.zhxg97.exception.LoginException;
import com.zhxg97.exception.RegisterException;

public interface UserView {
	void login() throws LoginException;
    void register() throws RegisterException;
}
