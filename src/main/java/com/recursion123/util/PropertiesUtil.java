package com.recursion123.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by zhang on 2016/12/9.
 */
public class PropertiesUtil {
    public static Properties getPro(String name) {
        Properties properties = new Properties();
        InputStream is = PropertiesUtil.class.getClassLoader().getResourceAsStream(name+".properties");
        try {
            properties.load(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
}
