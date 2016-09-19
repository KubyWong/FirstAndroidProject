package com.example.kuby.myapplication;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Kuby on 2016/9/19.
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);

    }
}
