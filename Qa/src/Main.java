import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import model.Album;
import model.Artist;
import utils.ArtistQuestionHelper;
import utils.BinarySearchTree;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.print.attribute.Attribute;
import javax.sound.midi.Soundbank;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


// need to import this as the STEP 1. Has the classes that you mentioned
public class Main {
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String RESET = "\033[0m";  // Text Reset

    public static ArrayList<Artist> artistList;
    public static ArrayList<String> artistName;
    public static ArrayList<Artist> queriedArtists;
    public static BinarySearchTree tree;
    public static Date currentDate = new Date();
    static SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");

    static ArtistQuestionHelper mArtistQuestionHelper;
    static boolean isMatch2;
    static Pattern mPattern2;
    static Matcher mMatcher2;
    static ArrayList<String> words;


    public static void main(String[] args)  {
        loadWordsList();

        artistList = new ArrayList<>();
        artistName = new ArrayList<>();
        tree =  new BinarySearchTree();
        queriedArtists = new ArrayList<>();
        mArtistQuestionHelper = new ArtistQuestionHelper(artistList);
        parseArtist();
        parseAlbums();
        //Albumlerin ismini yazdırmak için
        //tree.inorder();
        System.out.println(artistName.toString());

//        System.out.print("Arama kelimsesini giriniz: ");
//        albumSearch();



        System.out.println("\nBilgilerini öğrenmek istediğiniz sanatçıyı aratınız.");
        artistSearch();






    }

    public static void albumSearch(){
        Scanner sc = new Scanner(System.in);
        boolean devam =true;
        while (devam){
            String input = sc.nextLine();
            if (input.compareToIgnoreCase("q") ==0){
                break;
            }
            try{
                ArrayList<Artist> artistler = tree.albumSearh(tree.getRoot(),input).album.getArtists();
                for (Artist a: artistler){
                    System.out.println("Artist(ler): " + a.getArtistName() );
                }
            }catch (NullPointerException nlpExc){
                System.out.println("Aranan albüm Database'de bulunamadı: " + input );
            }
            System.out.print("Başka albüm: "  );
        }
        System.out.print("Arama kelimsesini giriniz: ");
    }
    public static void artistSearch(){
        Scanner sc = new Scanner(System.in);
        boolean devam =true;
        String input;
        while (devam){
             input = sc.nextLine();
            if (input.compareToIgnoreCase("q") ==0){
                break;
            }
            queriedArtists = mArtistQuestionHelper.AskQuestion(artistList,artistName,input);
            if (queriedArtists.size()==0){
                //TODO şarkıcı bulumaöayınca -1 dödünr albümlerde ara
                System.out.print("Sonuç bulunamadı");
            }else {
                String mkelime="";
                int mIndex=-1;
                for (int j =0;j<queriedArtists.size();j++){
                    isMatch2 = false;
                    for (int k=0; k<words.size();k++) {
                        mPattern2 = Pattern.compile("[[\\w]*[^\\w]*]*" + words.get(k)+ "[[\\w]*[^\\w]*]*");
                        mMatcher2 = mPattern2.matcher(input);
                        isMatch2 = mMatcher2.matches();
                        if (isMatch2){
                            mIndex = k;
                            break;
                        }
                    }
                    if (isMatch2== true)
                    {
                        if (mIndex == 0){
                            System.out.println(queriedArtists.get(j).getArtistName() + " Spotify linki: " + queriedArtists.get(j).getExternalUrl());
                        }else if (mIndex ==1 || mIndex ==9){
                            System.out.println(queriedArtists.get(j).getArtistName() + " Spotify popülerlik derecesi: " + queriedArtists.get(j).getPopularity() + "%");
                        }else if (mIndex ==2){
                            System.out.println(queriedArtists.get(j).getArtistName() + " Spotify takipçi sayısı: " + queriedArtists.get(j).getFollowersTotal());
                        }else if (mIndex ==3 || mIndex == 4){
                            System.out.println(queriedArtists.get(j).getArtistName() + " şu türlerde söyler: " + queriedArtists.get(j).getGenres().toString());
                        }else if (mIndex ==5){
                            System.out.println(queriedArtists.get(j).getArtistName() + " burada doğmuştur: " + queriedArtists.get(j).getBirthPlace());
                        }else if (mIndex ==6 || mIndex == 7 || mIndex == 8){
                            System.out.println(queriedArtists.get(j).getArtistName() + " doğum tarihi: " +queriedArtists.get(j).getBirthDay() +
                                    "\nYaşı: "+ calculateAge(queriedArtists.get(j).getBirthDay()));
                        }
                    }else {
                        System.out.printf(queriedArtists.get(j).toString());
                    }
                }
            }
            System.out.println("\nBilgilerini öğrenmek istediğiniz sanatçıyı aratınız.");
        }
    }


