package happkidoAPI;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.apache.log4j.Logger;


public class DataManager {

    private static final Logger log = Logger.getLogger(DataManager.class.getName());


    private static DB happkidoDB;

    private static DataManager INSTANCE;

    private static String textUri;

    public static DataManager getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new DataManager();
        }

        return INSTANCE;
    }

    public static DataManager getInstance(String uri) {

        uri = uri.substring(1, uri.length());

        setDB(uri);

        if (INSTANCE == null) {
            INSTANCE = new DataManager(uri);
        }

        return INSTANCE;
    }

    private DataManager() {

        try {
            MongoClientURI uri = new MongoClientURI(textUri);

            MongoClient mongoClient = new MongoClient(uri);

            happkidoDB = mongoClient.getDB(uri.getDatabase());


        } catch (Exception e) {
            log.error("db connection error e=", e);
        }

    }

    private DataManager(String textUri) {

        try {
            MongoClientURI uri = new MongoClientURI(textUri);

            MongoClient mongoClient = new MongoClient(uri);

            happkidoDB = mongoClient.getDB(uri.getDatabase());


        } catch (Exception e) {
            log.error("db connection error e=", e);
        }

    }

    public static void setDB (String uri) {
        textUri = uri;
    }

    public DBCollection getCollectionByName(String collectionName){

        boolean users = happkidoDB.collectionExists(collectionName);

        if(users){
            DBCollection usersDb = happkidoDB.getCollection(collectionName);
            return usersDb;
        } else {
            System.out.println("Collection does not exist " + collectionName);
        }

        return null;
    }

    public DB getDB (){
        return happkidoDB;
    }
}