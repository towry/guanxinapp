package me.guanxinapp.guanxin.activity.stream;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

import me.guanxinapp.guanxin.R;
import me.guanxinapp.guanxin.entity.Status;
import me.guanxinapp.guanxin.view.TimeTextView;

/**
 * Created by Towry Wang on 2015/2/3.
 */
public class StatusItem extends StreamItem implements View.OnLongClickListener {

    private TextView mContentView;
    private ImageView mAvatarView;
    private TimeTextView mTimeTextView;
    private TextView mUserNameView;

    public StatusItem(Status status, Context context) {
        super(status, context);
    }

    @Override
    protected void onInitViews() {
        mContentView = (TextView) mRootView.findViewById(R.id.stream_text);
        mAvatarView = (ImageView) mRootView.findViewById(R.id.stream_avatar);
        mTimeTextView = (TimeTextView) mRootView.findViewById(R.id.stream_time);
        mUserNameView = (TextView) mRootView.findViewById(R.id.stream_user_name);
    }

    @Override
    protected void initViews(View convertView, ViewGroup parent) {
        mRootView = convertView;
        if (mRootView == null) {
            mRootView = mInflater.inflate(R.layout.stream_listview_item, null);
        }

        mRootView.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View view) {
        return true;
    }

    @Override
    protected void onFillStatus() {
        mContentView.setText(mStatus.getContent());
        mTimeTextView.setTime(mStatus.getTime());
        mUserNameView.setText(mStatus.getUserName());
        setAvatar(mAvatarView);
    }

    private void setAvatar(ImageView view) {
        String avatar = mStatus.getAvatar();
        InputStream ims = null;
        Drawable d = null;

        try {
            ims = mContext.getAssets().open(avatar);
            d = Drawable.createFromStream(ims, avatar);
            if (d == null) {
                throw new IOException("Failed to open avatar image file.");
            }

            view.setImageDrawable(d);
        } catch (IOException e) {
            // here we set default avatar
        }
    }
}
