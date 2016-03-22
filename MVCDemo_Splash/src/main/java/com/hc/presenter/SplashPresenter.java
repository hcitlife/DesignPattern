package com.hc.presenter;

import android.content.Context;
import android.os.Handler;

import com.hc.model.IConnectionListener;
import com.hc.model.IConnectionStatus;
import com.hc.model.impl.ConnectionStatus;
import com.hc.view.ISplashView;

/**
 * Created by hcitl on 2016-3-12-0012.
 */
public class SplashPresenter {

    private ISplashView splashView;
    private IConnectionStatus connectionStatus;

    public SplashPresenter(ISplashView splashView, Context context) {
        this.splashView = splashView;
        connectionStatus = new ConnectionStatus(context);
    }

    Handler handler = new Handler();

    public void judgeNetwork() {
        splashView.showProgress();
        connectionStatus.isOnline(new IConnectionListener() {
            @Override
            public void onSuccess() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        splashView.toMainView();
                        splashView.hideProgress();
                    }
                });
            }

            @Override
            public void onFailed() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        splashView.showNoNetworkErrorMsg();
                        splashView.hideProgress();
                    }
                });
            }
        });
    }
}
