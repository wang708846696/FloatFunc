package cn.life.com.myapplication.function.viewcheck;

import android.content.Context;

import cn.life.com.myapplication.R;
import cn.life.com.myapplication.interfaces.Category;
import cn.life.com.myapplication.interfaces.IKit;


/**
 * Created by wanglikun on 2018/11/20.
 */

public class ViewChecker implements IKit {
    @Override
    public int getCategory() {
        return Category.UI;
    }

    @Override
    public int getName() {
        return R.string.dk_kit_view_check;
    }

    @Override
    public int getIcon() {
        return R.drawable.dk_view_check;
    }

    @Override
    public void onClick(Context context) {
    }

    @Override
    public void onAppInit(Context context) {
    }
}