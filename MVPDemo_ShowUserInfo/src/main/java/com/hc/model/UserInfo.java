package com.hc.model;

import com.hc.model.bean.User;

//Model层抽象接口实现
public class UserInfo implements IUserInfo {
    @Override
    public void getUserInfo(final int id, final OnUserInfoListener listener) {

        new Thread() {
            @Override
            public void run() {
                try { // 模拟子线程耗时操作
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (id == 1) { // 模拟信息获取成功
                    User user = new User();
                    user.setName("非著名程序员");
                    user.setAge("26");
                    user.setSex("男");
                    user.setId("1");
                    listener.getUserInfoSuccess(user);
                } else {
                    listener.getUserInfoFailed();
                }
            }
        }.start();
    }

}