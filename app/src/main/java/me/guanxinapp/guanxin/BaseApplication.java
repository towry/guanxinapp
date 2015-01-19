package me.guanxinapp.guanxin;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

/**
 * Created by Towry Wang on 2015/1/19.
 */
public class BaseApplication extends Application {
    private Bitmap mDefaultAvatar;
    private static final String AVATAR_DIR = "avatar/";

    @Override
    public void onCreate() {
        super.onCreate();
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
}
