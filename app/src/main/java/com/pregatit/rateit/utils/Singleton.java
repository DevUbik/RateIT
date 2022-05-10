package com.pregatit.rateit.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pregatit.rateit.db.entities.Category;
import com.pregatit.rateit.db.entities.Product;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;

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
    public static ArrayList<Product> getProductFromJson(String json)
    {
        Type ProductListType = new TypeToken<ArrayList<Product>>(){}.getType();
        return Singleton.getGson().fromJson(json,ProductListType);
    }

    //creaza o categorie dintr-un json
    public static Category getCategoryFromJson(String json)
    {
        return (Category) Singleton.getInstanceFromJson(json,Category.class);
    }

    public static ArrayList<Category> getArrayCategoryFromJson(String json)
    {
        Type CategoryListType = new TypeToken<ArrayList<Category>>(){}.getType();
        return Singleton.getGson().fromJson(json,CategoryListType);
    }

    //creaza un json dintr-o categorie
    public static String getJsonFromCategory(Category category)
    {
        return getGson().toJson(category);
    }

    //creaza un json dintr-o produs
    public static String getJsonFromProduct(Product product)
    {
        return getGson().toJson(product);
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
