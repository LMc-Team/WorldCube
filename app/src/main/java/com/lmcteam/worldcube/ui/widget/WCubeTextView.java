package com.lmcteam.worldcube.ui.widget;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

import com.lmcteam.worldcube.util.AssetsUtil;

public class WCubeTextView extends androidx.appcompat.widget.AppCompatTextView {

    private String mOriginalStr;
    private long mDuration = 500;
    private int mIndex = 0;
    private Handler mHandler;
    private final int SHOW_NEXT_CHAR = 1;


    public WCubeTextView(android.content.Context context) {
        super(context);
        init();
    }

    public WCubeTextView(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WCubeTextView(android.content.Context context, android.util.AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }


    @SuppressLint("HandlerLeak")
    public void init() {
        setTypeface(AssetsUtil.getTypeface());
        mOriginalStr = getText().toString();
        this.setText("");

        mHandler = new Handler() {
            @SuppressLint({"HandlerLeak", "SetTextI18n"})
            public void handleMessage(Message msg) {
                if (msg.what == SHOW_NEXT_CHAR && mIndex < mOriginalStr.length()) {
                    WCubeTextView.this.setText(WCubeTextView.this.getText().toString()
                            + mOriginalStr.charAt(mIndex));
                    mIndex++;
                }

            }
        };
        start();
    }

    public void setDuration(long duration) {
        mDuration = duration;
    }

    private void start() {
        new Thread() {
            public void run() {
                while (mIndex < mOriginalStr.length()) {
                    try {
                        Thread.sleep(mDuration);
                        mHandler.sendEmptyMessage(SHOW_NEXT_CHAR);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            }
        }.start();
    }

}

