package cn.life.com.myapplication.function.frameInfo;

import android.content.Context;
import android.content.Intent;

import cn.life.com.myapplication.R;
import cn.life.com.myapplication.interfaces.Category;
import cn.life.com.myapplication.interfaces.IKit;


/**
 * Created by wanglikun on 2018/9/13.
 */

public class FrameInfo implements IKit {

    @Override
    public int getCategory() {
        return Category.PERFORMANCE;
    }

    @Override
    public int getName() {
        return R.string.dk_kit_frame_info;
    }

    @Override
    public int getIcon() {
        return R.drawable.dk_frame_hist;
    }

    @Override
    public void onClick(Context context) {
    }

    @Override
    public void onAppInit(Context context) {

    }

}
