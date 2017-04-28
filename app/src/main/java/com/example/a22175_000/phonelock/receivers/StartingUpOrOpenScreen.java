package com.example.a22175_000.phonelock.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.a22175_000.phonelock.activities.LockScreen;

/**
 * Created by 22175_000 on 2017/2/20.
 */

public class StartingUpOrOpenScreen extends BroadcastReceiver {
    private static final String TAG = ">>>>";
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Intent.ACTION_BOOT_COMPLETED.equals(action)) {
            Log.i(TAG, "开机广播");
            Intent intent1 = new Intent();
            intent1.setClass(context, LockScreen.class);
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        }
        if (Intent.ACTION_SCREEN_ON.equals(action)) {
            Log.i(TAG, "开屏广播");
            System.out.println(">>>>> screen on ");
            Toast.makeText(context, "开屏广播", Toast.LENGTH_SHORT).show();
        }
    }
}
