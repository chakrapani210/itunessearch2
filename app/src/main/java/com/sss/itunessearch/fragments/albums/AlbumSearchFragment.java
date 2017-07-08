package com.sss.itunessearch.fragments.albums;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.sss.itunessearch.IUNavigator;
import com.sss.itunessearch.model.AlbumInfo;
import com.sss.itunessearch.mvp.BaseView;
import com.sss.itunessearch.mvp.IBasePresenter;
import com.sss.itunessearch.network.GsonRequest;
import com.sss.itunessearch.R;
import com.sss.itunessearch.model.SearchResults;
import com.sss.itunessearch.network.NetworkManager;

import java.util.List;

/**
 * Created by chakrapani on 7/8/17.
 */

public class AlbumSearchFragment extends BaseView implements AlbumContract.View, AlbumAdapter.OnAlbumSelectListner {

    private RecyclerView mListView;
    private SearchResults mSearchResults;
    private AlbumAdapter mAdapter;
    private AlbumContract.Presenter mPresenter;

    public AlbumSearchFragment() {
        mPresenter = new AlbumListPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        final TextInputEditText editText = (TextInputEditText) view.findViewById(R.id.search_edit_text_view);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE) {
                    search(v.getText().toString());
                    return true;
                }
                return false;
            }
        });
        view.findViewById(R.id.search_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search(editText.getText().toString());
            }
        });

        mListView = (RecyclerView) view.findViewById(R.id.list_view);
        mListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new AlbumAdapter(mSearchResults, getActivity(), this);
        DividerItemDecoration decorator = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        decorator.setDrawable(getActivity().getResources().getDrawable(R.drawable.devider));
        mListView.addItemDecoration(decorator);

        mListView.setAdapter(mAdapter);
        return view;
    }

    private void search(String terms) {
        mPresenter.searchAlbum(terms);
    }

    @Override
    public IBasePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void onAlbumSelected(AlbumInfo info) {
        ((IUNavigator)getActivity()).onAlbumSelected(info);
    }

    @Override
    public void updateList(SearchResults response) {
        mSearchResults = response;
        mAdapter.updateList(response);
    }
}
