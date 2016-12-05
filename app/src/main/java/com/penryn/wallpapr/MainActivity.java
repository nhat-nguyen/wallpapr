package com.penryn.wallpapr;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements WallpaperListFragment.OnFragmentInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        WallpaperListFragment fragment = (WallpaperListFragment) manager.findFragmentByTag(WallpaperListFragment.TAG);
        if (fragment == null) {
            fragment = new WallpaperListFragment();
            manager.beginTransaction().add(R.id.activity_main, fragment, WallpaperListFragment.TAG)
                    .commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
