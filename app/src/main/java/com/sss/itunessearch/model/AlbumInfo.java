package com.sss.itunessearch.model;

import android.os.Parcel;
import android.os.Parcelable;

public class AlbumInfo implements Parcelable {

    private String wrapperType;
    private String kind;
    private int artistId;
    private int collectionId;
    private int trackId;
    private String artistName;
    private String collectionName;
    private String trackName;
    private String collectionCensoredName;
    private String trackCensoredName;
    private String artistViewUrl;
    private String collectionViewUrl;
    private String trackViewUrl;
    private String previewUrl;
    private String artworkUrl30;
    private String artworkUrl60;
    private String artworkUrl100;
    private double collectionPrice;
    private double trackPrice;
    private String releaseDate;
    private String collectionExplicitness;
    private String trackExplicitness;
    private int discCount;
    private int discNumber;
    private int trackCount;
    private int trackNumber;
    private int trackTimeMillis;
    private String country;
    private String currency;
    private String primaryGenreName;
    private boolean isStreamable;

    public String getWrapperType() {
        return wrapperType;
    }

    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    public void setCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
    }

    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    public void setArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public double getCollectionPrice() {
        return collectionPrice;
    }

    public void setCollectionPrice(double collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    public double getTrackPrice() {
        return trackPrice;
    }

    public void setTrackPrice(double trackPrice) {
        this.trackPrice = trackPrice;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCollectionExplicitness() {
        return collectionExplicitness;
    }

    public void setCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
    }

    public String getTrackExplicitness() {
        return trackExplicitness;
    }

    public void setTrackExplicitness(String trackExplicitness) {
        this.trackExplicitness = trackExplicitness;
    }

    public int getDiscCount() {
        return discCount;
    }

    public void setDiscCount(int discCount) {
        this.discCount = discCount;
    }

    public int getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(int discNumber) {
        this.discNumber = discNumber;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public int getTrackTimeMillis() {
        return trackTimeMillis;
    }

    public void setTrackTimeMillis(int trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    public boolean isIsStreamable() {
        return isStreamable;
    }

    public void setIsStreamable(boolean isStreamable) {
        this.isStreamable = isStreamable;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.wrapperType);
        dest.writeString(this.kind);
        dest.writeInt(this.artistId);
        dest.writeInt(this.collectionId);
        dest.writeInt(this.trackId);
        dest.writeString(this.artistName);
        dest.writeString(this.collectionName);
        dest.writeString(this.trackName);
        dest.writeString(this.collectionCensoredName);
        dest.writeString(this.trackCensoredName);
        dest.writeString(this.artistViewUrl);
        dest.writeString(this.collectionViewUrl);
        dest.writeString(this.trackViewUrl);
        dest.writeString(this.previewUrl);
        dest.writeString(this.artworkUrl30);
        dest.writeString(this.artworkUrl60);
        dest.writeString(this.artworkUrl100);
        dest.writeDouble(this.collectionPrice);
        dest.writeDouble(this.trackPrice);
        dest.writeString(this.releaseDate);
        dest.writeString(this.collectionExplicitness);
        dest.writeString(this.trackExplicitness);
        dest.writeInt(this.discCount);
        dest.writeInt(this.discNumber);
        dest.writeInt(this.trackCount);
        dest.writeInt(this.trackNumber);
        dest.writeInt(this.trackTimeMillis);
        dest.writeString(this.country);
        dest.writeString(this.currency);
        dest.writeString(this.primaryGenreName);
        dest.writeByte(this.isStreamable ? (byte) 1 : (byte) 0);
    }

    public AlbumInfo() {
    }

    protected AlbumInfo(Parcel in) {
        this.wrapperType = in.readString();
        this.kind = in.readString();
        this.artistId = in.readInt();
        this.collectionId = in.readInt();
        this.trackId = in.readInt();
        this.artistName = in.readString();
        this.collectionName = in.readString();
        this.trackName = in.readString();
        this.collectionCensoredName = in.readString();
        this.trackCensoredName = in.readString();
        this.artistViewUrl = in.readString();
        this.collectionViewUrl = in.readString();
        this.trackViewUrl = in.readString();
        this.previewUrl = in.readString();
        this.artworkUrl30 = in.readString();
        this.artworkUrl60 = in.readString();
        this.artworkUrl100 = in.readString();
        this.collectionPrice = in.readDouble();
        this.trackPrice = in.readDouble();
        this.releaseDate = in.readString();
        this.collectionExplicitness = in.readString();
        this.trackExplicitness = in.readString();
        this.discCount = in.readInt();
        this.discNumber = in.readInt();
        this.trackCount = in.readInt();
        this.trackNumber = in.readInt();
        this.trackTimeMillis = in.readInt();
        this.country = in.readString();
        this.currency = in.readString();
        this.primaryGenreName = in.readString();
        this.isStreamable = in.readByte() != 0;
    }

    public static final Creator<AlbumInfo> CREATOR = new Creator<AlbumInfo>() {
        @Override
        public AlbumInfo createFromParcel(Parcel source) {
            return new AlbumInfo(source);
        }

        @Override
        public AlbumInfo[] newArray(int size) {
            return new AlbumInfo[size];
        }
    };
}