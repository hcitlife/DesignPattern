package com.hc.model;

import com.hc.model.bean.User;

/**
 * Created by hcitl on 2016-3-11-0011.
 */
public interface OnUserListener {
    void onSuccess(User user);

    void onFailed();
}
