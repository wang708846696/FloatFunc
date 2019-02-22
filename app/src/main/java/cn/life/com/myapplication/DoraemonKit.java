package cn.life.com.myapplication;

import android.app.Activity;
import android.os.Build;
import android.util.SparseArray;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import cn.life.com.myapplication.base.PageIntent;
import cn.life.com.myapplication.callback.AbsActivityLifecycleCallbacks;
import cn.life.com.myapplication.function.alignruler.AlignRuler;
import cn.life.com.myapplication.function.blockmonitor.BlockMonitorKit;
import cn.life.com.myapplication.function.colorpick.ColorPicker;
import cn.life.com.myapplication.function.cpu.Cpu;
import cn.life.com.myapplication.function.crash.Crash;
import cn.life.com.myapplication.function.dataclean.DataClean;
import cn.life.com.myapplication.function.fileexplorer.FileExplorer;
import cn.life.com.myapplication.function.gps.GpsMock;
import cn.life.com.myapplication.function.layoutborder.LayoutBorder;
import cn.life.com.myapplication.function.loginfo.LogInfo;
import cn.life.com.myapplication.function.network.NetworkKit;
import cn.life.com.myapplication.function.ram.Ram;
import cn.life.com.myapplication.function.sysinfo.SysInfo;
import cn.life.com.myapplication.function.temporaryclose.TemporaryClose;
import cn.life.com.myapplication.function.viewcheck.ViewChecker;
import cn.life.com.myapplication.function.webdoor.WebDoor;
import cn.life.com.myapplication.interfaces.Category;
import cn.life.com.myapplication.interfaces.IKit;
import cn.life.com.myapplication.ui.FloatIconPage;
import cn.life.com.myapplication.utils.DoraemonStatisticsUtil;
import cn.life.com.myapplication.utils.PermissionUtil;

/**
 * @author wangwei
 */

class DoraemonKit {


    private static boolean sHasInit = false;
    private static boolean sShowFloatingIcon = true;
    private static WeakReference<Activity> sCurrentResumedActivity;
    private static boolean sHasRequestPermission;
    private static SparseArray<List<IKit>> sKitMap = new SparseArray<>();

    public interface ActivityLifecycleListener {
        void onActivityResumed(Activity activity);

        void onActivityPaused(Activity activity);
    }

    private static AbsActivityLifecycleCallbacks mAbsActivityLifecycleCallbacks = new AbsActivityLifecycleCallbacks() {
        volatile int startedActivityCounts;

        @Override
        public void onActivityStarted(Activity activity) {
            if (startedActivityCounts == 0) {
                FloatPageManager.getInstance().notifyForeground();
            }
            startedActivityCounts++;
        }

        @Override
        public void onActivityResumed(Activity activity) {
            if (PermissionUtil.canDrawOverlays(activity)) {
                if (sShowFloatingIcon) {
                    showFloatIcon(activity);
                }
            } else {
                requestPermission(activity);
            }
            for (ActivityLifecycleListener listener : sListeners) {
                listener.onActivityResumed(activity);
            }
            sCurrentResumedActivity = new WeakReference<>(activity);
        }

        @Override
        public void onActivityPaused(Activity activity) {
            for (ActivityLifecycleListener listener : sListeners) {
                listener.onActivityPaused(activity);
            }
            sCurrentResumedActivity = null;
        }

        @Override
        public void onActivityStopped(Activity activity) {
            startedActivityCounts--;
            if (startedActivityCounts == 0) {
                FloatPageManager.getInstance().notifyBackground();
            }
        }
    };

    private static List<ActivityLifecycleListener> sListeners = new ArrayList<>();

    public static void install(App app) {
        if (sHasInit) {
            return;
        }
        sHasInit = true;
        app.registerActivityLifecycleCallbacks(mAbsActivityLifecycleCallbacks);
        sKitMap.clear();
        List<IKit> tool = new ArrayList<>();
        List<IKit> ui = new ArrayList<>();
        List<IKit> performance = new ArrayList<>();
        List<IKit> exit = new ArrayList<>();
        //添加工具
        tool.add(new SysInfo());
        tool.add(new FileExplorer());
        tool.add(new GpsMock());
        tool.add(new WebDoor());
        tool.add(new Crash());
        tool.add(new LogInfo());
        tool.add(new DataClean());
        //添加性能
        performance.add(new Cpu());
        performance.add(new Ram());
        performance.add(new NetworkKit());
        performance.add(new BlockMonitorKit());

        //添加ui
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ui.add(new ColorPicker());
        }

        ui.add(new AlignRuler());
        ui.add(new ViewChecker());
        ui.add(new LayoutBorder());
        //添加退出
        exit.add(new TemporaryClose());

        for (IKit kit : performance) {
            kit.onAppInit(app);
        }
        for (IKit kit : tool) {
            kit.onAppInit(app);
        }
        for (IKit kit : ui) {
            kit.onAppInit(app);
        }

        sKitMap.put(Category.PERFORMANCE, performance);
        sKitMap.put(Category.TOOLS, tool);
        sKitMap.put(Category.UI, ui);
        sKitMap.put(Category.CLOSE, exit);
        //初始化悬浮
        FloatPageManager.getInstance().init(app);
        DoraemonStatisticsUtil.uploadUserInfo(app);
    }

    private static void showFloatIcon(Activity activity) {
        PageIntent intent = new PageIntent(FloatIconPage.class);
        intent.mode = PageIntent.MODE_SINGLE_INSTANCE;
        FloatPageManager.getInstance().add(intent);
    }

    /**
     * 申请覆盖应用权限
     *
     * @param
     */
    private static void requestPermission(Activity context) {
        if (!PermissionUtil.canDrawOverlays(context) && !sHasRequestPermission) {
            Toast.makeText(context, context.getText(R.string.dk_float_permission_toast), Toast.LENGTH_SHORT).show();
            PermissionUtil.requestDrawOverlays(context);
            sHasRequestPermission = true;
        }
    }
}
