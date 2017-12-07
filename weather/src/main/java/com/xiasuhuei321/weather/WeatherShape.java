package com.xiasuhuei321.weather;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import java.util.Random;

/**
 * Created by xiasuhuei321 on 2017/12/4.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */

public abstract class WeatherShape {
    public static final String TAG = "WeatherShape";
    protected PointF start;
    protected PointF end;
    protected boolean isInUse = false; // 是否正被使用
    protected boolean isRandom = false; // 是否随机
    // 竖直方向的下落速度
    protected float speedY = 0.05f;
    // 水平方向的下落速度
    protected float speedX = 0f;

    protected int width = 5; // 宽度
    protected int shapeAlpha = 100; // 透明度
    protected Paint paint;
    long lastTime = 0L; // 总共下落时间
    float originX = 0f; // 原始x坐标位置
    float originY = 0f; // 原始y坐标位置

    private int screenWidth = ScreenUtil.width;
    private int screenHeight = ScreenUtil.height;

    public WeatherShape(PointF start, PointF end) {
        this.start = start;
        this.end = end;
    }

    /**
     * 获取加速度
     *
     * @return 返回速度
     */
    public abstract float getAcceleration();

    /**
     * 随机速度
     *
     * @param random 随机
     * @return 用户计算出的随机速度
     */
    public abstract float randomSpeed(Random random);

    /**
     * 具体实现类复写该方法
     */
    public abstract void drawWhenInUse(Canvas canvas);

    public void draw(Canvas canvas) {
        if (!isInUse) {
            lastTime += randomPre();
            initStyle();
            isInUse = true;
        } else drawWhenInUse(canvas);
    }

    public void initStyle() {
        Random random = new Random();
        // 随机透明度
        shapeAlpha = random.nextInt(155) + 50;
        // 获得起始点x偏移
        int translateX = random.nextInt(10) + 5;
        if (!isRandom) {
            start.x = translateX + originX;
            end.x = translateX + originX;
        } else {
            // 随机 Shape，将 x 坐标随机范围扩大到整个屏幕的宽度
            int randomWidth = random.nextInt(screenWidth);
            start.x = randomWidth;
            end.x = randomWidth;
        }

        speedX = randomSpeed(random);

        paint = new Paint();
        paint.setAlpha(shapeAlpha);
        paint.setStrokeWidth(width);
        paint.setAntiAlias(true);

        wtc(random);
    }

    /**
     * 空实现，如果有什么想要追加的可以复写这个方法，当然你可以选择自己复写
     * initStyle 更加彻底
     */
    public void wtc(Random random) {

    }


    public long randomPre() {
        Random random = new Random();
        int pre = random.nextInt(100);
        return pre;
    }
}
