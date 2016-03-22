package com.hc.presenter;

import android.os.Handler;

import com.hc.model.bean.User;
import com.hc.model.IUserLogin;
import com.hc.model.OnUserLoginListener;
import com.hc.model.impl.UserLogin;
import com.hc.view.IUserLoginView;

/**
 * Created by hcitl on 2016-3-11-0011.
 */
public class UserLoginPresenter {

    private IUserLogin userLogin;
    private IUserLoginView userLoginView;

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userLogin = new UserLogin();
    }

    private Handler handler = new Handler();

    public void login() {
        userLoginView.showLoading();
        userLogin.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnUserLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                handler.post(new Runnable() {//在UI线程中执行
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });
            }
        });

    }

    public void clear() {
        userLoginView.clearPassword();
        userLoginView.clearUserName();
    }
}
