package com.example.a22175_000.phonelock.utils;

import android.app.ActivityManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.os.Build;

import java.util.List;

/**
 * Created by 22175_000 on 2017/2/6.
 */

public class ActivityMonitor {

    private static ActivityManager activityManager;
    private static ActivityMonitor activityMonitor = new ActivityMonitor();
    private static Context mContext;

    private ActivityMonitor() {

    }

    public static ActivityMonitor getInstantiation(Context context) {
        mContext = context;
        activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        return activityMonitor;
    }

    /**
     * 获取当前显示的activity包名
     *
     * @return String packageName
     */
    public String getCurrentShowActiPgNm() {
        String packageName = "";
        int j = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            UsageStatsManager usageStatsManager = (UsageStatsManager) mContext.getSystemService(Context.USAGE_STATS_SERVICE);
            long endTime = System.currentTimeMillis();
            long startTime = endTime - 60 * 1000;
            List<UsageStats> usageStatsList = usageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_BEST
                    , startTime, endTime);
            if (usageStatsList.size() != 0 || !usageStatsList.isEmpty()) {
                for (int i = 0; i < usageStatsList.size(); i++) {
                    if (usageStatsList.get(i).getLastTimeUsed() > usageStatsList.get(j).getLastTimeUsed()) {
                        j = i;
                        break;
                    }
                }
                packageName = usageStatsList.get(j).getPackageName();
            }
        } else {
            List<ActivityManager.RunningTaskInfo> runningTaskInfos = activityManager.getRunningTasks(1);
            ActivityManager.RunningTaskInfo runningTaskInfo = runningTaskInfos.get(0);
            packageName = runningTaskInfo.topActivity.getPackageName();
        }
        return packageName;
    }

    /**
     * 获取系统正在运行的进程
     * @return
     *      List<ActivityManager.RunningAppProcessInfo>
     */
    public List<ActivityManager.RunningAppProcessInfo> getRunningProgress() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        return runningAppProcesses;
    }

}
