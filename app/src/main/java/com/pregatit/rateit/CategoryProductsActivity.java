package com.pregatit.rateit;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;


import com.pregatit.rateit.db.DbHelper;
import com.pregatit.rateit.db.entities.Category;
import com.pregatit.rateit.db.entities.Product;
import com.pregatit.rateit.utils.Singleton;


public class CategoryProductsActivity extends AppCompatActivity {
    TextView textView= findViewById(R.id.myusername);
    private Context context;
    private LayoutInflater factory;
    private ScrollView categoryList;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_products_page);
        textView.setText("test");
        this.context = getApplicationContext();

        //campuri pentru imagini categorii
        String category1_image="@string/category1";
        String category2_image="@string/category2";
        String category3_image="@string/category3";
        String category4_image="@string/category4";
        String category5_image="@string/category5";
        String category6_image="@string/category6";
        String category7_image="@string/category7";
        String category8_image="@string/category8";


        String produsJson1 = "{'name':'Ciocolata cu lapte','rating':3.8,'update':null}";
        String produsJson2 = "{'name':'Jeleuri','rating':3.8,'update':null}";
        String produsJson3 = "{'name':'Fursecuri','rating':3.2,'update':null}";


        //Product dummyData1 = Singleton.getProductFromJson(produsJson1);
        //Product dummyData2 = Singleton.getProductFromJson(produsJson2);
        //Product dummyData3 = Singleton.getProductFromJson(produsJson3);

        this.factory = LayoutInflater.from(context);

        clearContent();
        setContent();
    }

    private void clearContent()
    {
        this.categoryList.removeAllViews();
    }

    public void setContent()
    {
        //json pentru produse si pentru categorie
        String produsJson1 = "{'name':'Ciocolata cu lapte','rating':4.1,'update':null}";
        String produsJson2 = "{'name':'Jeleuri','rating':3.8,'update':null}";
        String produsJson3 = "{'name':'Fursecuri','rating':3.2,'update':null}";

        Category dummyCategory = Singleton.getCategoryFromJson(produsJson1);
        dummyCategory = Singleton.getCategoryFromJson(produsJson2);
        dummyCategory = Singleton.getCategoryFromJson(produsJson3);


    }
    public void BackButtonCategory(View v) {
        Intent i = new Intent(CategoryProductsActivity.this, MainMenuActivity.class);
        startActivity(i);

    }
}