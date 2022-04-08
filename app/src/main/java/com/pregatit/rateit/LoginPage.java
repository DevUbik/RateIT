package com.pregatit.rateit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        //EditText email = (EditText) findViewById( R.id.email_adress_login);
    }

    public void OnLoginClick(View v)
    {
        //vom folosi un cont de test

        //username test pass 1234

        EditText emailEdit = (EditText) findViewById(R.id.email_adress_login);
        String email = emailEdit.getText().toString();

        EditText passwordEdit = (EditText) findViewById(R.id.password_text_login);
        String password = passwordEdit.getText().toString();

        if (getPasswordForAccount(email,password))
        {
            //TODO retine username si parola

            Intent i = new Intent(this, MainMenu.class);
            startActivity(i);
            //redirectiona catre main page
        } else {
            //ar trebui sa afisam o eroare
            Toast.makeText(v.getContext(),"Username or password incorrect",Toast.LENGTH_LONG).show();
        }

        //Toast.makeText(v.getContext(),"Login!",Toast.LENGTH_LONG).show();
    }

    public void OnCreateAccountClick(View v)
    {
        //Toast.makeText(v.getContext(),"Create Account!",Toast.LENGTH_LONG).show();

        //vreau sa imi deschizi activitatea din MainActivity
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    //primeste username (email) si parola si ar trebui sa intoarca true daca parola e buna pentru acel user
    public boolean getPasswordForAccount(String email, String pwd)
    {
        //apel catre server
        String fakeUser = "test";
        String fakePwd  = "1234";

        if (email.equals(fakeUser))
        {
            if (pwd.equals(fakePwd)){
                return true;
            }
        }
        return false;
    }
}