package com.hc.model;

import com.hc.model.bean.User;
//Model层抽象接口
public interface OnUserInfoListener {
    void getUserInfoSuccess(User user);
    void getUserInfoFailed();
}