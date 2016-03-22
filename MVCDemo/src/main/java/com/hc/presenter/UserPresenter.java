package com.hc.presenter;

import android.os.Handler;

import com.hc.model.bean.User;
import com.hc.model.OnUserListener;
import com.hc.model.UserModel;
import com.hc.view.UserView;

/**
 * Created by hcitl on 2016-3-11-0011.
 */
public class UserPresenter {
    private UserView userView;
    private UserModel userModel;

    public UserPresenter(UserView userView) {
        this.userView = userView;
        this.userModel = new UserModel();
    }

    private Handler handler = new Handler();

    public void userLogin() {
        String name = userView.getName();
        String pass = userView.getPass();
        userModel.login(name, pass, new OnUserListener() {
            @Override
            public void onSuccess(final User user) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userView.toMainActivity(user);
                    }
                });
            }

            @Override
            public void onFailed() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userView.showFailedError();
                    }
                });
            }
        });
    }

    public void showInfo() {
        int id = userView.getId();
        userModel.showInfo(id, new OnUserListener() {
            @Override
            public void onSuccess(final User user) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userView.toMainActivity(user);
                    }
                });
            }

            @Override
            public void onFailed() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userView.showFailedError();
                    }
                });
            }
        });
    }

    public void clearWidget() {
        userView.clearId();
        userView.clearName();
        userView.clearPass();
    }
}
