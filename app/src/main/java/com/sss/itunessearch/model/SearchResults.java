package com.sss.itunessearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chakrapani on 7/8/17.
 */

public class SearchResults implements Parcelable {

    /**
     * resultCount : 50
     * results : [{"wrapperType":"track","kind":"song","artistId":83964,"collectionId":285283129,"trackId":285283141,"artistName":"Tom Waits","collectionName":"Closing Time","trackName":"I Hope That I Don't Fall In Love With You","collectionCensoredName":"Closing Time","trackCensoredName":"I Hope That I Don't Fall In Love With You","artistViewUrl":"https://itunes.apple.com/us/artist/tom-waits/id83964?uo=4","collectionViewUrl":"https://itunes.apple.com/us/album/i-hope-that-i-dont-fall-in-love-with-you/id285283129?i=285283141&uo=4","trackViewUrl":"https://itunes.apple.com/us/album/i-hope-that-i-dont-fall-in-love-with-you/id285283129?i=285283141&uo=4","previewUrl":"http://a203.phobos.apple.com/us/r30/Music/37/74/88/mzm.jpixkflh.aac.p.m4a","artworkUrl30":"http://is3.mzstatic.com/image/thumb/Music/v4/f5/08/dd/f508ddf9-bd03-f1d5-6e57-41fc0680005a/source/30x30bb.jpg","artworkUrl60":"http://is3.mzstatic.com/image/thumb/Music/v4/f5/08/dd/f508ddf9-bd03-f1d5-6e57-41fc0680005a/source/60x60bb.jpg","artworkUrl100":"http://is3.mzstatic.com/image/thumb/Music/v4/f5/08/dd/f508ddf9-bd03-f1d5-6e57-41fc0680005a/source/100x100bb.jpg","collectionPrice":9.99,"trackPrice":1.29,"releaseDate":"1973-03-01T08:00:00Z","collectionExplicitness":"notExplicit","trackExplicitness":"notExplicit","discCount":1,"discNumber":1,"trackCount":12,"trackNumber":2,"trackTimeMillis":234533,"country":"USA","currency":"USD","primaryGenreName":"Rock","isStreamable":true}]
     */

    private int resultCount;
    private List<AlbumInfo> results;

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<AlbumInfo> getResults() {
        return results;
    }

    public void setResults(List<AlbumInfo> results) {
        this.results = results;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.resultCount);
        dest.writeList(this.results);
    }

    public SearchResults() {
    }

    protected SearchResults(Parcel in) {
        this.resultCount = in.readInt();
        this.results = new ArrayList<AlbumInfo>();
        in.readList(this.results, AlbumInfo.class.getClassLoader());
    }

    public static final Parcelable.Creator<SearchResults> CREATOR = new Parcelable.Creator<SearchResults>() {
        @Override
        public SearchResults createFromParcel(Parcel source) {
            return new SearchResults(source);
        }

        @Override
        public SearchResults[] newArray(int size) {
            return new SearchResults[size];
        }
    };
}

