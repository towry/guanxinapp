package me.guanxinapp.guanxin.activity;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Button;

import me.guanxinapp.guanxin.BaseActivity;
import me.guanxinapp.guanxin.R;

/**
 * Created by Towry Wang on 2015/1/19.
 */
public class WelcomeActivity extends BaseActivity implements View.OnClickListener {
    RelativeLayout mRelativeLayout;
    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initViews();
        bindEvents();
        setIndexColor();
    }

    @Override
    protected void initViews() {
        mRelativeLayout = (RelativeLayout) findViewById(R.id.welcome_layout);
        mBtn = (Button) findViewById(R.id.qq_login_btn);
    }

    @Override
    protected void bindEvents() {
        mRelativeLayout.setOnClickListener(this);
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // showShortToast(R.string.hello_world);
        switch (v.getId()) {

            case R.id.qq_login_btn:
                startActivity(MainActivity.class);
                break;

        }
    }

    private void setIndexColor() {
        TextView textView = (TextView) findViewById(R.id.logo_index_id);
        Spannable wordToSpan = new SpannableString(getResources().getString(R.string.welcome_dear));
        wordToSpan.setSpan(new ForegroundColorSpan(R.color.logo_text_guanxin), 1, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(wordToSpan);
    }
}
