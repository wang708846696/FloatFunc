package cn.life.com.myapplication.function.gps;

import android.content.Context;
import android.content.Intent;

import cn.life.com.myapplication.R;
import cn.life.com.myapplication.interfaces.Category;
import cn.life.com.myapplication.interfaces.IKit;

/**
 * Created by wanglikun on 2018/9/20.
 */

public class GpsMock implements IKit {
    @Override
    public int getCategory() {
        return Category.TOOLS;
    }

    @Override
    public int getName() {
        return R.string.dk_kit_gps_mock;
    }

    @Override
    public int getIcon() {
        return  R.drawable.dk_gps_mock;
    }

    @Override
    public void onClick(Context context) {
    }

    @Override
    public void onAppInit(Context context) {
    }

}