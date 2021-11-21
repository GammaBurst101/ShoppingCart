package com.prasoon.shoppingcartv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class FindShop extends AppCompatActivity {

    private EditText location, shopType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_shop);

        //Assigning the appropriate views to their respective instance variables
        location = findViewById(R.id.location_et);
        shopType = findViewById(R.id.shopType_et);
    }

    /**
     * Opens the phone's default maps app, to search for the nearest required shop
     *
     */
    public void openMaps(View view){
        String userLoc = "", shop = "";
        try{
            userLoc = location.getText().toString();
            shop = shopType.getText().toString();
        } catch (Exception e){
            e.printStackTrace();
        }

        String loc = shop + " " + userLoc;

        //Parse the location and create an intent
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        //Find an activity to hand the intent and start the activity
        try{
            startActivity(intent);
        } catch (ActivityNotFoundException e){
            Log.d("DEBUG_TAG", "No activity found for opening locations");
        }
    }
}