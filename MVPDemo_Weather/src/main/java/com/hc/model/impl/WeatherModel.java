package com.hc.model.impl;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.hc.model.OnWeatherListener;
import com.hc.model.IWeatherModel;
import com.hc.model.entity.WeatherInfo;
import com.hc.utils.VolleyManager;

import org.json.JSONObject;

/**
 * Created by hcitl on 2016-3-14-0014.
 */
public class WeatherModel implements IWeatherModel {
    private Context context;

    public WeatherModel(Context context) {
        this.context = context;
    }

    @Override
    public void loadWeatherInfo(String url, final OnWeatherListener listener) {
        VolleyManager manager = VolleyManager.getInstance(context);
        RequestQueue queue = manager.getQueue();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                WeatherInfo info = new Gson().fromJson(jsonObject.toString(), WeatherInfo.class);
                listener.onSuccess(info);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                listener.onFailed();
            }
        });
        queue.add(request);
        queue.start();
    }

}
