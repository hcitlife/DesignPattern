package com.hc.view;

import com.hc.model.bean.User;

/**
 * Created by hcitl on 2016-3-11-0011.
 */
//对于View的接口的具体提供哪些方法，可以通过观察功能上的操作得出：
//该操作需要什么？（getUserName, getPassword）
//该操作的结果，对应的反馈？(toMainActivity, showFailedError)
//该操作过程中对应的友好的交互？(showLoading, hideLoading)
public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
