package com.hy.shop.utils;

import android.content.Context;

/**
 * Created time : 2017/5/6 16:00.
 *
 * @author HY
 */

public class CommandUtils {
    public static int px2sp(Context context, float px) {
        float density = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (px / density + 0.5f);
    }

    public static int sp2px(Context context, float sp) {
        float density = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (sp * density + 0.5f);
    }
}
