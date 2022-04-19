package com.pregatit.rateit.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pregatit.rateit.db.entities.Category;
import com.pregatit.rateit.db.entities.Product;

import java.lang.reflect.Type;

public class Singleton {
    private static Singleton INSTANCE = null;
    private static GsonBuilder builder = null;

    public static String APP_NAME = "RateIt";
    private static String test = "test";

    private Singleton() {
        builder = new GsonBuilder();
    };

    public static Singleton getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE = new Singleton();
        }
        return (INSTANCE);
    }

    public static Object getInstanceFromJson(String json, Type type){
        return getGson().fromJson(json,type);
    }

    //creaza un produs dintr-un json
    public static Product getProductFromJson(String json)
    {
        return (Product) Singleton.getInstanceFromJson(json,Product.class);
    }

    //creaza o categorie dintr-un json
    public static Category getCategoryFromJson(String json)
    {
        return (Category) Singleton.getInstanceFromJson(json,Category.class);
    }

    public static Gson getGson()
    {
        if (null == builder){
            builder = new GsonBuilder();
        }
        return builder.create();
    }

    public static String test()
    {
        return "works";
    }

    public static String getTest() {
        return test;
    }

    public static void setTest(String test) {
        Singleton.test = test;
    }
}
