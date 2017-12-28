package com.xiasuhuei321.weather.paint;

import android.graphics.Canvas;
import android.graphics.PointF;

import com.xiasuhuei321.weather.ScreenUtil;
import com.xiasuhuei321.weather.shape.Rain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiasuhuei321 on 2017/12/7.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */

public class WeatherShapePaintImpl implements WeatherShapePaint {

    private List<Rain> rainList = new ArrayList<>();

    public WeatherShapePaintImpl() {
        initRainList();
    }

    public void initRainList() {
        int i = 0;
        int space = ScreenUtil.width / 20;
        int currentSpace = 0;
        while (i < 20) {
            Rain rain = new Rain(new PointF(currentSpace, 0f),
                    new PointF(currentSpace, 0f));
            rain.setOriginLength(20f);
            rain.originX = currentSpace;
            rainList.add(rain);
            currentSpace += space;
            i++;
        }

        i = 0;
        while (i < 10) {
            Rain rain = new Rain(new PointF(0f, 0f),
                    new PointF(0f, 0f));
            rain.isRandom = true;
            rain.setOriginLength(20f);
            rainList.add(rain);
            i++;
        }
    }

    @Override
    public void drawSnow(Canvas canvas, int level) {

    }

    @Override
    public void drawRain(Canvas canvas, int level) {
        for (Rain r : rainList) {
            r.draw(canvas);
        }
    }

    @Override
    public void drawCloudy(Canvas canvas) {

    }

    @Override
    public void drawSand(Canvas canvas, int level) {

    }
}
