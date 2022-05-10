package com.pregatit.rateit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.pregatit.rateit.db.entities.Product;
import com.pregatit.rateit.utils.Singleton;

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

        Log.d(Singleton.APP_NAME,Singleton.getTest());
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

    public void onSaveNewProduct(View v)
    {
        Product newProduct = new Product();
        TextView name = (TextView) findViewById(R.id.textInputEditText_nameOfTheProduct);
        newProduct.setName(name.getText().toString());
        RatingBar overalRating = (RatingBar) findViewById(R.id.ratingBar_overall);
        newProduct.setRating(overalRating.getRating());

        newProduct.setImage(2131230817);

        String dummyProduct = Singleton.getJsonFromProduct(newProduct);
        Intent i = new Intent(this, ProductCatalogActivity.class);
        i.putExtra("newproduct",dummyProduct);
        startActivity(i);
    }

}