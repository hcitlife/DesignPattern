package com.hc.model;

/**
 * Created by hcitl on 2016-3-11-0011.
 */
public interface IUserModel {
    void showInfo(final int id, final OnUserListener listener);

    void login(final String name, final String pass, final OnUserListener listener);
}
