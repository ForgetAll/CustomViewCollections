package com.xiasuhuei321.customviewcollections;

import android.app.Application;

import com.xiasuhuei321.weather.ScreenUtil;

/**
 * Created by xiasuhuei321 on 2017/12/28.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ScreenUtil.init(this);
    }
}
