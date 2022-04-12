package com.pregatit.rateit;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void onInsertProductClick(View v) {
        Intent i = new Intent(this, InsertProductPage.class);
        startActivity(i);
    }  

    public void onClickbuttonCategory(View view)
    {
        Intent i = new Intent(MainMenu.this,CategoryProductsPage.class);
        startActivity(i);
    }

    public void OnAjutorClick(View v)
    {
        Intent i = new Intent(this, ajutorSelectie.class);
        startActivity(i);
    }
    public void OnLogOutClick(View v)
    {
        Intent i = new Intent(this, LoginPage.class);
        startActivity(i);
    }

    public void OnSettingsButtonClick(View v)
    {
        Intent i = new Intent(this, SettingsPage.class);
        startActivity(i);
    }
}