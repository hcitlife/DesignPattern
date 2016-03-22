package com.hc.model;

import com.hc.model.bean.User;

/**
 * Created by hcitl on 2016-3-11-0011.
 */
public class UserModel implements IUserModel {
    @Override
    public void showInfo(final int id, final OnUserListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (id == 1) {
                    User user = new User();
                    user.setId(1);
                    user.setName("非著名程序员");
                    user.setPass("123456");
                    user.setScore(89);
                    listener.onSuccess(user);
                } else {
                    listener.onFailed();
                }
            }
        }).start();
    }

    @Override
    public void login(final String name, final String pass, final OnUserListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if ("hc".equals(name) && "hc".equals(pass)) {
                    User user = new User();
                    user.setId(1);
                    user.setName("非著名程序员");
                    user.setPass("123456");
                    user.setScore(89);
                    listener.onSuccess(user);
                } else {
                    listener.onFailed();
                }
            }
        }).start();
    }
}
