package com.sss.itunessearch.fragments.albums;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.sss.itunessearch.ErrorHandler;
import com.sss.itunessearch.model.SearchResults;
import com.sss.itunessearch.mvp.BasePresenter;
import com.sss.itunessearch.network.GsonRequest;
import com.sss.itunessearch.network.NetworkManager;

/**
 * Created by chakrapani on 7/8/17.
 */

public class AlbumListPresenter extends BasePresenter<AlbumContract.View> implements AlbumContract.Presenter {

    @Override
    public void searchAlbum(String searchText) {
        view.showProgressBar(true);
        GsonRequest<SearchResults> request = new GsonRequest<SearchResults>(NetworkManager.buildSearchUrl(searchText),
                SearchResults.class, new Response.Listener<SearchResults>() {
            @Override
            public void onResponse(SearchResults response) {
                view.showProgressBar(false);
                view.updateList(response);
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
