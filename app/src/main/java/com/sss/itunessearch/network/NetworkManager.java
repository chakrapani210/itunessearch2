package com.sss.itunessearch.network;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.sss.itunessearch.model.AlbumInfo;

import java.lang.reflect.Type;

/**
 * Created by chakrapani on 7/8/17.
 */

public final class NetworkManager {

    public static final String TAG = NetworkManager.class.getSimpleName();
    public static final String LYRICS_URL = "http://lyrics.wikia.com/api.php?func=getSong&fmt=json";
    public static final String PARAM_ARTIST = "artist";
    public static final String PARAM_SONG = "song";
    private static final String SEARCH_URL = "https://itunes.apple.com/search?term=";
    private static NetworkManager sInstance;
    private RequestQueue mQueue;

    private NetworkManager(Context context) {
        mQueue = Volley.newRequestQueue(context);
    }

    public static NetworkManager getInstance(Context context) {
        if(sInstance == null) {
            sInstance = new NetworkManager(context);
        }
        return sInstance;
    }

    // Need to implement handling of Configuration changes
    public void addRequest(Request request) {
        mQueue.add(request);
    }

    public static String buildSearchUrl(String searchText) {
        StringBuffer url = new StringBuffer(SEARCH_URL);
        String[] tokens = searchText.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            url.append(tokens[i]);
            if(i != tokens.length - 1)
                url.append("+");
        }
        return url.toString();
    }

    public static String buildLyricsUrl(AlbumInfo info) {
        Uri.Builder builder = Uri.parse(LYRICS_URL).buildUpon()
                .appendQueryParameter(PARAM_ARTIST, info.getArtistName())
                .appendQueryParameter(PARAM_SONG, info.getTrackName());
        String url = builder.toString();
        Log.d(TAG, "Lyrics URL: " + url);
        return url;
    }
}
