package com.penryn.wallpapr;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.graphics.Palette;
import android.support.v7.graphics.Target;

import java.util.Arrays;
import java.util.List;

public class PaletteBitmap {
    public final Palette palette;
    public final Bitmap bitmap;

    public PaletteBitmap(@NonNull Bitmap bitmap, @NonNull Palette palette) {
        this.bitmap = bitmap;
        this.palette = palette;
    }

    private List<Target> getDefaultPriorities() {
        return Arrays.asList(
                Target.VIBRANT, Target.LIGHT_VIBRANT, Target.DARK_VIBRANT,
                Target.LIGHT_MUTED, Target.DARK_MUTED
        );
    }

    public Palette.Swatch getFirstAvailableSwatch(Target... priorities) {
        List<Target> targets = priorities.length > 0 ? Arrays.asList(priorities) : getDefaultPriorities();

        for (Target target : targets) {
            Palette.Swatch swatch = palette.getSwatchForTarget(target);
            if (swatch != null) {
                return swatch;
            }
        }

        return palette.getDominantSwatch() != null ? palette.getDominantSwatch() : null;
    }
}
