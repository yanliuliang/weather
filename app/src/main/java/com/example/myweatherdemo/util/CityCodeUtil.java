package com.example.myweatherdemo.util;

import android.content.res.AssetManager;
import android.util.Log;

import com.example.myweatherdemo.MyApp;
import com.example.myweatherdemo.bean.CityBean;
import com.google.gson.Gson;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
/**
 * @author dick1020
 */
public enum CityCodeUtil {
    cityCode;
    private final String TAG = "CityCodeUtil";
    private static List<CityBean> cityBeans = new ArrayList<>();
    private static List<String> list = new ArrayList<>();

    public void getJson() {
        //将json数据变成字符串
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bf = null;
        try {
            //获取assets资源管理器
            AssetManager assetManager = MyApp.getInstance().getAssets();
            //通过管理器打开文件并读取
            bf = new BufferedReader(new InputStreamReader(
                    assetManager.open("cityCode.json")));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getJson: " + stringBuilder);
        Type type = $Gson$Types.newParameterizedTypeWithOwner(null, ArrayList.class, CityBean.class);
        List<CityBean> bean = new Gson().fromJson(stringBuilder.toString(), type);
        try {
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getJson: " + bean);
        cityBeans = bean;
        for (CityBean b : cityBeans) {
            list.add(b.getCityName());
        }

    }

    public   List<String> getCityNameBeans() {
        return list;
    }

    public String getCityAdcode(String cityName){
        String adCode = "";
        for (CityBean b: cityBeans) {
            if (cityName.equals(b.getCityName())){
                adCode = b.getAdcode();
                break;
            }
        }
        return adCode;
    }

}
