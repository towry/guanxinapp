package me.guanxinapp.guanxin.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import me.guanxinapp.guanxin.R;
import me.guanxinapp.guanxin.activity.stream.StreamItem;
import me.guanxinapp.guanxin.entity.Entity;
import me.guanxinapp.guanxin.entity.Status;
import me.guanxinapp.guanxin.foundation.BaseListAdapter;
import me.guanxinapp.guanxin.view.TimeTextView;
import me.guanxinapp.guanxin.foundation.BaseApplication;

/**
 * Created by Towry Wang on 2015/1/29.
 */
public class StreamAdapter extends BaseListAdapter {

    public StreamAdapter(BaseApplication application, Context context, List<? extends Entity> data) {
        super(application, context, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Status status = (Status) getItem(position);
        StreamItem streamItem = StreamItem.getInstance(status, mContext, convertView, parent);

        streamItem.fillContent();

        return streamItem.getRootView();
    }
}
