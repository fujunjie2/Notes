package com.klxx.api.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.klxx.api.bdmap.pojo.vo.PlaceApiVo;
import com.klxx.api.bdmap.pojo.vo.PlaceDetailVo;

import java.util.ArrayList;

public class JacksonUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
    }


    public static  <T> T convertToSimple(String body, Class<T> tClass) throws Exception{
        return mapper.readValue(body, tClass);
    }


    public static  <T, K> T convertToComplex(String body, Class<T> rootClass, Class<K> innerClass) throws Exception{
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        JavaType type = mapper.getTypeFactory().constructParametricType(ArrayList.class, innerClass);

        JavaType javaType = mapper.getTypeFactory().constructParametricType(rootClass, type);
        return mapper.readValue(body, javaType);
    }


    public static String toJsonString(Object obj) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) throws Exception {
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        String str = "{\"status\": 0, \"results\": [{\"name\": \"东单篮球场\", \"address\": \"崇文门内大街108号\", \"location\": {\"lat\": 34.3434}}]}";

        JavaType type = mapper.getTypeFactory().constructParametricType(ArrayList.class, PlaceDetailVo.class);

        JavaType javaType = mapper.getTypeFactory().constructParametricType(PlaceApiVo.class, type);

        PlaceApiVo vo = convertToComplex(str, PlaceApiVo.class, PlaceDetailVo.class);

        System.out.println(121);
    }
}
