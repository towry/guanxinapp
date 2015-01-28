package me.guanxinapp.guanxin.component;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.concurrent.ScheduledFuture;

/**
 * Created by Towry Wang on 2015/1/28.
 */
public class AppActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

    private static final int SCHEDULE_DELAY_MILLS = 3000;
    private static final int FETCH_PERIOD_SECONDS = 30;

    private int visibleActivityCount = 0;

    private Handler uiHandler = new Handler(Looper.getMainLooper());
    private ScheduledFuture scheduledFuture;

    public AppActivityLifecycleCallbacks() {

    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Log.i("INFO", "Activity is created, class name : " + activity.getClass().getSimpleName());
    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.i("INFO", "Activity is started, class name : " + activity.getClass().getSimpleName());
        if (visibleActivityCount == 0) {
            startFetchUnread();
        }
        visibleActivityCount++;
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.i("INFO", "Activity is stopped,  class name : " + activity.getClass().getSimpleName());
        visibleActivityCount--;
        if (visibleActivityCount == 0) {
            stopFetchUnread();
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Log.i("INFO", "Activity saved instance state, class name : " + activity.getClass().getSimpleName());
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.i("INFO", "Activity is destroyed, class name : " + activity.getClass().getSimpleName());
    }

    private void startFetchUnread() {

    }

    private void stopFetchUnread() {

    }
}
