package com.pregatit.rateit.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pregatit.rateit.db.entities.Product;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    //constante necesare pentru helper
    private static final int DATABASE_VERSION = 1; // de fiecare care data cand faceti o modificare la baza de date sa incrementati aceasta valoare
    private static final String DATABASE_NAME = "rate_it_db";

    public DbHelper(Context context){
        //apelam constructorul din parinte
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        //restul codului.
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Product.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Product.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    /*
    * select COLUMN_ID, COLUMN_RATING.... where
    * */
    public Product getProduct(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Product.TABLE_NAME,
                new String[]{
                        Product.COLUMN_ID,
                        Product.COLUMN_RATING,
                        Product.COLUMN_NAME,
                        Product.COLUMN_LAST_UPDATE
                },
                Product.COLUMN_ID + "=?"
                ,
                new String[]{
                     String.valueOf(id)
                },
                null,
                null,
                null,
                null
                );

        if (cursor != null)
        {
            cursor.moveToFirst();
        }

        Product product = new Product(
                cursor.getInt(cursor.getColumnIndexOrThrow(Product.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Product.COLUMN_NAME)),
                cursor.getFloat(cursor.getColumnIndexOrThrow(Product.COLUMN_RATING))
        );

        cursor.close();
        return product;
    }

    //get all products
    public ArrayList<Product> getAllProducts ()
    {
        ArrayList<Product> products = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + Product.TABLE_NAME + " ORDER BY " +
                Product.COLUMN_ID + " DESC";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);


        if (cursor.moveToFirst())
        {
            do{
                Product product = new Product(
                        cursor.getInt(cursor.getColumnIndexOrThrow(Product.COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Product.COLUMN_NAME)),
                        cursor.getFloat(cursor.getColumnIndexOrThrow(Product.COLUMN_RATING))
                );

                products.add(product);
            } while (cursor.moveToNext());
        }

        cursor.close();

        return products;
    }

    public int updateProduct(Product product){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Product.COLUMN_NAME,product.getName());
        values.put(Product.COLUMN_RATING, product.getRating());

        return db.update(Product.TABLE_NAME,values,Product.COLUMN_ID + " = ? ",
                new String[]{
                        String.valueOf(product.getId())
                });
    }

    public void deleteProduct(Product product)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Product.TABLE_NAME,Product.COLUMN_ID + " = ? ",
                new String[]{
                        String.valueOf(product.getId())
                });
        db.close();
    }
}
