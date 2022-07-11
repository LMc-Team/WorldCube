package com.lmcteam.worldcube.ui.widget;

import android.annotation.SuppressLint;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.lmcteam.worldcube.util.AssetsUtil;

public class WCubeTextView extends androidx.appcompat.widget.AppCompatTextView {

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

    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        YoYo.with(Techniques.Landing).duration(1500).playOn(this);
    }
}

