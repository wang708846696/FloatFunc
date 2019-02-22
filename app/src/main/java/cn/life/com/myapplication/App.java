package cn.life.com.myapplication;

import android.app.Application;

/**
 * @author wangwei
 */

public class App extends Application {
    private static final String TAG = "App";

    @Override
    public void onCreate() {
        super.onCreate();
        DoraemonKit.install(this);
    }
}
