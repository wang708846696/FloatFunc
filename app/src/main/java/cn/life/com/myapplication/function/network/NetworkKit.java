package cn.life.com.myapplication.function.network;

import android.content.Context;
import android.content.Intent;

import cn.life.com.myapplication.R;
import cn.life.com.myapplication.interfaces.Category;
import cn.life.com.myapplication.interfaces.IKit;


/**
 * @desc: 网络监测kit
 */
public class NetworkKit implements IKit {

    @Override
    public int getCategory() {
        return Category.PERFORMANCE;
    }

    @Override
    public int getName() {
        return R.string.dk_kit_network_monitor;
    }

    @Override
    public int getIcon() {
        return R.drawable.dk_net_monitor;
    }


    @Override
    public void onClick(Context context) {
    }

    @Override
    public void onAppInit(Context context) {

    }
}
