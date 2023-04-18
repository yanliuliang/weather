package com.example.myweatherdemo;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author dick1020
 */

public enum NetRequest {
    NET_REQUEST;
    private final String TAG = "NetRequest";

    private final OkHttpClient client = new OkHttpClient();
    private Call call;


    public void Request(Context context, String cityAdcode, OnRequestResult requestResult) {
        Request request = new Request.Builder()
                .get()
                .url("https://restapi.amap.com/v3/weather/weatherInfo?parameters&key=" + MyApp.GD_KEY + "&city=" + cityAdcode + "&extensions=base&output=JSON").build();
        call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //失败情况
                requestResult.fail(e.toString());
                Log.d(TAG, "onFailure: call:" + call + "--error:" + e);
                Toast.makeText(context, "网络访问失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //请求成功
                Log.d(TAG, "onResponse: " + call + "---response:" + response);
                response = client.newCall(request).execute();
                String result = response.body().string();
                requestResult.success(result);
                Log.d(TAG, "onResponse: " + result);
            }
        });

    }

    public interface OnRequestResult {
        void success(String data);

        void fail(String msg);
    }
}
