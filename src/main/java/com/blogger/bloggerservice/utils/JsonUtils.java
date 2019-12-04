package com.blogger.bloggerservice.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

/**
 * Created by apple on 19/3/18.
 */
public class JsonUtils {

    private static Gson gson = null;
    static {
        if(gson == null){
            gson = new Gson();
        }
    }

    private JsonUtils() {

    }

    /**
     * 对象转字符串
     * @param object
     * @return
     */
    public static String objectToString(Object object) {
        String jsonString = null;
        if(gson != null) {
            jsonString = gson.toJson(object);
        }
        return jsonString;
    }

    /**
     * json转对象
     * @param jsonString
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T jsonToBean(String jsonString, Class<T> cls) {
        T t = null;
        if(gson != null) {
            t = gson.fromJson(jsonString, cls);
        }
        return t;
    }

    /**
     * json转List
     * @param jsonString
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> cls) {
        List<T> list = null;
        if(gson != null) {
            list = gson.fromJson(jsonString, new TypeToken<List<T>>(){}.getType());
        }
        return list;
    }

    /**
     * json转List<Map>
     * @param jsonString
     * @param <T>
     * @return
     */
    public static <T> List<Map<String,T>> jsonToListMaps(String jsonString) {
        List<Map<String,T>> list = null;
        if(gson != null) {
            list = gson.fromJson(jsonString, new TypeToken<List<Map<String,T>>>(){}.getType());
        }
        return list;
    }

    /**
     * json转Map
     * @param jsonString
     * @param <T>
     * @return
     */
    public static <T> Map<String, T> jsonToMap(String jsonString) {
        Map<String, T> map = null;
        if(gson!= null) {
            map = gson.fromJson(jsonString, new TypeToken<Map<String, T>>(){}.getType());
        }
        return map;
    }

}
