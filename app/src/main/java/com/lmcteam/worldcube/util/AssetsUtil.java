package com.lmcteam.worldcube.util;

import android.content.Context;
import android.graphics.Typeface;

import java.io.IOException;
import java.io.InputStream;

public class AssetsUtil {
    private static final String FONT_NAME = "ZCOOLXiaoWei-Regular.ttf";
    private static final String PRIVACY_POLICY_NAME = "PrivacyPolicy.txt";
    private static final String TERMS_OF_SERVICE_NAME = "TermsAndConditions.txt";
    private static Context mContext;
    private static Typeface typeface;
    private static InputStream privacyPolicyStream;

    public static InputStream getVcodeEmail() {
        return vcodeEmail;
    }

    private static InputStream vcodeEmail;

    public static InputStream getPrivacyPolicyStream() {
        return privacyPolicyStream;
    }

    public static InputStream getTermsOfServiceStream() {
        return termsOfServiceStream;
    }

    private static InputStream termsOfServiceStream;


    public static String getFontName() {
        return FONT_NAME;
    }

    public static void initialize(Context context) {
        mContext = context;
        typeface = Typeface.createFromAsset(context.getAssets(), getFontName());
        try {
            privacyPolicyStream = context.getAssets().open(PRIVACY_POLICY_NAME);
            termsOfServiceStream = context.getAssets().open(TERMS_OF_SERVICE_NAME);
            vcodeEmail = context.getAssets().open("vc.text");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Typeface getTypeface() {
        if (mContext==null)
            throw new IllegalStateException("AssetsUtil not initialized");
        return typeface;
    }
}
