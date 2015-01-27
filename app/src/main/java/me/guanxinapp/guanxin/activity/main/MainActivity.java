package me.guanxinapp.guanxin.activity.main;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import me.guanxinapp.guanxin.R;
import me.guanxinapp.guanxin.BaseActivity;
import me.guanxinapp.guanxin.fragment.FriendsFragment;
import me.guanxinapp.guanxin.fragment.StreamFragment;
import me.guanxinapp.guanxin.fragment.MeFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener,
        StreamFragment.OnFragmentInteractionListener,
        MeFragment.OnFragmentInteractionListener,
        FriendsFragment.OnFragmentInteractionListener {

    private StreamFragment streamFragment;
    private MeFragment meFragment;
    private FriendsFragment friendsFragment;
    private View streamView;
    private View meView;
    private View friendsView;
    private ImageView stream_icon;
    private ImageView friends_icon;
    private ImageView me_icon;
    private TextView stream_text;
    private TextView friends_text;
    private TextView me_text;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        fragmentManager = getFragmentManager();

        setTabSelection(0);
        bindEvents();
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
        // me tab view
        meView.setOnClickListener(this);
        // friends tab view
        friendsView.setOnClickListener(this);
    }

    @Override
    protected void initViews() {
        // stream tab view
        streamView = findViewById(R.id.stream_layout);
        stream_icon = (ImageView) findViewById(R.id.stream_icon);
        stream_text = (TextView) findViewById(R.id.stream_text);
        // me tab view
        meView = findViewById(R.id.me_layout);
        me_icon = (ImageView) findViewById(R.id.me_icon);
        me_text = (TextView) findViewById(R.id.me_text);
        // friends tab view
        friendsView = findViewById(R.id.friends_layout);
        friends_icon = (ImageView) findViewById(R.id.friends_icon);
        friends_text = (TextView) findViewById(R.id.friends_text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.stream_layout:
                setTabSelection(0);
                break;
            case R.id.friends_layout:
                setTabSelection(1);
                break;
            case R.id.me_layout:
                setTabSelection(2);
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
                stream_icon.setImageResource(R.drawable.icon_user_pressed);
                stream_text.setTextColor(getResources().getColor(R.color.bottom_bar_text_selected));
                if (streamFragment == null) {
                    streamFragment = StreamFragment.newInstance(null, null);
                    transaction.add(R.id.content, streamFragment);
                } else {
                    transaction.show(streamFragment);
                }
                break;
            case 1:
                friends_icon.setImageResource(R.drawable.icon_user_pressed);
                friends_text.setTextColor(getResources().getColor(R.color.bottom_bar_text_selected));
                if (friendsFragment == null) {
                    friendsFragment = FriendsFragment.newInstance(null, null);
                    transaction.add(R.id.content, friendsFragment);
                } else {
                    transaction.show(friendsFragment);
                }
                break;
            case 2:
                me_icon.setImageResource(R.drawable.icon_user_pressed);
                me_text.setTextColor(getResources().getColor(R.color.bottom_bar_text_selected));
                if (meFragment == null) {
                    meFragment = MeFragment.newInstance(null, null);
                    transaction.add(R.id.content, meFragment);
                } else {
                    transaction.show(meFragment);
                }
                break;
            default:
                break;
        }

        transaction.commit();
    }

    /**
     * Clear all state
     */
    private void clearSelection() {
        stream_icon.setImageResource(R.drawable.icon_user_normal);
        stream_text.setTextColor(getResources().getColor(R.color.bottom_bar_text));

        friends_icon.setImageResource(R.drawable.icon_user_normal);
        friends_text.setTextColor(getResources().getColor(R.color.bottom_bar_text));

        me_icon.setImageResource(R.drawable.icon_user_normal);
        me_text.setTextColor(getResources().getColor(R.color.bottom_bar_text));
    }

    /**
     * Hide all fragments
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (streamFragment != null) {
            transaction.hide(streamFragment);
        }
        if (meFragment != null) {
            transaction.hide(meFragment);
        }
        if (friendsFragment != null) {
            transaction.hide(friendsFragment);
        }
    }

    public void onFragmentInteraction(Uri uri) {

    }
}
