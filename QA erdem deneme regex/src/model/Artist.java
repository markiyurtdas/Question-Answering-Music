/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 * @author marki
 */
public class Artist {
    private String externalUrl;
    private int followersTotal;
    private ArrayList<String> genres;
    private String href;
    private String spotifyId;
    private String artistName;
    private int popularity;
    private String type;

    //empty cons
    public Artist() {
    }

    //general cons
    public Artist(String artistName, String id, String type) {
        this.artistName = artistName;
        this.type = type;
        this.spotifyId = id;
    }

    public Artist(String artistName, String id) {
        this.artistName = artistName;
        this.spotifyId = id;
    }

    //Spotify cons
    public Artist(String externalUrl, int followersTotal, ArrayList<String> genres, String href, String spotifyId, String artistName, int popularity, String type) {
        this.externalUrl = externalUrl;
        this.followersTotal = followersTotal;
        this.genres = genres;
        this.href = href;
        this.spotifyId = spotifyId;
        this.artistName = artistName;
        this.popularity = popularity;
        this.type = type;
    }

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    public int getFollowersTotal() {
        return followersTotal;
    }

    public void setFollowersTotal(int followersTotal) {
        this.followersTotal = followersTotal;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public String getAllGenres() {
        String str = "";
        for (int i = 0; i < genres.size(); i++) {
            str += genres.get(i) + ",";
        }

        return str;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(String spotifyId) {
        this.spotifyId = spotifyId;
    }


    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Artist{" + "externalUrl=" + externalUrl + ", followersTotal=" + followersTotal + ", genres=" + genres + ", href=" + href + ", spotifyId=" + spotifyId + ", artistName=" + artistName + ", popularity=" + popularity + ", type=" + type + '}';
    }

    public String prepareForDB() {
        return "INSERT INTO `SAP`.`Artist` (`Name`, `ArtistID`, `External_urls`, `"
                + "Followers`, `Genres`, `Href`, `"
                + "`Popularity`, `Type`) "
                + "VALUES (" + artistName + "," + spotifyId + externalUrl + ","
                + followersTotal + "," + getAllGenres() + href + ","
                + "," + popularity + "," + type + ")";

    }


}
