/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author jesus
 */
public class JsonParser {

    private static ObjectMapper mObjectMapper;

    private static ObjectMapper getMapper() {
        if (mObjectMapper == null) {
            mObjectMapper = new ObjectMapper();
        }
        return mObjectMapper;
    }

    public static <T> T entity(String json, Class<T> tClass) throws IOException {
        return getMapper().readValue(json, tClass);
    }

    public static <T> ArrayList<T> arrayList(String json, Class<T> tClass) throws IOException {
        TypeFactory typeFactory = getMapper().getTypeFactory();
        JavaType type = typeFactory.constructCollectionType(ArrayList.class, tClass);
        return getMapper().readValue(json, type);
    }

    public static String toJson(Object object) throws IOException {
        return getMapper().writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }
}
