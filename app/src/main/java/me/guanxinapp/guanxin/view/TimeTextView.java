package me.guanxinapp.guanxin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import me.guanxinapp.guanxin.support.utils.TimeUtility;

/**
 * Created by Towry Wang on 2015/1/29.
 */
public class TimeTextView extends TextView {

    public TimeTextView(Context context) {
        super(context);
    }

    public TimeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public TimeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setTime(long mills) {
        String time = TimeUtility.getListTime(mills);
        if (!getText().toString().equals(time)) {
            setText(time);
        }
    }
}
