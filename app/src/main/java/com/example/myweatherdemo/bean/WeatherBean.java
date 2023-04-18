package com.example.myweatherdemo.bean;

import java.util.List;
/**
 * @author dick1020
 */
public class WeatherBean {
    //返回状态
    private String status;
    //返回结果总数目
    private String count;
    //返回的状态信息
    private String info;
    //返回状态说明,10000代表正确
    private String infocode;
    //实况天气数据信息
    private List<LivesDTO> lives;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfocode() {
        return infocode;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    public List<LivesDTO> getLives() {
        return lives;
    }

    public void setLives(List<LivesDTO> lives) {
        this.lives = lives;
    }

    public static class LivesDTO {
        //省份名
        private String province;
        //城市名
        private String city;
        //区域编码
        private String adcode;
        //天气现象（汉字描述）
        private String weather;
        //实时气温，单位：摄氏度
        private String temperature;
        //风向描述
        private String winddirection;
        //风力级别，单位：级
        private String windpower;
        //空气湿度
        private String humidity;
        //数据发布的时间
        private String reporttime;
        private String temperatureFloat;
        private String humidityFloat;

        @Override
        public String toString() {
            return "省份名='" + province + '\'' +
                    "\n城市名='" + city + '\'' +
                    "\n区域编码='" + adcode + '\'' +
                    "\n天气现象='" + weather + '\'' +
                    "\n实时气温(单位：摄氏度)='" + temperature + '\'' +
                    "\n风向描述='" + winddirection + '\'' +
                    "\n风力级别(单位：级)='" + windpower + '\'' +
                    "\n空气湿度='" + humidity + '\'' +
                    "\n数据发布的时间='" + reporttime + '\'';
        }
    }
}
