package cn.life.com.myapplication.callback;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * @author wangwei
 */

public abstract class AbsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
