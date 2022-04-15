package com.pregatit.rateit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CategoryProductsActivity extends AppCompatActivity {
    TextView username = (TextView) findViewById(R.id.username);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_products_page);
        username.setText("test");
    }

    public void onClickBackButtonC(View view) {
        Intent i = new Intent(CategoryProductsActivity.this, MainMenuActivity.class);
        startActivity(i);

    }

}