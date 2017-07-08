package com.sss.itunessearch.mvp;


public interface IBasePresenter<ViewT> {

    void onViewResume(ViewT view);

    void onViewPause();

}
