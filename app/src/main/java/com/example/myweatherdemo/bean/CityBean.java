package com.example.myweatherdemo.bean;
/**
 * @author dick1020
 */
public class CityBean {

    private String cityName; //城市名称
    private String adcode;  //城市id
    private String citycode;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    @Override
    public String toString() {
        return "CityBean{" +
                "cityName='" + cityName + '\'' +
                ", adcode='" + adcode + '\'' +
                ", citycode='" + citycode + '\'' +
                '}';
    }
}
