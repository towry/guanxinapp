package me.guanxinapp.guanxin.foundation;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Toast;
import android.content.Intent;

/**
 * Created by Towry Wang on 2015/1/19.
 */
public abstract class BaseActivity extends ActionBarActivity {
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
    public void showShortToast(int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show();
    }

    /**
     * Show short Toast from string
     */
    public void showShortToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    /**
     * Show long Toast from resource id
     */
    public void showLongToast(int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_LONG).show();
    }

    /**
     * Show long Toast from string
     */
    public void showLongToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    /**
     * Redirect by class
     */
    protected void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * Redirect by Class with bundle
     */
    protected void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * Redirect by action
     */
    protected void startActivity(String action) {
        startActivity(action, null);
    }

    /**
     * Redirect by action with bundle
     */
    protected void startActivity(String action, Bundle bundle) {
        Intent intent = new Intent();
        intent.setAction(action);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
}
