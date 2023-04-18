package com.example.myweatherdemo;

import android.app.Application;

import com.example.myweatherdemo.util.CityCodeUtil;

public class MyApp extends Application {
    public static final String GD_KEY="7e675c487bdf90a76c4918488a0925db";
    private static MyApp instance;

    public static MyApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        CityCodeUtil.cityCode.getJson();

    }
}
