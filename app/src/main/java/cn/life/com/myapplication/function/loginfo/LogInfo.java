package cn.life.com.myapplication.function.loginfo;

import android.content.Context;
import android.content.Intent;

import cn.life.com.myapplication.R;
import cn.life.com.myapplication.interfaces.Category;
import cn.life.com.myapplication.interfaces.IKit;


/**
 * Created by wanglikun on 2018/10/9.
 */

public class LogInfo implements IKit {

    @Override
    public int getCategory() {
        return Category.TOOLS;
    }

    @Override
    public int getName() {
        return  R.string.dk_kit_log_info;
    }

    @Override
    public int getIcon() {
        return  R.drawable.dk_log_info;
    }

    @Override
    public void onClick(Context context) {
    }

    @Override
    public void onAppInit(Context context) {
    }

}