package com.hc.model.impl;

import com.hc.model.IUserLogin;
import com.hc.model.OnUserLoginListener;
import com.hc.model.bean.User;

/**
 * Created by hcitl on 2016-3-11-0011.
 */
public class UserLogin implements IUserLogin {
    @Override
    public void login(final String name, final String pass, final OnUserLoginListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if("hc".equals(name) && "hc".equals(pass)){//模拟用户登录，登录成功返回用户的详细信息
                    User user = new User();
                    user.setName(name);
                    user.setPass(pass);
                    listener.loginSuccess(user);
                }else{
                    listener.loginFailed();
                }
            }
        }).start();
    }
}
