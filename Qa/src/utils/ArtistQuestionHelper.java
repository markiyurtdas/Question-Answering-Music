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



public class ArtistQuestionHelper {
    private ArrayList<Artist> artistList;
    private ArrayList<Artist> queriedArtistList;
    private String artistName;
    Pattern mPattern;
    Matcher mMatcher;

    
    public ArtistQuestionHelper(ArrayList<Artist> mArtistList) {
        this.artistList = mArtistList;
    }


    //get an artist
    public ArrayList<Artist> AskQuestion(ArrayList<Artist> artistler,ArrayList<String> artistName,String input){
        queriedArtistList = new ArrayList<>();
        boolean isMatch= false;
        int i=0;
        while (i<artistName.size()){
           mPattern = Pattern.compile("[[\\w]*[^\\w]*]*" + artistName.get(i)+ "[[\\w]*[^\\w]*]*" ,Pattern.CASE_INSENSITIVE);
           mMatcher = mPattern.matcher(input);
             isMatch = mMatcher.matches();
            if (isMatch == true)
            {
                queriedArtistList.add(artistler.get(i));
            }
        i++;
        }
        return queriedArtistList;
    }
}

