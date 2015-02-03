package me.guanxinapp.guanxin.foundation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import me.guanxinapp.guanxin.entity.Entity;

/**
 * Created by Towry Wang on 2015/2/3.
 */
public class BaseListAdapter extends BaseAdapter {

    protected BaseApplication mApplication;
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected List<? extends Entity> mDataArray = new ArrayList<Entity>();

    /**
     * Constructor
     */
    public BaseListAdapter(BaseApplication application, Context context,
                           List<? extends Entity> data) {
        mApplication = application;
        mContext = context;
        mInflater = LayoutInflater.from(context);
        if (data != null) {
            mDataArray = data;
        }
    }

    @Override
    public int getCount() {
        return mDataArray.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    public List<? extends Entity> getData() {
        return mDataArray;
    }
}
