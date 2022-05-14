package com.pregatit.rateit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CreateAccountActivity extends AppCompatActivity {

    String stringP, stringPT, stringB;
    Boolean sender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sender = getIntent().getExtras().getBoolean("Sender");
        if(sender)
        {
            TextView repeatPass = (TextView) findViewById(R.id.myrepeatpassword);
            TextView repeatPassText = (TextView) findViewById(R.id.editTextTextPassword2);
            Button save = (Button) findViewById(R.id.createaccount);

            stringP = getIntent().getExtras().getString("ValueP");
            stringPT = getIntent().getExtras().getString("ValuePT");
            stringB = getIntent().getExtras().getString("ValueB");
            repeatPass.setText(stringP);
            repeatPassText.setHint(stringPT);
            save.setText(stringB);
        }
    }

    public void OnBackClick(View v)
    {
        Intent iLogin = new Intent(this, LoginPageActivity.class);
        Intent iSettings = new Intent(this, SettingsPageActivity.class);
        sender = getIntent().getExtras().getBoolean("Sender");
        if(sender)
            startActivity(iSettings);
        else
            startActivity(iLogin);
    }

}