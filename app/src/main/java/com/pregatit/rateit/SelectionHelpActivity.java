package com.pregatit.rateit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectionHelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajutor_selectie);
    }

    public void OnSkipClick(View v)
    {
        Intent i=new Intent(this, MainMenuActivity.class);
        startActivity(i);
    }
    public void OnBackClick(View v)
    {
        Intent i=new Intent(this, CreateAccountActivity.class);
        startActivity(i);
    }
}