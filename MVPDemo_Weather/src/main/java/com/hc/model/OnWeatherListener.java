package com.hc.model;

import com.hc.model.entity.WeatherInfo;

/**
 * Created by hcitl on 2016-3-14-0014.
 */
public interface OnWeatherListener {
    void onSuccess(WeatherInfo info);
    void onFailed();
}
