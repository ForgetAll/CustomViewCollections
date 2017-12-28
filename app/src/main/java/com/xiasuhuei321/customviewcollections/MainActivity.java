package com.xiasuhuei321.customviewcollections;

import android.os.Bundle;
import android.view.View;

import com.xiasuhuei321.customviewcollections.base.BaseActivity;
import com.xiasuhuei321.customviewcollections.weather.WeatherActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.weatherLl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(WeatherActivity.class);
            }
        });
    }
}
