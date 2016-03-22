package com.hc.ui.view;

import com.hc.model.entity.WeatherInfo;

/**
 * Created by hcitl on 2016-3-14-0014.
 */
public interface IWeatherView {
    void showLoading();

    void hideLoading();

    void showWeatherInfo2Activity(final WeatherInfo info);

    void showError();
}
