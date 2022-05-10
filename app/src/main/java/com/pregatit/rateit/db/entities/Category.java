package com.pregatit.rateit.db.entities;

import java.util.Calendar;
import java.util.Date;

public class Category {
    //2 variabile
    private int id;
    private String name;
    private int image;
    private Date update;


    //3 constructors
    public Category()
    {

    }

    //categorie ("lactate",null)
    public Category(String name, Date update)
    {
        this.name = name;
        if (update == null)
        {
            this.update = Calendar.getInstance().getTime();
        } else {
            this.update = update;
        }
    }

    //4 getters and setters

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

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

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }
}
