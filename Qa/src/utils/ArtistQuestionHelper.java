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
    Pattern mPattern, mPattern2;
    Matcher mMatcher, mMatcher2;

    
    public ArtistQuestionHelper(ArrayList<Artist> mArtistList) {
        this.artistList = mArtistList;
    }


    //get an artist
    public ArrayList<Artist> AskQuestion(ArrayList<Artist> artistler,ArrayList<String> artistName,String input){
        queriedArtistList = new ArrayList<>();
        boolean isMatch= false;
        int i=0;
        while (i<artistName.size()){
           //mPattern = Pattern.compile("[kim[dir]]*" + "[\\s]?" + artistName.get(i)+ "[\\s]?" + "[kim[dir]]*" + "[?]*",Pattern.CASE_INSENSITIVE);

           mPattern = Pattern.compile("[[\\w]*[^\\w]*]*" + artistName.get(i)+ "[[\\w]*[^\\w]*]*" ,Pattern.CASE_INSENSITIVE);

            mMatcher = mPattern.matcher(input);

            //System.out.println("matcher: "+ mMatcher.toString());
             isMatch = mMatcher.matches();
            if (isMatch == true)
            {
                mPattern2 = Pattern.compile("[[\\w]*[^\\w]*]*" + "adres" + "[[\\w]*[^\\w]*]*");

                mMatcher2 =mPattern2.matcher(input);

                queriedArtistList.add(artistler.get(i));
            }

        i++;
        }

        return queriedArtistList;
    }

    /*public ArrayList<Artist> AskQuestion2(String artistName , String input) {

        boolean isMatchQuestion = false;
        int j = 0;

        while(j < queriedArtistList.size())
        {

            mPattern2 =  Pattern.compile("");

            mMatcher2 =


            j++;
        }

        return queriedArtistList;
    }

*/
}

