package cn.life.com.myapplication.function.colorpick;

import android.content.Context;

import cn.life.com.myapplication.R;
import cn.life.com.myapplication.interfaces.Category;
import cn.life.com.myapplication.interfaces.IKit;

/**
 * Created by wanglikun on 2018/9/13.
 */

public class ColorPicker implements IKit {
    private static final String TAG = "ColorPicker";

    @Override
    public int getCategory() {
        return Category.UI;
    }

    @Override
    public int getName() {
        return R.string.dk_kit_color_picker;
    }

    @Override
    public int getIcon() {
        return R.drawable.dk_color_picker;
    }

    @Override
    public void onClick(Context context) {
    }

    @Override
    public void onAppInit(Context context) {
    }
}