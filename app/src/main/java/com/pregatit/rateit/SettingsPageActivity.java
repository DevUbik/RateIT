package com.pregatit.rateit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        Switch soundSwitch = findViewById(R.id.soundSwitch);

        SharedPreferences shared =this.getSharedPreferences("RateIt",Context.MODE_PRIVATE);

        soundSwitch.setChecked(shared.getBoolean("value",true));
        soundSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = shared.edit();
                if(soundSwitch.isChecked())
                {
                    editor.putBoolean("value",true);
                    editor.apply();
                    soundSwitch.setChecked(true);
                }else {
                    editor.putBoolean("value",false);
                    editor.apply();
                    soundSwitch.setChecked(false);
                }
            }
        });

        TextView editProfile = (TextView) findViewById(R.id.edit_profileText);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Edit Profile",Toast.LENGTH_LONG).show();
            }
        });

        TextView connectedAccounts = (TextView) findViewById(R.id.connected_accountsText);
        connectedAccounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Connected Accounts",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void OnImageButtonClick(View v)
    {
        Intent i = new Intent(this, MainMenuActivity.class);
        startActivity(i);
    }


}