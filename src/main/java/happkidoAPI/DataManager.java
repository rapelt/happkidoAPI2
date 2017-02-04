package happkidoAPI;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class DataManager {

    private static final Logger log = Logger.getLogger(DataManager.class.getName());

    InputStream input = null;

    Properties prop = new Properties();

    private static DB happkidoDB;

    private static DataManager INSTANCE;

    private static String textUri;

    public static DataManager getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new DataManager();
        }

        return INSTANCE;
    }

    private DataManager() {

        try {
            MongoClientURI uri;
            try {
                uri = new MongoClientURI(System.getenv("dburi"));
                log.info("Connecting via DATABASE_URL environment variable");
            } catch (NullPointerException ex) {
                input = new FileInputStream("dburi.properties");
                prop.load(input);
                System.out.println(prop.getProperty("dburi"));
                uri = new MongoClientURI(prop.getProperty("dburi"));
                log.info("Connecting via localDatabaseUrl properties key/value ***");
            }

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