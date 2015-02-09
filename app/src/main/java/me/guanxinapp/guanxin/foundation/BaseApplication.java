package me.guanxinapp.guanxin.foundation;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import me.guanxinapp.guanxin.component.AppActivityLifecycleCallbacks;

/**
 * Created by Towry Wang on 2015/1/19.
 */
public class BaseApplication extends Application {

    /**
     * Singleton
     */
    private static BaseApplication mApplication = null;

    private Bitmap mDefaultAvatar;
    private static final String AVATAR_DIR = "avatar/";

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        registerActivityLifecycleCallbacks(new AppActivityLifecycleCallbacks());
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.e("BaseApplication", "onLowMemory");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.e("BaseApplication", "onTerminate");
    }

    /**
     * Singleton
     * @return BaseApplication
     */
    public static synchronized BaseApplication getInstance() {
        return mApplication;
    }
}
