package com.hc.model;

//Model层抽象接口，处理业务逻辑
public interface IUserInfo {
    void getUserInfo(int id, OnUserInfoListener listener);
}