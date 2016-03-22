package com.hc.showuserinfo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hc.model.bean.User;
import com.hc.presenter.UserInfoPresenter;
import com.hc.view.IUserInfoView;

public class MainActivity extends AppCompatActivity implements IUserInfoView {

    private TextView nameTV;
    private TextView ageTV;
    private TextView sexTV;
    private ProgressDialog dialog = null;
    private UserInfoPresenter userInfoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTV = (TextView) findViewById(R.id.name_tv);
        ageTV = (TextView) findViewById(R.id.age_tv);
        sexTV = (TextView) findViewById(R.id.sex_tv);

        userInfoPresenter = new UserInfoPresenter(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage("正在加载……");
    }

    public void fun1(View view) {
        userInfoPresenter.getUserInfoToShow(1);
    }

    public void fun2(View view) {
        userInfoPresenter.getUserInfoToShow(2);
    }

    @Override
    public void showLoading() {
        dialog.show();
    }

    @Override
    public void hideLoading() {
        dialog.cancel();
    }

    @Override
    public void toMainActivity(User user) {
        nameTV.setText(user.getName());
        ageTV.setText(user.getAge());
        sexTV.setText(user.getSex());
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "获取信息有误", Toast.LENGTH_SHORT).show();
    }

}
