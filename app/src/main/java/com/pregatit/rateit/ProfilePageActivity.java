package com.pregatit.rateit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ProfilePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        SharedPreferences preferences = this.getSharedPreferences("RateIt", Context.MODE_PRIVATE);
        String nickname = preferences.getString("nick","");
        String about = preferences.getString("about","");

        EditText nickText = (EditText) findViewById(R.id.nicknameText);
        EditText aboutText = (EditText) findViewById(R.id.about_meText);
        ImageView profile = (ImageView) findViewById(R.id.imageViewProfile);
        nickText.setText(nickname);
        aboutText.setText(about);


    }
    public void OnImageButtonClick(View v)
    {
        Intent i = new Intent(this, SettingsPageActivity.class);
        startActivity(i);
    }

    public void OnProfileImageClick(View v)
    {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            try {
                ImageView imageProfile = (ImageView) findViewById(R.id.imageViewProfile);
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                imageProfile.setImageBitmap(selectedImage);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(this, "You haven't picked an image",Toast.LENGTH_LONG).show();
        }
    }

    public void OnSaveButtonClick(View v)
    {
        EditText nickText = (EditText) findViewById(R.id.nicknameText);
        EditText aboutText = (EditText) findViewById(R.id.about_meText);
        ImageView profile = (ImageView) findViewById(R.id.imageViewProfile);
        Button save = (Button) findViewById(R.id.saveButton);

        String nick = nickText.getText().toString();
        String about = aboutText.getText().toString();
        Bitmap image = BitmapFactory.decodeFile(String.valueOf(profile));

        SharedPreferences preferences = this.getSharedPreferences("RateIt", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        if(!nick.equals("") || !about.equals("") || image != null)
        {
            editor.putString("nick",nick);
            editor.putString("about",about);
            editor.putString("image", String.valueOf(image));
            editor.apply();
        }

        Intent i = new Intent(this, SettingsPageActivity.class);
        startActivity(i);
    }
}