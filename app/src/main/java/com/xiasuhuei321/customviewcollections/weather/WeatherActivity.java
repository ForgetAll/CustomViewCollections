package com.xiasuhuei321.customviewcollections.weather;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.xiasuhuei321.customviewcollections.R;
import com.xiasuhuei321.customviewcollections.base.BaseFullScreenActivity;

/**
 * Created by xiasuhuei321 on 2017/12/28.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */

public class WeatherActivity extends BaseFullScreenActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
    }
}
