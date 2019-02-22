package cn.life.com.myapplication.interfaces;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;


public interface IKit {
    int getCategory();

    @StringRes
    int getName();

    @DrawableRes
    int getIcon();

    void onClick(Context context);

    void onAppInit(Context context);
}
