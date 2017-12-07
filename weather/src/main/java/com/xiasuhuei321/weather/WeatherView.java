package com.xiasuhuei321.weather;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by xiasuhuei321 on 2017/12/2.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */

public class WeatherView extends SurfaceView implements SurfaceHolder.Callback {
    public static final String TAG = "WeatherView";

    private int[] RAIN_D = new int[]{0xff4f80a0, 0xff4d748e};
    private GradientDrawable skyBackground =
            new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, RAIN_D);

    private Object lock = new Object();
    private volatile boolean canRun = false;
    private volatile boolean threadQuit = false;
    private Weather type = Weather.RAIN;

    private Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            while (!threadQuit) {
                if (!canRun) {
                    synchronized (lock) {
                        try {
                            Log.i(TAG, "条件尚不充足，阻塞中...");
                            lock.wait();
                        } catch (Exception e) {
                        }
                    }
                }

                long startTime = System.currentTimeMillis();
                try {
                    Canvas canvas = holder.lockCanvas();
                    if (canvas != null) {
                        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                        // 这种方式绘制比较卡，换一种
//                    canvas.drawColor(context.resources.getColor(R.color.sky_blue), PorterDuff.Mode.DST_OVER)
                        skyBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                        skyBackground.draw(canvas);
                        draw(canvas, type);
                    }
                    holder.unlockCanvasAndPost(canvas);
                    long drawTime = System.currentTimeMillis() - startTime;
                    // 平均16ms一帧
                    if (drawTime < 16) Thread.sleep(16 - drawTime);
                } catch (Exception e) {
                }
            }
        }
    }, "WeatherThread");
    private SurfaceHolder holder;

    public WeatherView(Context context) {
        this(context, null);
    }

    public WeatherView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WeatherView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        holder = getHolder();
        holder.addCallback(this);
        holder.setFormat(PixelFormat.TRANSLUCENT);
        thread.start();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        canRun = true;
        threadQuit = false;

        // 背景在这里绘制一下，不然可能会出现各种奇妙的情况
        Canvas canvas = getHolder().lockCanvas();
        skyBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        skyBackground.draw(canvas);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        canRun = true;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // 释放资源
        canRun = false;
        Log.i(TAG, "surfaceDestroyed");
    }

    /**
     * 绘制
     *
     * @param canvas  画布
     * @param weather 天气类型
     */
    private void draw(Canvas canvas, Weather weather) {

    }

    public void setWeather(Weather weather) {
        this.type = weather;
    }

    enum Weather {
        RAIN, SNOW
    }
}
