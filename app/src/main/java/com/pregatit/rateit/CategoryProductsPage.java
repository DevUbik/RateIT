package com.pregatit.rateit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;

import org.w3c.dom.Text;

public class CategoryProductsPage extends AppCompatActivity {
TextView username= (TextView) findViewById(R.id.username);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_products_page);
        username.setText("test");
    }

    public void onClickBackButtonC(View view)
    {
        Intent i = new Intent(CategoryProductsPage.this,MainMenu.class);
        startActivity(i);

    }

    }