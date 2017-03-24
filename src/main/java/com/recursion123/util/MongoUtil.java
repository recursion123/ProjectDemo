package com.recursion123.util;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by zhang on 2017/1/22.
 * mongodb连接
 */
public enum MongoUtil {
    COLLECTIONS;

    private Mongo mongo;
    private String mongoConfig = "mongoConfig";
    private Properties properties = PropertiesUtil.getPro(mongoConfig);

    private String mongoDatabase = properties.getProperty("mongoDatabase");
    private String mongoUsername = properties.getProperty("mongoUsername");
    private String mongoPassword = properties.getProperty("mongoPassword");
    private String mongoAddress = properties.getProperty("mongoAddress");

    private Mongo getConnect() {
        if (mongo == null) {
            List<ServerAddress> addresses = new ArrayList<>();
            for (String str : mongoAddress.split(";")) {
                addresses.add(new ServerAddress(str.split(":")[0],
                        Integer.valueOf(str.split(":")[1])));
            }
            if (!StringUtils.isEmpty(mongoUsername) && !StringUtils.isEmpty(mongoPassword)) {
                MongoCredential credential = MongoCredential
                        .createCredential(mongoUsername, mongoDatabase,
                                mongoPassword.toCharArray());
                List<MongoCredential> credentials = new ArrayList<>();
                credentials.add(credential);
                mongo = new MongoClient(addresses, credentials);
            } else {
                mongo = new MongoClient(addresses);
            }
            return mongo;
        } else {
            return mongo;
        }
    }

    public MongoCollection getCollection(String name) {
        return new Jongo(getConnect().getDB(mongoDatabase)).getCollection(name);
    }

}
