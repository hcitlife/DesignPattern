package com.hc.view;

import com.hc.model.bean.User;

/**
 * Created by hcitl on 2016-3-11-0011.
 */
public interface UserView {
    int getId();

    String getName();

    String getPass();

    void clearId();

    void clearName();

    void clearPass();

    void isLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
