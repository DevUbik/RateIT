package com.pregatit.rateit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.pregatit.rateit.db.entities.Product;
import com.pregatit.rateit.utils.Singleton;

import java.io.FileNotFoundException;
import java.io.InputStream;

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

        //ImageView imageView = (ImageView) findViewById(R.id.productImage);
        //imageView.setImageDrawable(getResources().getDrawable(R.drawable.bakery));

        Log.d(Singleton.APP_NAME,Singleton.getTest());
    }

    public void onBackClick(View v) {
        Intent i = new Intent(this, MainMenuActivity.class);
        startActivity(i);
    }

    public void onPhoto(View v)
    {
        /*
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e)
        {

        }*/

        /*
        Intent intent = new Intent();
        intent.setAction(android.content.Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);*/
        Intent i = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i,REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.e(Singleton.APP_NAME,"we received something");

        if (resultCode == RESULT_OK) {
            try {
                Log.e(Singleton.APP_NAME,"we are processing");
                ImageView imageView = (ImageView) findViewById(R.id.productImage);
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                imageView.setImageBitmap(selectedImage);
                int width = selectedImage.getWidth();
                int height = selectedImage.getHeight();
                //int maxWidth = 500;
                //int maxHeight = 600;
                imageView.setLayoutParams(new LinearLayout.LayoutParams(300,600));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(this, "You haven't picked Image",Toast.LENGTH_LONG).show();
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