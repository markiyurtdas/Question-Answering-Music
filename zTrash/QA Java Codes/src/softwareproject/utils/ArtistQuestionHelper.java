/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareproject.utils;

import softwareproject.model.Artist;



/**
 *
 * @author marki
 */
public class ArtistQuestionHelper {
    private softwareproject.model.Artist artist;
    
    public ArtistQuestionHelper() {
    }
    
    public String AskQuestion(String string){
        if(string.equalsIgnoreCase("name")){
            return artist.getArtistName();
        }else if(string.equalsIgnoreCase("followers")){
            return      ""+ artist.getFollowersTotal();
        }else if(string.equalsIgnoreCase("href")){
            return artist.getHref();
        }else if(string.equalsIgnoreCase("id")){
            return ""+artist.getSpotifyId();
        }else if(string.equalsIgnoreCase("image")){
            return artist.getImageUrl();
        }else if(string.equalsIgnoreCase("popularity")){
            return ""+artist.getPopularity();
        }else if(string.equalsIgnoreCase("type")){
            return artist.getType();
        }else{
            return "Hata. Yazdığınız soruyu kontrol edin !!";
        }
        
        
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
    
    
    
    
    
    
}
