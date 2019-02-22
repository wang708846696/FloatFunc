package cn.life.com.myapplication.function.temporaryclose;

import android.content.Context;

import cn.life.com.myapplication.R;
import cn.life.com.myapplication.interfaces.Category;
import cn.life.com.myapplication.interfaces.IKit;

/**
 * Created by wanglikun on 2018/10/26.
 */

public class TemporaryClose implements IKit {
    @Override
    public int getCategory() {
        return Category.CLOSE;
    }

    @Override
    public int getName() {
        return R.string.dk_kit_temporary_close;
    }

    @Override
    public int getIcon() {
        return R.drawable.dk_temporary_close;
    }

    @Override
    public void onClick(Context context) {
    }

    @Override
    public void onAppInit(Context context) {

    }

}