    private static void loadWordsList() {
        words = new ArrayList<>();
        words.add("link");
        words.add("popüler");
        words.add("takip");
        words.add("tür");
        words.add("tip");
        words.add("ner");
        words.add("yaş");
        words.add("tarih");
        words.add("zaman");
        words.add("puan");

    }
    static public int calculateAge(Date birthDate) {
        long timeBetween  = currentDate.getTime() - birthDate.getTime();
        double yearsBetween = timeBetween / 3.15576e+10;
        int age = (int) Math.floor(yearsBetween);
        return age;
    }
    public static void parseArtist( ){
        try {
            JSONArray artistJSON = (JSONArray) new JSONParser().parse(new FileReader("artists.json"));

            for (int i = 0 ; i<artistJSON.size();i++)
            {
                Artist artist = new Artist();
                JSONObject jsonObject = (JSONObject) artistJSON.get(i);
                JSONObject joT;
                artist.setArtistName((String) jsonObject.get("name"));

                dateFormat=new SimpleDateFormat("yyyy-mm-dd");
                try {
                    artist.setBirthDay(dateFormat.parse((String) jsonObject.get("birthday")));
                } catch (java.text.ParseException e) {
                    e.printStackTrace();
                }
                artist.setBirthPlace((String)jsonObject.get("birthplace"));
                artist.setPopularity(Integer.parseInt(""+ jsonObject.get("popularity")));
                artist.setType((String) jsonObject.get("type"));
                artist.setSpotifyId((String) jsonObject.get("id"));
                joT = (JSONObject) jsonObject.get("followers");
                artist.setFollowersTotal(Integer.parseInt(""+ joT.get("total")));
                joT = (JSONObject) jsonObject.get("external_urls");
                artist.setExternalUrl((String) joT.get("spotify"));
                artist.setHref((String) jsonObject.get("href"));
                artist.setGenres((ArrayList<String>) jsonObject.get("genres"));


                //artist.setGenres(jsonObject.get);

                artistList.add(artist);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error while open file");
            e.printStackTrace();
        }  catch (IOException e) {
            System.out.println("Error IO excp");
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static void parseAlbums(){
        for (int j=0; j<artistList.size();j++) {
            try {
                artistName.add(artistList.get(j).getArtistName()) ;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        try {
            JSONArray albumJSOn = (JSONArray) new JSONParser().parse(new FileReader("albums.json"));

            for (int i = 0 ; i<albumJSOn.size();i++)
            {
                Album album = new Album();
                JSONObject jsonObject = (JSONObject) albumJSOn.get(i);
                JSONObject joT;

                album.setAlbumName((String) jsonObject.get("name"));
                album.setAlbumGroup((String)jsonObject.get("album_group"));
                album.setAlbumGroup((String)jsonObject.get("album_type"));
                JSONArray albumArtists = (JSONArray) jsonObject.get("artists");
                for (int k=0;k<albumArtists.size();k++){
                    JSONObject jo = (JSONObject) albumArtists.get(k);
                    String type = (String) jo.get("type");

                    if (type.compareToIgnoreCase("artist") == 0){
                        Artist artist = new Artist();
                        String name = (String) jo.get("name");

                        if (artistName.contains(name)){
                            int index = artistName.indexOf(name);
                            album.addArtists(artistList.get(index));
                        }else {
                            artist.setArtistName((String) jo.get("name"));
                            artist.setSpotifyId((String) jo.get("id"));
                            artist.setType("artist");
                            album.addArtists(artist);
                        }
                    }else {
                        Artist artist = new Artist();
                        artist.setArtistName((String) jo.get("name"));
                        artist.setSpotifyId((String) jo.get("id"));
                        artist.setType("group");
                        album.addArtists(artist);
                    }
                    jo =null;
                }
                joT = (JSONObject) jsonObject.get("external_urls");
                album.setExternalUrl((String) joT.get("spotify"));
                album.setHref((String) jsonObject.get("href"));
                album.setId((String) jsonObject.get("id"));
                SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
                try {
                    album.setReleaseDate(dateFormat.parse((String) jsonObject.get("release_date")));
                } catch (java.text.ParseException e) {
                    dateFormat = new SimpleDateFormat("yyyy");
                    try {
                        album.setReleaseDate(dateFormat.parse((String) jsonObject.get("release_date")));
                    } catch (java.text.ParseException e1) {
                        e1.printStackTrace();
                    }
                }
                album.setReleaseDatePrecision((String) jsonObject.get("release_date_precision"));
                album.setTotalTracks(Integer.parseInt(""+jsonObject.get("total_tracks")));


                //                try{
//
//
//                }catch (NumberFormatException ex){
//                    System.out.println("//-/-/-/-/-/--/-/-/-/-/--/--/-/-/-/-/-/-/-/-/-/-/--/-/-/-/-/-/");
//                    ex.printStackTrace();
//                }catch (NullPointerException np){
//                    np.printStackTrace();
//                }
//                album.setType((String) joT.get("type"));

                joT = null;
                tree.insert(album);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error while open file");
            e.printStackTrace();
        }  catch (IOException e) {
            System.out.println("Error IO excp");
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}


