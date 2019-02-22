package cn.life.com.myapplication;

import android.content.Context;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import cn.life.com.myapplication.base.BaseFloatPage;
import cn.life.com.myapplication.base.PageIntent;
import cn.life.com.myapplication.utils.LogHelper;

/**
 * @author wangwei
 */

public class FloatPageManager {
    private static final String TAG = "FloatPageManager";

    private WindowManager mWindowManager;
    private Context mContext;
    private List<BaseFloatPage> mPages = new ArrayList<>();

    /**
     * 悬浮初始化
     *
     * @param app
     */
    public void init(App app) {
        mContext = app.getApplicationContext();
        mWindowManager = (WindowManager) app.getSystemService(Context.WINDOW_SERVICE);
    }

    public void remove(BaseFloatPage baseFloatPage) {

    }

    public void add(PageIntent pageIntent) {
        try {
            if (pageIntent == null || pageIntent.targetClass == null) {
                return;
            }
            //当要打开的界面是单个模式，判断是否有实例，已经有实例则返回
            if (pageIntent.mode == PageIntent.MODE_SINGLE_INSTANCE) {
                for (BaseFloatPage page : mPages) {
                    if (pageIntent.targetClass.isInstance(page)) {
                        return;
                    }
                }
            }
            //创建一个view实例
            BaseFloatPage page = pageIntent.targetClass.newInstance();
            page.setBundle(pageIntent.bundle);
            page.setTag(pageIntent.tag);
            mPages.add(page);
            page.performCreate(mContext);
            mWindowManager.addView(page.getRootView(), page.getLayoutParams());
        } catch (Exception e) {
            LogHelper.e(TAG, e.toString());
        }
    }

    private static class Holder {
        private static FloatPageManager INSTANCE = new FloatPageManager();
    }

    public static FloatPageManager getInstance() {
        return Holder.INSTANCE;
    }


    public void notifyForeground() {
        for (BaseFloatPage page : mPages) {
            page.onEnterForeground();
        }
    }

    public void notifyBackground() {
        for (BaseFloatPage page : mPages) {
            page.onEnterBackground();
        }
    }
}
