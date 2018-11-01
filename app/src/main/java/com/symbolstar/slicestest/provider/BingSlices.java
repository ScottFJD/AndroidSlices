package com.symbolstar.slicestest.provider;

import android.content.Context;
        import android.net.Uri;

        import androidx.slice.Slice;
        import androidx.slice.SliceProvider;

public class BingSlices extends SliceProvider {
    /**
     * Instantiate any required objects. Return true if the provider was successfully created,
     * false otherwise.
     */
    @Override
    public boolean onCreateSliceProvider() {
        return true;
    }


    /**
     * Construct the Slice and bind data if available.
     */
    public Slice onBindSlice(Uri sliceUri) {
        Context context = getContext();
        if (context == null ) {
            return null;
        }
        if ("/bing".equals(sliceUri.getPath())) {
            return SlicesBuilder.getBingSliceWithMultipleRows(sliceUri, getContext());
        } else if ("/search".equals(sliceUri.getPath())) {
            return SlicesBuilder.createSliceWithActionInHeader(sliceUri, getContext());
        } else {
            return SlicesBuilder.getBingSliceWithMultipleRows(sliceUri, getContext());
        }
    }


    /**
     * Slice has been pinned to external process. Subscribe to data source if necessary.
     */
    @Override
    public void onSlicePinned(Uri sliceUri) {
        // When data is received, call context.contentResolver.notifyChange(sliceUri, null) to

    }

    /**
     * Unsubscribe from data source if necessary.
     */
    @Override
    public void onSliceUnpinned(Uri sliceUri) {
        // Remove any observers if necessary to avoid memory leaks.
    }




}
