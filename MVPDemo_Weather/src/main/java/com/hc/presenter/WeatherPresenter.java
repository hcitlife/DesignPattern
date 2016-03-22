package com.hc.presenter;

import android.content.Context;
import android.os.Handler;

import com.hc.model.OnWeatherListener;
import com.hc.model.IWeatherModel;
import com.hc.model.entity.WeatherInfo;
import com.hc.model.impl.WeatherModel;
import com.hc.ui.view.IWeatherView;

/**
 * Created by hcitl on 2016-3-14-0014.
 */
public class WeatherPresenter {

    private IWeatherModel weatherModel;
    private IWeatherView weatherView;

    public WeatherPresenter(Context context, IWeatherView weatherView) {
        this.weatherView = weatherView;
        weatherModel = new WeatherModel(context);
    }

    Handler handler = new Handler();

    public void getWeatherInfo(String cityNo) {
        //因为采用真正的地址，有时候会访问不到数据，所以此处使用了自定义的服务器
        String url = "http://192.168.0.105:8080/AndroidServer/" + cityNo + ".jsp";
        weatherView.showLoading();
        weatherModel.loadWeatherInfo(url, new OnWeatherListener() {
            @Override
            public void onSuccess(final WeatherInfo info) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        weatherView.showWeatherInfo2Activity(info);
                        weatherView.hideLoading();
                    }
                });
            }

            @Override
            public void onFailed() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        weatherView.showError();
                        weatherView.hideLoading();
                    }
                });
            }
        });
    }
}
