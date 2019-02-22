package cn.life.com.myapplication.function.cpu;

import android.content.Context;
import android.content.Intent;

import cn.life.com.myapplication.R;
import cn.life.com.myapplication.interfaces.Category;
import cn.life.com.myapplication.interfaces.IKit;

public class Cpu implements IKit {
    @Override
    public int getCategory() {
        return Category.PERFORMANCE;
    }

    @Override
    public int getName() {
        return R.string.dk_frameinfo_cpu;
    }

    @Override
    public int getIcon() {
        return R.drawable.dk_cpu;
    }

    @Override
    public void onClick(Context context) {
    }

    @Override
    public void onAppInit(Context context) {

    }
}
