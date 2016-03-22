package com.hc.mvcdemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hc.model.bean.User;
import com.hc.presenter.UserPresenter;
import com.hc.view.UserView;

public class MainActivity extends AppCompatActivity implements UserView {

    private TextView resTV;
    private EditText idET;
    private EditText nameET;
    private EditText passET;
    private ProgressDialog dialog;
    private UserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.passET = (EditText) findViewById(R.id.pass_et);
        this.nameET = (EditText) findViewById(R.id.name_et);
        this.idET = (EditText) findViewById(R.id.id_et);
        this.resTV = (TextView) findViewById(R.id.res_tv);
        dialog = new ProgressDialog(this);
        dialog.setMessage("正在进行……");
        userPresenter = new UserPresenter(this);
    }

    public void searchFun(View view) {
        userPresenter.showInfo();
    }

    public void loginFun(View view) {
        userPresenter.userLogin();
    }

    public void clearFun(View view) {
        userPresenter.clearWidget();
    }

    @Override
    public int getId() {
        return Integer.valueOf(idET.getText().toString().trim());
    }

    @Override
    public String getName() {
        return nameET.getText().toString().trim();
    }

    @Override
    public String getPass() {
        return passET.getText().toString().trim();
    }

    @Override
    public void clearId() {
        idET.setText("");
    }

    @Override
    public void clearName() {
        nameET.setText("");
    }

    @Override
    public void clearPass() {
        passET.setText("");
    }

    @Override
    public void isLoading() {
        dialog.show();
    }

    @Override
    public void hideLoading() {
        dialog.hide();
    }

    @Override
    public void toMainActivity(User user) {
        resTV.setText(user.toString());
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
    }
}
