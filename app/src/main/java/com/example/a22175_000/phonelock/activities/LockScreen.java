package com.example.a22175_000.phonelock.activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.example.a22175_000.phonelock.R;

/**
 * Created by 22175_000 on 2017/2/20.
 */

public class LockScreen extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_lock_screen);
    }
}
