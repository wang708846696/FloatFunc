package cn.life.com.myapplication.function.sysinfo;

import android.content.Context;

import cn.life.com.myapplication.R;
import cn.life.com.myapplication.interfaces.Category;
import cn.life.com.myapplication.interfaces.IKit;

/**
 * 设备、app信息
 * Created by zhangweida on 2018/6/22.
 */

public class SysInfo implements IKit {
    @Override
    public int getCategory() {
        return Category.TOOLS;
    }

    @Override
    public int getName() {
        return R.string.dk_kit_sysinfo;
    }

    @Override
    public int getIcon() {
        return R.drawable.dk_sys_info;
    }

    @Override
    public void onClick(Context context) {
//        Intent intent = new Intent(context, UniversalActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.putExtra(BundleKey.FRAGMENT_INDEX, FragmentIndex.FRAGMENT_SYS_INFO);
//        context.startActivity(intent);
    }

    @Override
    public void onAppInit(Context context) {

    }

}
