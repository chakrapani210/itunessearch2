package com.sss.itunessearch;

import android.app.AlertDialog;
import android.content.Context;

import com.android.volley.VolleyError;

/**
 * Created by chakrapani on 7/8/17.
 *
 * Should study the API's for better Handling of Errors
 */

public class ErrorHandler {
    private Context mContext;

    public ErrorHandler(Context mContext) {
        this.mContext = mContext;
    }

    public boolean handleError(VolleyError error) {
        return handleError(error.getMessage());
    }

    public boolean handleError(String error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle(R.string.error_title).setMessage(error)
                .setNeutralButton(R.string.ok, null);
        builder.create().show();
        return true;
    }

    public void handleNetworkError() {
        handleError(mContext.getString(R.string.internet_unavailable));
    }
}
