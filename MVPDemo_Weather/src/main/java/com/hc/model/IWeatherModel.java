package com.hc.model;

/**
 * Created by hcitl on 2016-3-14-0014.
 */
public interface IWeatherModel {
    void loadWeatherInfo(String url,final OnWeatherListener listener);
}
