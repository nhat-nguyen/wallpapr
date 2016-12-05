package com.penryn.wallpapr;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.BitmapRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.ImageViewTarget;

import java.util.List;

/**
 * Created by hoangnhat on 2016-12-02.
 */

public class WallpaperListAdapter extends RecyclerView.Adapter<WallpaperListAdapter.WallpaperViewHolder> {
    private final BitmapRequestBuilder<String, PaletteBitmap> mGlideRequest;
    private List<Wallpaper> mWallpapers;
    private Context mContext;

    public WallpaperListAdapter(Context context, RequestManager glide, List<Wallpaper> wallpapers) {
        mContext = context;
        mWallpapers = wallpapers;
        mGlideRequest = glide
                .fromString()
                .asBitmap()
                .transcode(new PaletteBitmapTranscoder(context), PaletteBitmap.class)
                .centerCrop()
                .animate(R.anim.fade_in)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
    }

    @Override
    public WallpaperViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_wallpaper_thumbnail, parent, false);
        return new WallpaperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final WallpaperViewHolder holder, int position) {
        final Wallpaper wallpaper = mWallpapers.get(position);

        holder.captionBackground.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));

        mGlideRequest.load(wallpaper.getThumbnailUrl())
                .into(new ImageViewTarget<PaletteBitmap>(holder.wallpaper) {
                    @Override
                    protected void setResource(PaletteBitmap resource) {
                        view.setImageBitmap(resource.bitmap);

                        Palette.Swatch swatch = resource.getFirstAvailableSwatch();

                        if (swatch == null) return;

                        holder.captionBackground.setBackgroundColor(swatch.getRgb());
                        holder.wallpaperName.setTextColor(swatch.getTitleTextColor());
                        holder.wallpaperAuthor.setTextColor(swatch.getBodyTextColor());
                    }
                });
    }

    @Override
    public void onViewRecycled(WallpaperViewHolder holder) {
        super.onViewRecycled(holder);
        Glide.clear(holder.wallpaper);
    }

    @Override
    public int getItemCount() {
        return mWallpapers != null ? mWallpapers.size() : 0;
    }

    static class WallpaperViewHolder extends RecyclerView.ViewHolder {
        View captionBackground;
        TextView wallpaperName;
        TextView wallpaperAuthor;
        ImageView wallpaper;

        WallpaperViewHolder(View itemView) {
            super(itemView);
            wallpaper = (ImageView) itemView.findViewById(R.id.iv_wallpaper);
            captionBackground = itemView.findViewById(R.id.ll_wallpaper_caption);
            wallpaperName = (TextView) itemView.findViewById(R.id.tv_wallpaper_name);
            wallpaperAuthor = (TextView) itemView.findViewById(R.id.tv_wallpaper_author);
        }
    }
}
