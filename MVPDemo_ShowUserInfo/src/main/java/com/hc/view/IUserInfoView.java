package com.hc.view;

import com.hc.model.bean.User;

//Presenter与View之间交互的接口
//这个接口中列出操作当前View的方法
//该接口封装的方法基本上都跟视图层展示有关
public interface IUserInfoView {

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}