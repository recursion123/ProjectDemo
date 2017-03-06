package com.recursion123.util;

import com.mongodb.*;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2017/1/22.
 * mongodb连接
 */
public enum MongoUtil {
    COLLECTIONS;

    private Mongo mongo;

    private String mongoConfig = "mongoConfig";
    private String mongoDatabase = PropertiesUtil.getPro(mongoConfig).getProperty("mongoDatabase");
    private String mongoUsername = PropertiesUtil.getPro(mongoConfig).getProperty("mongoUsername");
    private String mongoPassword = PropertiesUtil.getPro(mongoConfig).getProperty("mongoPassword");
    private String mongoAddress = PropertiesUtil.getPro(mongoConfig).getProperty("mongoAddress");

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
