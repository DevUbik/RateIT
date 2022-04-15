package com.pregatit.rateit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class InsertProductActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_product_page);

        Spinner spinner = findViewById(R.id.spinner_Categories);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.food, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onBackClick(View v) {
        Intent i = new Intent(this, MainMenuActivity.class);
        startActivity(i);
    }

    public void onPhoto(View v)
    {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e)
        {

        }
    }

}