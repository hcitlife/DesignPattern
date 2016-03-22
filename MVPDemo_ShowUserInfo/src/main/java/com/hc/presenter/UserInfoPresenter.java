package com.hc.presenter;

import android.os.Handler;
import android.util.Log;

import com.hc.model.bean.User;
import com.hc.model.UserInfo;
import com.hc.model.IUserInfo;
import com.hc.model.OnUserInfoListener;
import com.hc.view.IUserInfoView;

//Model和View之前交互的桥梁，里面主要是一些业务逻辑操作
//通过IView和IModel操作View和Model
//Activity可以把所有的逻辑交给Presenter处理
public class UserInfoPresenter {
    private IUserInfo iGetUser;//Model
    private IUserInfoView iShowUserView;//View
    private Handler mHandler = new Handler();

    public UserInfoPresenter(IUserInfoView iShowUserView) {
        this.iShowUserView = iShowUserView;
        this.iGetUser = new UserInfo();
    }

    public void getUserInfoToShow(int id) {
        iShowUserView.showLoading();
        iGetUser.getUserInfo(id, new OnUserInfoListener() {
            @Override
            public void getUserInfoSuccess(final User user) { // 需要在UI线程执行
                Log.i("TAG", Thread.currentThread().getId() + "  111");//子线程
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("TAG", Thread.currentThread().getId() + "  222");//主线程
                        iShowUserView.toMainActivity(user);
                        iShowUserView.hideLoading();
                    }
                });
            }

            @Override
            public void getUserInfoFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iShowUserView.showFailedError();
                        iShowUserView.hideLoading();
                    }
                });
            }
        });
    }

}