package com.xiasuhuei321.weather.paint;

import android.graphics.Canvas;

/**
 * Created by xiasuhuei321 on 2017/12/7.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */

public interface WeatherShapePaint {
    /**
     * 绘制下雪
     *
     * @param canvas 画布
     * @param level  表示雪的大小，0 - 3
     */
    void drawSnow(Canvas canvas, int level);

    /**
     * 绘制下雨
     *
     * @param canvas 画布
     * @param level  表示雨的大小，0 - 3
     */
    void drawRain(Canvas canvas, int level);

    /**
     * 绘制多云
     *
     * @param canvas 画布
     */
    void drawCloudy(Canvas canvas);

    /**
     * 绘制沙尘天气
     *
     * @param canvas 画布
     * @param level  大小，0 - 3
     */
    void drawSand(Canvas canvas, int level);
}
