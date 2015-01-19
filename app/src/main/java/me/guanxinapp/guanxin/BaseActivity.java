package me.guanxinapp.guanxin;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Toast;

/**
 * Created by Towry Wang on 2015/1/19.
 */
public abstract class BaseActivity extends FragmentActivity {
    protected BaseApplication mApplication;

    /**
     * Screen width, height, density
     */
    protected int mScreenWidth;
    protected int mScreenHeight;
    protected float mDensity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication = (BaseApplication) getApplication();

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        mScreenWidth = metrics.widthPixels;
        mScreenHeight = metrics.heightPixels;
        mDensity = metrics.density;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * Init views
     */
    protected abstract void initViews();

    /**
     * Bind events
     */
    protected abstract void bindEvents();

    /**
     * Show short Toast from resource id
     */
    protected void showShortToast(int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show();
    }

    /**
     * Show short Toast from string
     */
    protected void showShortToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    /**
     * Show long Toast from resource id
     */
    protected void showLongToast(int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_LONG).show();
    }

    /**
     * Show long Toast from string
     */
    protected void showLongToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
