package cn.life.com.myapplication.function.layoutborder;

import android.content.Context;

import cn.life.com.myapplication.FloatPageManager;
import cn.life.com.myapplication.R;
import cn.life.com.myapplication.interfaces.Category;
import cn.life.com.myapplication.interfaces.IKit;

/**
 * Created by wanglikun on 2019/1/7
 */
public class LayoutBorder implements IKit {
    @Override
    public int getCategory() {
        return Category.UI;
    }

    @Override
    public int getName() {
        return R.string.dk_kit_layout_border;
    }

    @Override
    public int getIcon() {
        return R.drawable.dk_view_border;
    }

    @Override
    public void onClick(Context context) {
    }

    @Override
    public void onAppInit(Context context) {
    }
}