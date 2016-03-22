package com.hc.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hc.model.bean.User;
import com.hc.presenter.UserLoginPresenter;
import com.hc.view.IUserLoginView;

public class MainActivity extends AppCompatActivity implements IUserLoginView {

    ProgressDialog dialog;
    private EditText nameET;
    private EditText passET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.passET = (EditText) findViewById(R.id.passET);
        this.nameET = (EditText) findViewById(R.id.name_et);

        dialog = new ProgressDialog(this);
        dialog.setMessage("正在加载……");
    }

    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    public void loginFun(View view) {
        mUserLoginPresenter.login();
    }

    public void cancelFun(View view) {
        mUserLoginPresenter.clear();
    }

    @Override
    public String getUserName() {
        return nameET.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return passET.getText().toString().trim();
    }

    @Override
    public void clearUserName() {
        nameET.setText("");
    }

    @Override
    public void clearPassword() {
        passET.setText("");
    }

    @Override
    public void showLoading() {
        dialog.show();
    }

    @Override
    public void hideLoading() {
        dialog.hide();
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }
}
