package happkidoAPI.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.operations.Bool;
import happkidoAPI.DataManager;
import com.mongodb.*;
import happkidoAPI.grade.Grade;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class UserRepository {

    private static final Logger log = Logger.getLogger(UserRepository.class.getName());

    private static UserRepository INSTANCE;

    DBCollection db;

    public static UserRepository getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new UserRepository();
        }

        return INSTANCE;
    }

    public UserRepository (){
        db = DataManager.getInstance().getCollectionByName("users");
    }


    public User mapUserFromdDBObject(DBObject dbObject) throws IOException {
        Gson gson = new Gson();

        User user = gson.fromJson(dbObject.toString(), User.class);

        user.setId(dbObject.get("_id").toString());

        return user;
    }

    public List<User> findAllUsers() {

        List<User> users = new ArrayList<User>();

        try {
            DBCursor cursor = db.find();

            if (cursor != null) {

                while (cursor.hasNext()) {

                    BasicDBObject doc = (BasicDBObject) cursor.next();

                    User item = mapUserFromdDBObject(doc);

                    users.add(item);
                }

                return users;
            }

            return null;
        } catch (Exception e) {

        }

        return null;
    }

    public User findUserById(String id) {

        User user;

        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("_id", new ObjectId(id));

        try {
            DBCursor cursor = db.find(whereQuery);

            if (cursor != null) {
                while (cursor.hasNext()) {

                    BasicDBObject doc = (BasicDBObject) cursor.next();

                    user = mapUserFromdDBObject(doc);

                    return user;
                }
            }

            return null;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public User createUser(User user) {

        //TODO this method
        return user;
    }

    public User updateUser(String id, User user) {
        /*BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("_id", new ObjectId(id));

        db.update(whereQuery, User);
        //TODO this method*/
        return user;
    }
}
