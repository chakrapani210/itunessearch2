package com.sss.itunessearch.fragments.lyrics;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.sss.itunessearch.ErrorHandler;
import com.sss.itunessearch.fragments.albums.AlbumContract;
import com.sss.itunessearch.model.AlbumInfo;
import com.sss.itunessearch.model.Lyrics;
import com.sss.itunessearch.mvp.BasePresenter;
import com.sss.itunessearch.network.NetworkManager;

/**
 * Created by chakrapani on 7/8/17.
 */

public class LyricsPresenter extends BasePresenter<LyricsContract.View>
        implements LyricsContract.Presenter {
    @Override
    public void getLyrics(AlbumInfo info) {
        view.showProgressBar(true);
        StringRequest request = new StringRequest(NetworkManager.buildLyricsUrl(info),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        view.showProgressBar(false);
                        Lyrics lyrics = Lyrics.parseLyrics(response);
                        view.updateLyrics(lyrics);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                view.showProgressBar(false);
                new ErrorHandler(view.getContext()).handleError(error);
            }
        });

        NetworkManager.getInstance(view.getContext()).addRequest(request);
    }
}
