package com.hc.model.entity;

import java.util.Date;

/**
 * Created by hcitl on 2016-3-14-0014.
 */
public class WeatherInfo {
    private String city;
    private String cityId;
    private int temp;
    private String WD;
    private String WS;
    private String SD;
    private int WSE;
    private Date time;
    private boolean isRadar;
    private String Radar;
    private String njd;
    private int qy;
    private float rain;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String getWD() {
        return WD;
    }

    public void setWD(String WD) {
        this.WD = WD;
    }

    public String getWS() {
        return WS;
    }

    public void setWS(String WS) {
        this.WS = WS;
    }

    public String getSD() {
        return SD;
    }

    public void setSD(String SD) {
        this.SD = SD;
    }

    public int getWSE() {
        return WSE;
    }

    public void setWSE(int WSE) {
        this.WSE = WSE;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean isRadar() {
        return isRadar;
    }

    public void setRadar(boolean radar) {
        isRadar = radar;
    }

    public String getRadar() {
        return Radar;
    }

    public void setRadar(String radar) {
        Radar = radar;
    }

    public String getNjd() {
        return njd;
    }

    public void setNjd(String njd) {
        this.njd = njd;
    }

    public int getQy() {
        return qy;
    }

    public void setQy(int qy) {
        this.qy = qy;
    }

    public float getRain() {
        return rain;
    }

    public void setRain(float rain) {
        this.rain = rain;
    }

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "city='" + city + '\'' +
                ", cityId='" + cityId + '\'' +
                ", temp=" + temp +
                ", WD='" + WD + '\'' +
                ", WS='" + WS + '\'' +
                ", SD='" + SD + '\'' +
                ", WSE=" + WSE +
                ", time=" + time +
                ", isRadar=" + isRadar +
                ", Radar='" + Radar + '\'' +
                ", njd='" + njd + '\'' +
                ", qy=" + qy +
                ", rain=" + rain +
                '}';
    }
}
