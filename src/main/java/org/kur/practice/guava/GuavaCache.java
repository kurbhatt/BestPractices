package org.kur.practice.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * This class demonstrate the cache mechanism provide by google guava.
 * Created by Keyur on 18/8/17.
 */
public class GuavaCache {

    public static void main(String[] args) throws ExecutionException {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                return key.toUpperCase();
            }
        };

        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder()
            .expireAfterWrite(10,TimeUnit.MINUTES)
            .build(loader);
        cache.put("1", "a");
        cache.put("2", "b");
        cache.put("3", "c");

        System.out.println(cache.get("1"));
    }
}
