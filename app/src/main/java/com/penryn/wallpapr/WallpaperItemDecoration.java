package com.penryn.wallpapr;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by hoangnhat on 2016-12-02.
 */

public class WallpaperItemDecoration extends RecyclerView.ItemDecoration {
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = outRect.right = 10;
        outRect.bottom = outRect.top = 10;
    }
}
