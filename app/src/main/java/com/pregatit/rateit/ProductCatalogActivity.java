package com.pregatit.rateit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.pregatit.rateit.db.DbHelper;

public class ProductCatalogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_catalog2);
    }

    public void onBackClick(View v){
        Intent i = new Intent(this, MainMenuActivity.class);
        startActivity(i);

        DbHelper db = new DbHelper(this);

    }
}