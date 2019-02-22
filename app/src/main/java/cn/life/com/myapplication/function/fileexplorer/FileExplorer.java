package cn.life.com.myapplication.function.fileexplorer;

import android.content.Context;

import cn.life.com.myapplication.R;
import cn.life.com.myapplication.interfaces.Category;
import cn.life.com.myapplication.interfaces.IKit;

public class FileExplorer implements IKit {
    @Override
    public int getCategory() {
        return Category.TOOLS;
    }

    @Override
    public int getName() {
        return R.string.dk_kit_file_explorer;
    }

    @Override
    public int getIcon() {
        return R.drawable.dk_file_explorer;
    }

    @Override
    public void onClick(Context context) {
    }

    @Override
    public void onAppInit(Context context) {

    }

}
