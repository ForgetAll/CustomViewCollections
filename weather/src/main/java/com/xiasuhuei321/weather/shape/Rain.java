package com.xiasuhuei321.weather.shape;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.support.annotation.ColorInt;

import com.xiasuhuei321.weather.ScreenUtil;

import java.util.Random;

/**
 * Created by xiasuhuei321 on 2017/12/7.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */

public class Rain extends WeatherShape {
    public static final String TAG = "Rain";

    float length = 20f;
    float originLength = 20f;

    private int timeSpace = 16;
    private int rainColor = Color.parseColor("#efefef");

    public Rain(PointF start, PointF end) {
        super(start, end);
    }

    @Override
    public float getAcceleration() {
        return 0;
    }

    @Override
    public float randomSpeed(Random random) {
        return random.nextFloat() / 10f / 2f;
    }

    @Override
    public void drawWhenInUse(Canvas canvas) {
        float distance = speedX * lastTime;
        start.y += distance;
        end.y += distance;

        canvas.drawLine(start.x, start.y, end.x, end.y, paint);
        lastTime += timeSpace;
        // 如果超出屏幕，重置
        if (end.y >= ScreenUtil.height) {
            clear();
        }
    }

    public void clear() {
        isInUse = false;
        lastTime = 0;
        start.y = -length;
        end.y = 0f;
    }

    @Override
    public void wtc(Random random) {
        length = random.nextInt(5) + originLength;
        paint.setColor(rainColor);
    }

    public void setOriginLength(float originLength) {
        this.originLength = originLength;
        length = originLength;
    }

    public void setColor(String color) {
        this.rainColor = Color.parseColor(color);
    }

    public void setColor(@ColorInt int color) {
        this.rainColor = color;
    }
}
