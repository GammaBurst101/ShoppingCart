package com.prasoon.shoppingcartv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Starts the Add Item activity to let the user add any item to their shopping list
     * @param view
     */
    public void addItem(View view){
        Intent intent = new Intent(this, AddItem.class);
        startActivity(intent);
    }

    /**
     * Starts the Find Shop activity to help the user find a suitable shop near their location
     * @param view
     */
    public void findShop(View view){
        Intent intent = new Intent(this, FindShop.class);
        startActivity(intent);
    }
}