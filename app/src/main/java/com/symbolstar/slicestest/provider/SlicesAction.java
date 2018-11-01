package com.symbolstar.slicestest.provider;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.symbolstar.slicestest.MainActivity;
import com.symbolstar.slicestest.R;

import androidx.core.graphics.drawable.IconCompat;
import androidx.slice.builders.ListBuilder;
import androidx.slice.builders.SliceAction;

public class SlicesAction {
    public static SliceAction createDefaultActivityAction(Context context) {
        return SliceAction.create(
                PendingIntent.getActivity(
                        context, 0, new Intent(context, MainActivity.class), 0
                ),
                IconCompat.createWithResource(context, R.drawable.ic_search),
                ListBuilder.ICON_IMAGE,
                "bing search"
        );
    }
    public static SliceAction createCouponAction(Context context) {
        Intent i = new Intent(context, SecondActivity.class);
        i.putExtra("coupon", true);
        return SliceAction.create(
                PendingIntent.getActivity(
                        context, 0, i, 0
                ),
                IconCompat.createWithResource(context, R.drawable.ic_launcher_background),
                ListBuilder.ICON_IMAGE,
                "voice"
        );
    }
}
