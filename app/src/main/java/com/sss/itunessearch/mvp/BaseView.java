package com.sss.itunessearch.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sss.itunessearch.R;

/**
 * Abstract base class to be extended by any MVP View such as {@link Fragment} and
 * {@link android.support.v4.app.ActivityCompat}. It contains common attributes and methods to be
 * shared across Presenters.
 */
public abstract class BaseView extends Fragment implements IBaseView {

    protected ProgressBar progressBar;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgressBar(boolean show) {
        if(progressBar != null) {
            if (show) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onPause() {
        getPresenter().onViewPause();
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().onViewResume(this);
    }

}
