package com.pregatit.rateit;

import androidx.appcompat.app.AppCompatActivity;

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

        //polimorfism
        int works = 5;

        //
        Button login = (Button) findViewById( R.id.login );

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(view.getContext(),"Merge!",Toast.LENGTH_LONG).show();
            }
        });

        EditText email = (EditText) findViewById( R.id.email_adress_login);
    }
}