/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;

import model.Artist;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 *
 * @author marki
 */
public class ArtistQuestionHelper {
    private ArrayList<Artist> artistList;
    private ArrayList<Artist> queriedArtistList;
    private String artistName;
    Pattern pattern;
    Matcher matcher;

    
    public ArtistQuestionHelper(ArrayList<Artist> mArtistList) {
        this.artistList = mArtistList;
    }


    //get an artist
    public ArrayList<Artist> AskQuestion(String artistName){
        queriedArtistList = new ArrayList<>();
        boolean isMatch= false;
        for (Artist artist:artistList){
            pattern = Pattern.compile("kim\\s" + artist.getArtistName()+ "[?]*");
            matcher = pattern.matcher("kim "+"artistName"+"?");
             isMatch = matcher.matches();

            if (isMatch == true)
            {
                queriedArtistList.add(artist);
            }
        }
        return queriedArtistList;
    }

    public ArrayList<Artist> AskQuestion2(String artistName) {





        return queriedArtistList;
    }

    
    
    
    
}
