package com.pregatit.rateit;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;


import android.os.Bundle;
import android.widget.Toast;


public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }
    public void onClickbuttonCategory(View view)
    {
        Intent i = new Intent(MainMenu.this,CategoryProductsPage.class);
        startActivity(i);

    }
}