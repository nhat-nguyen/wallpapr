package com.penryn.wallpapr;

/**
 * Created by hoangnhat on 2016-12-02.
 */
public class Wallpaper {
    private String thumbnailUrl;
    private String fullSizeUrl;

    public Wallpaper(String thumbnailUrl, String fullSizeUrl) {
        this.thumbnailUrl = thumbnailUrl;
        this.fullSizeUrl = fullSizeUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getFullSizeUrl() {
        return fullSizeUrl;
    }
}
