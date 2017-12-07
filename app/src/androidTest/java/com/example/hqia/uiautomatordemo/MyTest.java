package com.example.hqia.uiautomatordemo;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.os.SystemClock.sleep;

/**
 * Created by Hqia on 2017/12/07.
 */
@RunWith(AndroidJUnit4.class)
public class MyTest {
    private UiDevice myuidevice = null;
    private Context mycontext = null;
    private Instrumentation myinstrumentation = null;
//    String testAPP = "com.example.hqia.myapplication";
    String testAPP = "com.android.settings";

    @Before
    public void ready() throws RemoteException {
        // 获取设备对象
        myinstrumentation = InstrumentationRegistry.getInstrumentation();
        myuidevice = UiDevice.getInstance(myinstrumentation);
        // 获取上下文
        mycontext = myinstrumentation.getContext();
        if (!myuidevice.isScreenOn()) {  //唤醒屏幕
            myuidevice.wakeUp();
        }
        myuidevice.pressHome();  //按home键
    }

    @Test
    public void test1() throws RemoteException {
        // 启动测试App
        Intent myintent = mycontext.getPackageManager().getLaunchIntentForPackage(testAPP);
        mycontext.startActivity(myintent);
        myuidevice.waitForWindowUpdate(testAPP, 10000);
/*        sleep(3000);
        for (char i = 0; i < 3; i++) {
            myuidevice.pressRecentApps();
            sleep(8000);
        }*/
    }
}