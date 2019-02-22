package cn.life.com.myapplication.function.ram;

import android.content.Context;

import cn.life.com.myapplication.R;
import cn.life.com.myapplication.interfaces.Category;
import cn.life.com.myapplication.interfaces.IKit;

public class Ram implements IKit {
    @Override
    public int getCategory() {
        return Category.PERFORMANCE;
    }

    @Override
    public int getName() {
        return R.string.dk_frameinfo_ram;
    }

    @Override
    public int getIcon() {
        return R.drawable.dk_ram;
    }

    @Override
    public void onClick(Context context) {
    }

    @Override
    public void onAppInit(Context context) {

    }
}
