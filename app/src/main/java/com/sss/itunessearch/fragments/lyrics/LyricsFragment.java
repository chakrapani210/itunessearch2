package com.sss.itunessearch.fragments.lyrics;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.sss.itunessearch.R;
import com.sss.itunessearch.model.AlbumInfo;
import com.sss.itunessearch.model.Lyrics;
import com.sss.itunessearch.mvp.BaseView;
import com.sss.itunessearch.mvp.IBasePresenter;
import com.sss.itunessearch.network.NetworkManager;

/**
 * Created by chakrapani on 7/8/17.
 */

public class LyricsFragment extends BaseView implements LyricsContract.View {
    public static final String TAG = LyricsFragment.class.getSimpleName();
    public static final String ARGUMENT_ALBUM_INFO = "argument_album_info";
    private AlbumInfo mAlbumInfo;
    private TextView mLyricsTextView;
    private TextView mArtistNameTextView;
    private ImageView mImageView;
    private TextView mAlbumTitleTextView;
    private LyricsContract.Presenter mPresenter;

    public static Fragment getInstance(AlbumInfo info) {
        Fragment fragment = new LyricsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARGUMENT_ALBUM_INFO, info);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            mAlbumInfo = getArguments().getParcelable(ARGUMENT_ALBUM_INFO);
        }
        mPresenter = new LyricsPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lyrics, container, false);
        mImageView = (ImageView) view.findViewById(R.id.image_view);
        mArtistNameTextView = (TextView) view.findViewById(R.id.artist_name);
        mAlbumTitleTextView = (TextView) view.findViewById(R.id.album_track_name);
        mLyricsTextView = (TextView) view.findViewById(R.id.lyrics);

        mArtistNameTextView.setText(mAlbumInfo.getArtistName());
        mAlbumTitleTextView.setText(mAlbumInfo.getTrackName());
        Glide.with(this)
                .load(mAlbumInfo.getArtworkUrl60())
                .into(mImageView);
        return view;
    }

    private void getLyrics() {
        mPresenter.getLyrics(mAlbumInfo);
    }

    @Override
    public void onResume() {
        super.onResume();
        getLyrics();
    }

    @Override
    public void updateLyrics(Lyrics lyrics) {
        if(lyrics == null) {
            mLyricsTextView.setText("Not Found");
        } else {
            mLyricsTextView.setText(lyrics.getLyrics());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        progressBar = null;
        mLyricsTextView = null;
        mArtistNameTextView = null;
        mImageView = null;
        mAlbumTitleTextView = null;

    }

    @Override
    public IBasePresenter getPresenter() {
        return mPresenter;
    }
}
