package com.pregatit.rateit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;


import com.pregatit.rateit.db.DbHelper;
import com.pregatit.rateit.db.entities.Category;
import com.pregatit.rateit.db.entities.Product;
import com.pregatit.rateit.utils.AdapterRowItem;
import com.pregatit.rateit.utils.CustomAdapter;
import com.pregatit.rateit.utils.Singleton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductCatalogActivity extends AppCompatActivity {
    private Context context;
    private LinearLayout categoryList;
    private LayoutInflater factory;
    private Spinner categorySelection;
    private ArrayList<Category> categories;
    private ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_catalog);

        // initializare date
        this.context = getApplicationContext();

        Intent intent = getIntent();
        String newProductJson = intent.getStringExtra("newproduct");
        this.factory = getLayoutInflater();

        //ArrayList<Product> dummyData = Singleton.getProductFromJson(produsJson);
        String categoryJson = "[{'name':'lactate', 'image':'2131230817'},{'name':'mezeluri','image':'2131230817'},{'name':'vinuri','image':'2131230817'},{'name':'bere','image':'2131230817'}]";
        String productsJson= "[{'name':'Parmezan','rating':3.4,'update':null,'image':'2131230817'},{'name':'Cascaval','rating':3.4,'update':null,'image':'2131230817'}]";
        this.categories = Singleton.getArrayCategoryFromJson(categoryJson);
        this.categoryList = (LinearLayout) findViewById(R.id.scrollContainerProduct);
        this.categorySelection = (Spinner) findViewById(R.id.categories);

        String produsJson = null;
        if (null != newProductJson) {
            //daca am primit un produs afiseaza
            Log.d(Singleton.APP_NAME, newProductJson);
            produsJson = newProductJson;
        } else {
            //daca nu foloseste unul temporar
            produsJson= "{'name':'Parmezan','rating':3.4,'update':null,'image':'2131230817'}";
        }

        //prelucrare date

        clearContent();
        setContent(productsJson);
        clearCategorySelection();
        setCategorySelection();
    }

    private void setCategorySelection() {
        List<AdapterRowItem> rowitems = new ArrayList<AdapterRowItem>();
        for (int i=0;i<this.categories.size();i++)
        {
            AdapterRowItem item = new AdapterRowItem(this.categories.get(i).getName());
            rowitems.add(item);
        }
        CustomAdapter adapter = new CustomAdapter(this,android.R.layout.simple_spinner_item, rowitems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.categorySelection.setAdapter(adapter);
    }

    public void clearCategorySelection()
    {
        //this.categorySelection.setAdapter(null);
    }

    public void setContent(String ProductJson)
    {
        this.products = Singleton.getProductFromJson(ProductJson);
        for (int i=0;i<this.products.size();i++) {
            View view = getFragmentFromCategory(this.products.get(i));
            categoryList.addView(view);
        }
    }

    public View getFragmentFromCategory(Product product)
    {
        LinearLayout container = new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);

        // fragmentul pe care il folosim (reciclam)
        View view = this.factory.inflate(R.layout.fragment_category_partial,this.categoryList,false);
        //cautam in view-ul tocmai creat textul
        TextView categoryName = (TextView)view.findViewById(R.id.categoryNameFragment);
        //cautam in view-ul tocmai creat image-button
        ImageButton imgProductCatalog = (ImageButton)view.findViewById(R.id.imgProductCatalog);
        imgProductCatalog.setImageDrawable(getResources().getDrawable(product.getImage()));

        categoryName.setText(product.getName());
        container.addView(view);
        return container;
    }


    public void clearContent()
    {
        this.categoryList.removeAllViews();
    }

    public void onBackClick(View v){
        Intent i = new Intent(this, MainMenuActivity.class);
        startActivity(i);

        //TODO delete this is its not used
        //DbHelper db = new DbHelper(this);

    }

    public void onAddNewCategoryClick(View v){
        Intent i = new Intent(this, AddCategoryPage.class);
        startActivity(i);
    }
}