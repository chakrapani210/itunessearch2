package com.sss.itunessearch.fragments.albums;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sss.itunessearch.R;
import com.sss.itunessearch.model.AlbumInfo;
import com.sss.itunessearch.model.SearchResults;

/**
 * Created by chakrapani on 7/8/17.
 */

public class AlbumAdapter extends RecyclerView.Adapter<ViewHolder> {

    private SearchResults mSearchResults;
    private Activity mContext; // Needed Activity to take advantage of Glide features
    private OnAlbumSelectListner mListner;
    public AlbumAdapter(SearchResults mSearchResults, Activity mContext, OnAlbumSelectListner listner) {
        this.mSearchResults = mSearchResults;
        this.mContext = mContext;
        this.mListner = listner;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.album_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        AlbumInfo info = mSearchResults.getResults().get(position);
        Glide.with(mContext)
                .load(info.getArtworkUrl60())
                .into(holder.imageView);
        holder.titleTextView.setText(info.getTrackName());
        holder.artistTextView.setText(info.getArtistName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListner != null) {
                    mListner.onAlbumSelected(mSearchResults.getResults().get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSearchResults != null ? mSearchResults.getResultCount() : 0;
    }


    public void updateList(SearchResults listData) {
        mSearchResults = listData;
        notifyDataSetChanged();
    }

    public interface OnAlbumSelectListner {
        void onAlbumSelected(AlbumInfo info);
    }
}


class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView titleTextView;
    public TextView artistTextView;
    public ViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.image_view);
        titleTextView = (TextView) itemView.findViewById(R.id.album_track_name);
        artistTextView = (TextView) itemView.findViewById(R.id.artist_name);
    }
}
