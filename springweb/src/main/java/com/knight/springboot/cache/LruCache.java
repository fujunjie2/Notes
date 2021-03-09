package com.knight.springboot.cache;

import com.fasterxml.jackson.databind.util.LRUMap;

import java.util.LinkedHashMap;

public class LruCache {

    public static void main(String[] args) {
        LRUMap<String, Object> lruMap = new LRUMap<>(100, 1000);


    }
}
