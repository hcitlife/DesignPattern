package com.hc.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hc.model.entity.WeatherInfo;
import com.hc.presenter.WeatherPresenter;
import com.hc.ui.view.IWeatherView;

public class MainActivity extends AppCompatActivity implements IWeatherView {

    private ProgressDialog dialog;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(this);
        dialog.setMessage("正在获取信息……");
        textView = (TextView) findViewById(R.id.textView);
    }

    public void fun(View view) {
        new WeatherPresenter(this, this).getWeatherInfo("101110101");
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
    public void showWeatherInfo2Activity(WeatherInfo info) {
        textView.setText(info.toString());
    }

    @Override
    public void showError() {
        Toast.makeText(this, "获取天气信息失败", Toast.LENGTH_SHORT).show();
    }
}
