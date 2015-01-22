package me.guanxinapp.guanxin.activity.main;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import me.guanxinapp.guanxin.R;
import me.guanxinapp.guanxin.BaseActivity;
import me.guanxinapp.guanxin.fragment.StreamFragment;
import me.guanxinapp.guanxin.fragment.SettingFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    StreamFragment streamFragment;
    SettingFragment settingFragment;
    View streamView;
    View settingView;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        fragmentManager = getFragmentManager();
        setTabSelection(0);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void bindEvents() {
        // stream tab view
        streamView.setOnClickListener(this);
        // setting tab view
        settingView.setOnClickListener(this);
    }

    @Override
    protected void initViews() {
        // stream tab view
        streamView = findViewById(R.id.stream_layout);
        // setting tab view
        settingView = findViewById(R.id.setting_layout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.stream_layout:
                setTabSelection(0);
                break;
            case R.id.setting_layout:
                setTabSelection(3);
                break;
            default:
                setTabSelection(0);
                break;
        }
    }

    /**
     *
     */
    private void setTabSelection(int index) {
        clearSelection();

        // Open a fragment session
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // hide all fragments
        hideFragments(transaction);

        switch (index) {
            case 0:
                if (streamFragment == null) {
                    streamFragment = new StreamFragment();
                    transaction.add(R.id.content, streamFragment);
                } else {
                    transaction.show(streamFragment);
                }
                break;
            case 3:
                if (settingFragment == null) {
                    settingFragment = new SettingFragment();
                    transaction.add(R.id.content, settingFragment);
                } else {
                    transaction.show(settingFragment);
                }
                break;
            default:
                break;
        }
    }

    /**
     * Clear all state
     */
    private void clearSelection() {

    }

    /**
     * Hide all fragments
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (streamFragment != null) {
            transaction.hide(streamFragment);
        }
    }
}
