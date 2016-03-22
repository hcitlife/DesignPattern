package com.hc.model;

import com.hc.model.bean.User;

/**
 * Created by hcitl on 2016-3-11-0011.
 */
public interface OnUserLoginListener {
    void loginSuccess(User user);

    void loginFailed();
}
