package me.guanxinapp.guanxin.activity.stream;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.guanxinapp.guanxin.entity.Status;
import me.guanxinapp.guanxin.R;

/**
 * Created by Towry Wang on 2015/2/3.
 */
public abstract class StreamItem {

    protected Context mContext;
    protected View mRootView;
    protected LayoutInflater mInflater;
    protected Status mStatus;

    public StreamItem(Status status, Context context) {
        mStatus = status;
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public static StreamItem getInstance(Status status, Context context,
                                         View convertView, ViewGroup parent) {
        StreamItem streamItem = null;

        streamItem = new StatusItem(status, context);

        streamItem.init(convertView, parent);

        return streamItem;
    }

    private void init(View convertView, ViewGroup parent) {
        if (mRootView == null) {
            prepareViews(convertView, parent);
        }
    }

    protected void prepareViews(View convertView, ViewGroup parent) {
        initViews(convertView, parent);
        onInitViews();
    }

    public void fillContent() {
        fillStatus();
    }

    protected void fillStatus() {
        onFillStatus();
    }

    public View getRootView() {
        return mRootView;
    }

    protected abstract void initViews(View convertView, ViewGroup parent);

    protected abstract void onInitViews();

    protected abstract void onFillStatus();
}
