package com.xiasuhuei321.weather;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

/**
 * Created by xiasuhuei321 on 2017/12/6.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */

public class ScreenUtil {
    public static int width = -1;
    public static int height = -1;

    public static void init(Context context){
        width = getScreenWidth(context);
        height = getScreenHeight(context);
    }

    private static int getScreenWidth(Context context) {
        if (width == -1) {
            WindowManager window = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Point point = new Point(0, 0);
            window.getDefaultDisplay().getSize(point);
            width = point.x;
        }

        return width;
    }

    private static int getScreenHeight(Context context) {
        if (height == -1) {
            WindowManager window = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Point point = new Point(0, 0);
            window.getDefaultDisplay().getSize(point);
            height = point.y;
        }

        return height;
    }
}
