package com.pregatit.rateit;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;

import java.util.List;

public class SettingsPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        Switch soundSwitch = (Switch) findViewById(R.id.soundSwitch);
        SharedPreferences shared = this.getSharedPreferences("RateIt", Context.MODE_PRIVATE);
        soundSwitch.setChecked(shared.getBoolean("valueS",true));

        Switch locationSwitch = (Switch) findViewById(R.id.locationSwitch);
        SharedPreferences preferences = this.getSharedPreferences("RateIt",Context.MODE_PRIVATE);
        locationSwitch.setChecked(preferences.getBoolean("valueL",false));

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

        //dropdown pentru language
        String[] lg = getResources().getStringArray(R.array.languages);
        ArrayAdapter<String> arrayAdapterLg = new ArrayAdapter<String>(this,R.layout.dropdown_language,lg);
        AutoCompleteTextView autoCompleteTextViewLg = findViewById(R.id.autoCompleteTextLanguage);
        autoCompleteTextViewLg.setAdapter(arrayAdapterLg);

        //dropdown pentru theme
        String[] th = getResources().getStringArray(R.array.themes);
        ArrayAdapter<String> arrayAdapterTh = new ArrayAdapter<String>(this,R.layout.dropdown_theme,th);
        AutoCompleteTextView autoCompleteTextViewTh = findViewById(R.id.autoCompleteTextTheme);
        autoCompleteTextViewTh.setAdapter(arrayAdapterTh);

    }

    public void OnImageButtonClick(View v)
    {
        Intent i = new Intent(this, MainMenuActivity.class);
        startActivity(i);
    }

    public void OnSoundSwitchClick(View v)
    {
        Switch soundSwitch = (Switch) findViewById(R.id.soundSwitch);

        SharedPreferences shared = this.getSharedPreferences("RateIt", Context.MODE_PRIVATE);

        //soundSwitch.setChecked(shared.getBoolean("valueS",true));

        SharedPreferences.Editor editor = shared.edit();
        editor.putBoolean("valueS",soundSwitch.isChecked());
        editor.apply();
    }

    public void getLocation()
    {
        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(SettingsPageActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(SettingsPageActivity.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }

        };

        TedPermission.create()
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
                .check();

    }

    public void OnLocationSwitchClick(View v)
    {
        Switch location = (Switch) findViewById(R.id.locationSwitch);
        SharedPreferences shared = this.getSharedPreferences("RateIt", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        location.setChecked(shared.getBoolean("valueL",true));
        getLocation();
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ActivityCompat.checkSelfPermission(SettingsPageActivity.this,Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED)
                {
                    editor.putBoolean("valueL",true);
                    editor.apply();
                    location.setChecked(true);
                }
                else
                {
                    ActivityCompat.requestPermissions(SettingsPageActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 23);
                    editor.putBoolean("valueL",false);
                    editor.apply();
                    location.setChecked(false);
                }
            }
        });

    }


}