package cn.life.com.myapplication.function.dataclean;

import android.content.Context;
import android.content.Intent;

import cn.life.com.myapplication.R;
import cn.life.com.myapplication.interfaces.Category;
import cn.life.com.myapplication.interfaces.IKit;

/**
 * Created by wanglikun on 2018/11/17.
 */

public class DataClean implements IKit {
    @Override
    public int getCategory() {
        return Category.TOOLS;
    }

    @Override
    public int getName() {
        return R.string.dk_kit_data_clean;
    }

    @Override
    public int getIcon() {
        return R.drawable.dk_data_clean;
    }

    @Override
    public void onClick(Context context) {
    }

    @Override
    public void onAppInit(Context context) {

    }
}