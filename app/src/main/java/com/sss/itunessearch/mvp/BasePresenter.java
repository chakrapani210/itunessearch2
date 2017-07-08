package com.sss.itunessearch.mvp;

public class BasePresenter<ViewT> implements IBasePresenter<ViewT> {

    protected ViewT view;

    @Override
    public void onViewResume(ViewT view) {
        this.view = view;
    }

    @Override
    public void onViewPause() {
        view = null;
    }
}
