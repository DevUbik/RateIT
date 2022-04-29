package com.pregatit.rateit;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void onProductCatalogClick(View v){
        Intent i = new Intent(this, ProductCatalogActivity.class);
        startActivity(i);
    }  


    public void onInsertProductClick(View v) {
        Intent i = new Intent(this, InsertProductActivity.class);
        startActivity(i);
    }  

    public void onClickCategory(View v)
    {
        Intent i = new Intent(this, CategoryProductsActivity.class);
        startActivity(i);
    }

    public void OnAjutorClick(View v)
    {
        Intent i = new Intent(this, SelectionHelpActivity.class);
        startActivity(i);
    }
    public void OnLogOutClick(View v)
    {
        Intent i = new Intent(this, LoginPageActivity.class);
        startActivity(i);
    }

    public void OnSettingsButtonClick(View v)
    {
        Intent i = new Intent(this, SettingsPageActivity.class);
        startActivity(i);
    }
}