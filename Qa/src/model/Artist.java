/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author marki
 */
public class Artist {
    private String externalUrl;
    private int  followersTotal;
    private ArrayList<String> genres;
    private String href;
    private String spotifyId;
    private String artistName;
    private int popularity;
    private String type;
    private ArrayList<Album> albums = new ArrayList<>();
    private Date birthDay;
    private String birthPlace;
    //empty cons
    public Artist() {
    }

    //general cons
    public Artist( String artistName,String id, String type) {
        this.artistName = artistName;
        this.type = type;
        this.spotifyId = id;
    }

    public Artist( String artistName,String id) {
        this.artistName = artistName;
        this.spotifyId = id;
    }

    //Spotify cons
    public Artist(String externalUrl, int followersTotal, ArrayList<String> genres, String href, String spotifyId,  String artistName, int popularity, String type) {
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
         String str="";
         for(int i=0 ; i<genres.size();i++){
             str += genres.get(i) +",";
         }
         
        return str;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }
    public String getAllAlbumNames() {
        String str="";
        for(int i=0 ; i<albums.size();i++){
            str += albums.get(i).getAlbumName() +",";
        }

        return str;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }
    public void addToALbums(Album album) {
        this.albums.add(album);
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
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
        return "\nartistName=" + "\nexternalUrl=" + externalUrl + "\nfollowersTotal=" + followersTotal + "\ngenres=" + genres + "\nbirthday=" + birthDay+
                "\nbirthplace=" + birthPlace  + "\npopularity=" + popularity +"\n\n";
    }
    public String prepareForDB() {
        return "INSERT INTO `SAP`.`Artist` (`Name`, `ArtistID`, `External_urls`, `"
                   + "Followers`, `Genres`, `Href`, `"
                   + "`Popularity`, `Type`) "
                   + "VALUES (" +artistName +"," +spotifyId + externalUrl +"," 
                +followersTotal +"," +getAllGenres() +href +","
                +","+popularity +","+ type+ ")";
        
    }
      
    
}
