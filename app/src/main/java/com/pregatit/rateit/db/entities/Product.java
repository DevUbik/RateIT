package com.pregatit.rateit.db.entities;

import java.util.Date;

public class Product {
    //steps for entities:
    //1 constante pentru baza de date
    public static final String TABLE_NAME = "products";
    public static final String COLUMN_ID  = "products_id";
    public static final String COLUMN_NAME  = "product_name";
    public static final String COLUMN_RATING = "products_rating";
    public static final String COLUMN_LAST_UPDATE = "products_update";

    //2 variabile
    private int id;
    private String name;
    private float rating;
    private Date update;

    //3 constructori

    public Product()
    {

    }

    public Product(int id, String name, float rating)
    {
        //initializam toate campurile
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    //4 getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    // 5. SQL QUERY
    public static final String CREATE_TABLE =
            "CREATE TABLE" + TABLE_NAME + "("
            + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NAME + "TEXT,"
            + COLUMN_RATING + "REAL"
            + COLUMN_LAST_UPDATE + "DATETIME DEFAULT CURRENT_TIMESTAMP"
            + ")";
}
