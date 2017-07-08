package com.sss.itunessearch.mvp;


import android.content.Context;

public interface IBaseView {

    void showProgressBar(boolean show);

    Context getContext();

    IBasePresenter getPresenter();
}
