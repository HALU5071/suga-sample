package com.halu5071.sugarsample;

import android.app.Application;
import android.content.Context;

import com.orm.SugarApp;
import com.orm.SugarContext;

/**
 * Created by HALU on 2017/05/08.
 */

public class MyApplication extends SugarApp {

    @Override
    public void onCreate(){
        super.onCreate();
        SugarContext.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onTerminate(){
        super.onTerminate();
        SugarContext.terminate();
    }
}
