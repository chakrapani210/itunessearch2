package com.sss.itunessearch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.sss.itunessearch.fragments.albums.AlbumSearchFragment;
import com.sss.itunessearch.fragments.lyrics.LyricsFragment;
import com.sss.itunessearch.model.AlbumInfo;
import com.sss.itunessearch.util.NetworkHelper;

import static android.net.ConnectivityManager.CONNECTIVITY_ACTION;

public class SearchActivity extends AppCompatActivity implements IUNavigator {

    private static final String TAG = SearchActivity.class.getSimpleName();
    private FrameLayout mContainer;
    private IntentFilter connectivityIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mContainer = (FrameLayout) findViewById(R.id.main_container);

        init(savedInstanceState);
        connectivityIntentFilter = new IntentFilter(CONNECTIVITY_ACTION);
    }


    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(connectivityBroadcastReceiver, connectivityIntentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(connectivityBroadcastReceiver);
        super.onPause();
    }


    BroadcastReceiver connectivityBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (!NetworkHelper.getInstance().isNetworkAvailable(context)) {
                new ErrorHandler(SearchActivity.this).handleNetworkError();
            }
        }
    };

    private void init(Bundle savedInstanceState) {
        if(savedInstanceState == null) {
            AlbumSearchFragment fragment = new AlbumSearchFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment)
                    .addToBackStack(null).commit();
        }
    }

    @Override
    public void onAlbumSelected(AlbumInfo info) {
        Fragment fragment = LyricsFragment.getInstance(info);
        replaceFragment(fragment);
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment)
                .addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(getSupportFragmentManager().findFragmentById(R.id.main_container) == null) {
            finish();
        }
    }
}
