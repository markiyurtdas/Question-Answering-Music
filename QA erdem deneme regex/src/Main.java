import model.Artist;
import utils.BinarySearchTree;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
*/


// need to import this as the STEP 1. Has the classes that you mentioned
public class Main {
        public static ArrayList<Artist> artistList;
        public static ArrayList<String> artistName;
        public static BinarySearchTree tree;
        public static void main(String[] args)  {

            artistList = new ArrayList<>();
            artistName = new ArrayList<>();
            tree =  new BinarySearchTree();

        //    parseArtist();
        //    parseAlbums();


            callArtist();




            for (int j=0; j<artistList.size();j++) {
                try {
                    artistName.add(artistList.get(j).getArtistName()) ;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            tree.inorder();

            System.out.println(artistList.get(0));


            //kim tarkan, kimdir tarkan,tarkan kim, tarkan kimdir

            int i= 0;
            while(i<artistName.size()) {



                Pattern p = Pattern.compile("kim\\s" + artistName.get(i) + "[?]*");

                Matcher m = p.matcher("kim tarkan?");

                boolean b = m.matches();

                if (b == true)
                {
                    //System.out.println(i);
                    artistList.get(i);
                }


                i++;
            }



            /*
            Class.forName("com.mysql.jdbc.Driver");
            DatabaseInfo dbInfo = new DatabaseInfo();
            String instanceConnectionName =dbInfo.getInstanceConnectionName();
            String databaseName = dbInfo.getDatabaseName() ;
            String IP_of_instance =dbInfo.getIP_of_instance();
            String username =dbInfo.getUsername();
            String password = dbInfo.getPassword();
            String jdbcUrl = String.format(
                    "jdbc:mysql://" + IP_of_instance +  ":3306/"+
                            databaseName + "?zeroDateTimeBehavior=convertToNull"
     );
            String sqlInsert = "INSERT INTO `SAP`.`Artist` (`Name`, `ArtistID`, `External_urls`, `"
                       + "Followers`, `Genres`, `Href`, `"
                       + "Image_url`, `Popularity`, `Type`) "
                       + "VALUES ('eminem', 'asd5a5d', 'asda', "
                       + "45245, 'asd,asda,asd', 'asdada', "
                       + "'asdasd', 55, 'artist" +
    "     ')";
            Connection connection = null;
            Statement stmt = null;
            try (Statement statement = connection.createStatement()) {
               System.out.println("Connecting to a selected database...");
               connection = DriverManager.getConnection(jdbcUrl, username, password);
               System.out.println("Connected database successfully...");
               insertIntoDB(stmt, connection, sqlInsert);
            }catch(Exception e){
              e.printStackTrace();        }*/
        }

        public static void callArtist()
        {
            Artist artist = new Artist();
            Artist artis2 = new Artist();

            artis2.setArtistName("eminem");

            artist.setExternalUrl("externalurl tarkan");

            ArrayList<String> tarkans = new ArrayList<String >();
            tarkans.add("pop");
            tarkans.add("rock");

            artist.setGenres(tarkans);
            artist.setHref("tarkan Href");
            artist.setSpotifyId("spotify id tarkan");
            artist.setArtistName("tarkan");
            artist.setPopularity(100);
            artist.setType("sarkici");

            artistList.add(artist);
            artistList.add(artis2);

        }

        /*
        public static void parseArtist( ){
            try {
                JSONArray artistJSON = (JSONArray) new JSONParser().parse(new FileReader("artists.json"));

                for (int i = 0 ; i<artistJSON.size();i++)
                {
                    Artist artist = new Artist();
                    JSONObject jsonObject = (JSONObject) artistJSON.get(i);
                    JSONObject joT;
                    artist.setArtistName((String) jsonObject.get("name"));
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
                        JSONObject jo = (JSONObject) albumJSOn.get(k);
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
                    }
                    joT = (JSONObject) jsonObject.get("external_urls");
                    album.setExternalUrl((String) joT.get("spotify"));
                    album.setHref((String) joT.get("href"));
                    album.setId((String) joT.get("id"));
                    album.setReleaseDate((Date) joT.get("release_date"));
                    album.setReleaseDatePrecision((String) joT.get("release_date_precision"));
    //                try{
    //                    album.setTotalTracks((Integer) joT.get("total"));
    //
    //                }catch (NumberFormatException ex){
    //                    System.out.println("//-/-/-/-/-/--/-/-/-/-/--/--/-/-/-/-/-/-/-/-/-/-/--/-/-/-/-/-/");
    //                    ex.printStackTrace();
    //                }catch (NullPointerException np){
    //                    np.printStackTrace();
    //                }
    //                album.setType((String) joT.get("type"));

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
        */

}


