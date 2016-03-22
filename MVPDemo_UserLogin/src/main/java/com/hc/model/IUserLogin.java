package com.hc.model;

/**
 * Created by hcitl on 2016-3-11-0011.
 */
public interface IUserLogin {
    void login(String name, String pass, OnUserLoginListener listener);
}
