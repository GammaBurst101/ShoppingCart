package com.prasoon.shoppingcartv2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AddItem extends AppCompatActivity {

    private EditText nameField, quantityField;
    public static String ITEM_NAME_TAG = "item name", QUANTITY_TAG = "item quantity"; //These tags are to be used both here and in MainActivity.java

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        //Assigning the appropriate views to each instance variable
        nameField = findViewById(R.id.name_et);
        quantityField = findViewById(R.id.quantity_et);
    }

    public void addItem(View view){
        //Get the item name and the quantity to be added to the list
        String item = "", quantity = ""; //Default value

        //Try getting the name and quantity. If unsuccessful, print the error stack trace
        try {
            item = nameField.getText().toString();
            quantity = quantityField.getText().toString();
        } catch (Exception e){ //Should use a more specific exception, but I'm too lazy :P
            e.printStackTrace();
        }

        //Intent to store everything which has to be sent back
        Intent resultIntent = new Intent();

        //Bundling all the data inside 'extras'
        Bundle extras = new Bundle();
        extras.putString(ITEM_NAME_TAG, item);
        extras.putString(QUANTITY_TAG, quantity);

        //Returning back to the main activity
        resultIntent.putExtras(extras);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}