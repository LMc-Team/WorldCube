package com.lmcteam.worldcube.util;

import android.content.Context;

public class LangStringUtil {

    private static Context mContext;
    public static void init(Context context){
        mContext = context;
    }
    public static String getStringById(int id){
        return mContext.getResources().getString(id);
    }
}
