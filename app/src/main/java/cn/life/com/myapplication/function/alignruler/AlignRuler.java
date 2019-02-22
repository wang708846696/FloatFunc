package cn.life.com.myapplication.function.alignruler;

import android.content.Context;

import cn.life.com.myapplication.R;
import cn.life.com.myapplication.interfaces.Category;
import cn.life.com.myapplication.interfaces.IKit;

/**
 * Created by wanglikun on 2018/9/19.
 */

public class AlignRuler implements IKit {
    @Override
    public int getCategory() {
        return Category.UI;
    }

    @Override
    public int getName() {
        return R.string.dk_kit_align_ruler;
    }

    @Override
    public int getIcon() {
        return R.drawable.dk_align_ruler;
    }

    @Override
    public void onClick(Context context) {
    }

    @Override
    public void onAppInit(Context context) {
    }
}
