package me.guanxinapp.guanxin.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import me.guanxinapp.guanxin.R;
import me.guanxinapp.guanxin.view.TimeTextView;
import me.guanxinapp.guanxin.foundation.BaseApplication;
import me.guanxinapp.guanxin.support.utils.RoundedAvatarDrawable;

/**
 * Created by Towry Wang on 2015/1/29.
 */
public class StreamAdapter extends BaseAdapter {

    Context context;
    String[] data;
    private static LayoutInflater inflater = null;

    public StreamAdapter(Context context, String[] data) {
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null) {
            vi = inflater.inflate(R.layout.stream_listview_item, null);
        }

        TextView text = (TextView) vi.findViewById(R.id.stream_user_name);
        text.setText(data[position]);

        TextView text2 = (TextView) vi.findViewById(R.id.stream_text);
        text.setText("Sleeping...");

        TimeTextView timeTextView = (TimeTextView) vi.findViewById(R.id.stream_time);
        timeTextView.setTime(System.currentTimeMillis());

        ImageView imageView = (ImageView) vi.findViewById(R.id.stream_avatar);

        try {
            InputStream ims = BaseApplication.getInstance().getAssets().open("avatar/avatar2.jpg");
            Bitmap bitmap = BitmapFactory.decodeStream(ims);
            RoundedAvatarDrawable d = new RoundedAvatarDrawable(bitmap);
            imageView.setImageDrawable(d);
        } catch (IOException e) {
        }

        return vi;
    }
}
