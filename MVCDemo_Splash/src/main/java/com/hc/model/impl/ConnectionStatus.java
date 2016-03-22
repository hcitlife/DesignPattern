package com.hc.model.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.hc.model.IConnectionListener;
import com.hc.model.IConnectionStatus;

/**
 * Created by hcitl on 2016-3-12-0012.
 */
public class ConnectionStatus implements IConnectionStatus {
    private Context context;

    public ConnectionStatus(Context context) {
        this.context = context;
    }

    @Override
    public void isOnline(final IConnectionListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                if (manager != null) {
                    NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isAvailable())
                        listener.onSuccess();
                    else
                        listener.onFailed();
                } else {
                    listener.onFailed();
                }
            }
        }).start();

    }
}
