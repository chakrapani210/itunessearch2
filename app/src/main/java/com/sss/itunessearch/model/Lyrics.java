package com.sss.itunessearch.model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * Created by chakrapani on 7/8/17.
 */

public class Lyrics {

    /**
     * artist : Tom Waits
     * song : New Coat Of Paint
     * lyrics : Let's put a new coat of paint on this lonesome old town
     Set 'em up, we'll be knockin' em [...]
     * url : http://lyrics.wikia.com/Tom_Waits:New_Coat_Of_Paint
     */

    private static final String TAG = Lyrics.class.getSimpleName();
    private String artist;
    private String song;
    private String lyrics;
    private String url;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static Lyrics parseLyrics(String lyricsString) {
        if(lyricsString != null && lyricsString.contains("=")) {
            String lyricsJson = lyricsString.split("=")[1];
            Gson gson = new Gson();
            try {
                Lyrics lyrics = gson.fromJson(lyricsJson, Lyrics.class);
                return lyrics;
            } catch (JsonSyntaxException e ) {
                Log.e(TAG, "Error while parsing. ", e);
                return null;
            } catch (Exception e) {
                Log.e(TAG, "Error while parsing. ", e);
                return null;
            }
        }
        return null;
    }
}
