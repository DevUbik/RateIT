package com.pregatit.rateit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class LoginPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        //incarcam preferintele (cookide-ul)
        SharedPreferences shared = this.getSharedPreferences("RateIt", Context.MODE_PRIVATE);

        //incercam sa aducem valorile pentru email si password
        String email = shared.getString("email","");
        String password = shared.getString("password","");
        // pune in shared preferences o cheie numita Utilizator cu valoarea "";

        //afisam rezultatul
        EditText emailEdit = (EditText) findViewById(R.id.email_adress_login);
        EditText passwordEdit = (EditText) findViewById(R.id.password_text_login);

        emailEdit.setText(email);
        passwordEdit.setText(password);

        //TODO autentificare prin amprenta.
        //TODO add the same behaviour for remember me.
    }

    public void OnLoginClick(View v)
    {
        //vom folosi un cont de test
        //username test pass 1234

        EditText emailEdit = (EditText) findViewById(R.id.email_adress_login);
        String email = emailEdit.getText().toString();

        EditText passwordEdit = (EditText) findViewById(R.id.password_text_login);
        String password = passwordEdit.getText().toString();

        //daca parola e corecta
        if (getPasswordForAccount(email,password))
        {
            //verificam daca e bifat remember me

            //daca da

            SharedPreferences shared = this.getSharedPreferences("RateIt", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = shared.edit();
            Switch remember = (Switch) findViewById(R.id.remeber_me_login);
            if (remember.isChecked()){
                //salveza datele
                editor.putString("email",email);
                editor.putString("password",password);
                editor.apply();
            } else {
                //sterge datele
                editor.putString("email","");
                editor.putString("password","");
                editor.apply();
            }

            //daca nu o sa vedem.

            Intent i = new Intent(this, MainMenuActivity.class);
            startActivity(i);
            //redirectionaza-ma catre main page
        } else { // daca nu
            //ar trebui sa afisam o eroare
            Toast.makeText(v.getContext(),"Username or password incorrect",Toast.LENGTH_LONG).show();
        }
    }

    public void OnCreateAccountClick(View v)
    {
        //Toast.makeText(v.getContext(),"Create Account!",Toast.LENGTH_LONG).show();

        //vreau sa imi deschizi activitatea din MainActivity
        Intent i = new Intent(this, CreateAccountActivity.class);
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