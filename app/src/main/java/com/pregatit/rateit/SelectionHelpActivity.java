package com.pregatit.rateit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;


import com.pregatit.rateit.db.DbHelper;
import com.pregatit.rateit.db.entities.Category;
import com.pregatit.rateit.db.entities.Product;
import com.pregatit.rateit.utils.Singleton;

public class SelectionHelpActivity extends AppCompatActivity {
    private Context context;
    private ScrollView categoryList;
    private LayoutInflater factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_help);

        this.context = getApplicationContext();

        /*
        {'name':'Parmezan','rating':3.4,'update':null}
         */

        /*
        [{'name':'lactate'},{'name':'mezel'}]
         */

        String produsJson = "{'name':'Parmezan','rating':3.4,'update':null}";

        //design patters

        //Product dummyData = Singleton.getProductFromJson(produsJson);

        this.factory = LayoutInflater.from(context);

        this.categoryList = (ScrollView) findViewById(R.id.categoryList);
        clearContent();
        //setContent();
    }

    public void setContent()
    {
        //String categoryJson = "[{'name':'lactate'}{'name':'mezeluri'}]";
        String produsJson = "{'name':'Parmezan','rating':3.4,'update':null}";

        Category dummyCategory = Singleton.getCategoryFromJson(produsJson);


        View view = getFragmentFromCategory(dummyCategory);

        categoryList.addView(view);
    }

    public View getFragmentFromCategory(Category category)
    {
        // fragmentul pe care il folosim (reciclam)
        View view = this.factory.inflate(R.layout.fragment_category_partial,categoryList,false);
        //cautam in view-ul tocmai creat textul
        TextView categoryName = (TextView)view.findViewById(R.id.categoryNameFragment);

        categoryName.setText(category.getName());
        return view;
    }


    public void clearContent()
    {
        this.categoryList.removeAllViews();
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