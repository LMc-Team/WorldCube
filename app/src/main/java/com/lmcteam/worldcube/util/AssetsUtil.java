package com.lmcteam.worldcube.util;

import android.content.Context;
import android.graphics.Typeface;

public class AssetsUtil {
    private static final String FONT_NAME = "ZCOOLXiaoWei-Regular.ttf";
    private static Context mContext;
    private static Typeface typeface;

    public static String getFontName() {
        return FONT_NAME;
    }

    public static void initialize(Context context) {
        mContext = context;
        typeface = Typeface.createFromAsset(context.getAssets(), getFontName());
    }

    public static Typeface getTypeface() {
        if (mContext==null)
            throw new IllegalStateException("AssetsUtil not initialized");
        return typeface;
    }
}
