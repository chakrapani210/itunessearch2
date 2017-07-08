package com.sss.itunessearch.fragments.lyrics;

import com.sss.itunessearch.fragments.albums.AlbumContract;
import com.sss.itunessearch.model.AlbumInfo;
import com.sss.itunessearch.model.Lyrics;
import com.sss.itunessearch.model.SearchResults;
import com.sss.itunessearch.mvp.IBasePresenter;
import com.sss.itunessearch.mvp.IBaseView;

/**
 * Created by chakrapani on 7/8/17.
 */

public class LyricsContract {
    interface View extends IBaseView {
        void updateLyrics(Lyrics lyrics);
    }

    interface Presenter extends IBasePresenter<LyricsContract.View> {
        void getLyrics(AlbumInfo info);
    }
}
