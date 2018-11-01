package com.symbolstar.slicestest.provider;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.symbolstar.slicestest.CameraActivity;
import com.symbolstar.slicestest.MainActivity;
import com.symbolstar.slicestest.R;
import com.symbolstar.slicestest.VoiceActivity;

import androidx.core.graphics.drawable.IconCompat;
import androidx.slice.Slice;
import androidx.slice.builders.ListBuilder;
import androidx.slice.builders.SliceAction;

import static androidx.core.graphics.drawable.IconCompat.createWithResource;

public class SlicesBuilder {

    public static Slice getBingSliceWithMultipleRows(Uri sliceUri, Context context){

        return new ListBuilder(context, sliceUri, ListBuilder.ICON_IMAGE)
                .addRow(
                        new ListBuilder.RowBuilder()
                                .setTitleItem(createWithResource(context,R.drawable.ic_search),ListBuilder.ICON_IMAGE)
                                .setTitle("Search")
                                .setPrimaryAction(SlicesAction.createDefaultActivityAction(context))
                                .addEndItem(createWithResource(context, R.drawable.ic_bing_search_camera),
                                        ListBuilder.ICON_IMAGE)
                                .addEndItem(createWithResource(context, R.drawable.ic_voice),
                                        ListBuilder.ICON_IMAGE)
                )
                .addRow(
                        new ListBuilder.RowBuilder()
                                .setTitleItem(createWithResource(context,R.drawable.ic_search),ListBuilder.ICON_IMAGE)
                                .setTitle("Search")
                                .setPrimaryAction(SlicesAction.createDefaultActivityAction(context))
                                .addEndItem(createWithResource(context, R.drawable.ic_bing_search_camera),
                                        ListBuilder.ICON_IMAGE)
                                .addEndItem(createWithResource(context, R.drawable.ic_voice),
                                        ListBuilder.ICON_IMAGE)
                )
                .addRow(
                        new ListBuilder.RowBuilder()
                                .setTitleItem(createWithResource(context, R.drawable.ic_voice),
                                        ListBuilder.ICON_IMAGE)
                                .setTitle("voice")
                                .setSubtitle("speak questions")
                                .setPrimaryAction(SlicesAction.createCouponAction(context))
                                .addEndItem(System.currentTimeMillis())
                )
                .build();
    }

    public static Slice createSliceWithActionInHeader(Uri sliceUri,Context context) {

        // Construct our slice actions.
        SliceAction noteAction = SliceAction.create(PendingIntent.getActivity(
                context, 0, new Intent(context, MainActivity.class), 0
                ),
                IconCompat.createWithResource(context, R.drawable.ic_search),
                ListBuilder.ICON_IMAGE,
                "Take note");

        SliceAction voiceNoteAction = SliceAction.create(PendingIntent.getActivity(
                context, 0, new Intent(context, VoiceActivity.class), 0
                ),
                IconCompat.createWithResource(context, R.drawable.ic_voice),
                ListBuilder.ICON_IMAGE,
                "Take voice note");

        SliceAction cameraNoteAction = SliceAction.create(PendingIntent.getActivity(
                context, 0, new Intent(context, CameraActivity.class), 0
                ),
                IconCompat.createWithResource(context, R.drawable.ic_bing_search_camera),
                ListBuilder.ICON_IMAGE,
                "Create photo note");


        // Construct the list.
        ListBuilder listBuilder = new ListBuilder(context, sliceUri, ListBuilder.INFINITY)
                .setAccentColor(0xfff4b400) // Specify color for tinting icons
                .setHeader(new ListBuilder.HeaderBuilder() // Construct the header.
                        .setTitle("start new search ")
                        .setSubtitle("Easily to search")
                )
                .addRow(new ListBuilder.RowBuilder()
                        .setTitle("Enter app")
                        .setPrimaryAction(SlicesAction.createDefaultActivityAction(context))
                )
                // Add the actions to the ListBuilder.
                .addAction(noteAction)
                .addAction(voiceNoteAction)
                .addAction(cameraNoteAction);
        return listBuilder.build();
    }

}
