package com.sss.itunessearch.fragments.albums;

import com.sss.itunessearch.model.AlbumInfo;
import com.sss.itunessearch.model.SearchResults;
import com.sss.itunessearch.mvp.IBasePresenter;
import com.sss.itunessearch.mvp.IBaseView;

import java.util.List;

/**
 * Created by chakrapani on 7/8/17.
 */

public interface AlbumContract {
    interface View extends IBaseView {
        void updateList(SearchResults response);
    }

    interface Presenter extends IBasePresenter<View> {
        void searchAlbum(String searchText);
    }
}
