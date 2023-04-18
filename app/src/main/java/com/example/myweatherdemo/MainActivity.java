package com.example.myweatherdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myweatherdemo.bean.WeatherBean;
import com.example.myweatherdemo.util.CityCodeUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
/**
 * @author dick1020
 */
public class MainActivity extends AppCompatActivity {
    private TextView tvContent;
    private AutoCompleteTextView autoEdit;
    private Button btnRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btnRequest.setOnClickListener(v -> {
            String city = autoEdit.getText().toString();
            requestData(CityCodeUtil.cityCode.getCityAdcode(city));
        });
    }

    private void requestData(String city) {
        NetRequest.NET_REQUEST.Request(this,city, new NetRequest.OnRequestResult() {
            @Override
            public void success(String data) {
                WeatherBean resultData = new Gson().fromJson(data, new TypeToken<WeatherBean>() {
                }.getType());
                runOnUiThread(() -> tvContent.setText(resultData.getLives().get(0).toString()));
            }

            @Override
            public void fail(String msg) {

            }
        });
    }

    private void initView() {
        autoEdit = findViewById(R.id.autoEdit);
        tvContent = findViewById(R.id.tvContent);
        btnRequest = findViewById(R.id.btnRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.
                this, android.R.layout.simple_dropdown_item_1line, CityCodeUtil.cityCode.getCityNameBeans());
        autoEdit.setAdapter(adapter);
    }
}