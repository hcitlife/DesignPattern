package com.hc.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.hc.presenter.SplashPresenter;
import com.hc.view.ISplashView;

public class SplashActivity extends AppCompatActivity implements ISplashView {

    private TextView textView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.textView = (TextView) findViewById(R.id.textView);
        new SplashPresenter(this,getApplicationContext()).judgeNetwork();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showNoNetworkErrorMsg() {
        textView.setText("no network");
    }

    @Override
    public void toMainView() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
