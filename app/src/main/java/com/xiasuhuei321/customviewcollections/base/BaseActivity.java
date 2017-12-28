package com.xiasuhuei321.customviewcollections.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by xiasuhuei321 on 2017/12/28.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */

public class BaseActivity extends AppCompatActivity {
    public void startActivity(Class clz) {
        startActivity(new Intent(this, clz));
    }
}
