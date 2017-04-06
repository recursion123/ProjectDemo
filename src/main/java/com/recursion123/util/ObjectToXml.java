package com.recursion123.util;

import com.recursion123.model.Role;
import com.recursion123.model.User;
import org.dom4j.*;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by zhang on 2017/3/3.
 */

public class ObjectToXml {
    public static <T> String toXml(T obj) throws Exception {
        Document document = DocumentHelper.createDocument();
        Element root = DocumentHelper.createElement(obj.getClass().getName());
        document.add(createElementByObj(obj, root));
        return document.asXML();
    }

    private static <T> Element createElementByObj(T obj, Element element)
            throws Exception {
        if (obj == null) {
            return element;
        }
        for (Field f : obj.getClass().getDeclaredFields()) {
            if (!CanHandleType(f.getType())) {
                break;
            }
            if (f.getType() == String.class) {
                Element objElement = DocumentHelper.createElement(f
                        .getName());
                Object tempObj = getValue(obj, f);
                if (tempObj != null) {
                    objElement.setText(tempObj.toString());
                }
                element.add(objElement);
            } else if (f.getType() == List.class) {
                Object tempObj = getValue(obj, f);
                if (tempObj != null) {
                    for (Object listObj : (List) tempObj) {
                        element.add(createElementByObj(listObj,
                                DocumentHelper
                                        .createElement(f.getName())));
                    }
                }
            } else {
                element.add(createElementByObj(getValue(obj, f),
                        DocumentHelper.createElement(f
                                .getName())));
            }
        }
        return element;
    }

    private static Boolean CanHandleType(Class clazz) {
        return !clazz.getName().equals("boolean")
                && !clazz.getName().equals("int");
    }

    private static <T> Object getValue(T obj, Field f) {
            try {
                return obj.getClass().getDeclaredMethod("get" + upperCase(f.getName()))
                        .invoke(obj);
            } catch (Exception e) {
                return null;
            }
    }

    private static String upperCase(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }

    public static void main(String[] args) throws Exception {

    }
}
