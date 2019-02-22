package cn.life.com.myapplication.function.blockmonitor;

import android.content.Context;

import cn.life.com.myapplication.R;
import cn.life.com.myapplication.interfaces.Category;
import cn.life.com.myapplication.interfaces.IKit;

/**
 * @desc: 卡顿检测kit
 */
public class BlockMonitorKit implements IKit {

    @Override
    public int getCategory() {
        return Category.PERFORMANCE;
    }

    @Override
    public int getName() {
        return R.string.dk_kit_block_monitor;
    }

    @Override
    public int getIcon() {
        return R.drawable.dk_block_monitor;
    }


    @Override
    public void onClick(Context context) {
    }

    @Override
    public void onAppInit(Context context) {

    }
}
