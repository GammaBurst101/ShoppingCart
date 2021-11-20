package com.prasoon.shoppingcartv2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //Using the Activity Result API
    //For that, we have to first register a launcher, which will launch the required activity while expecting a result
    //This launcher requires a contract, as well as a callback method to be called when the other activity finishes
    //We are using an anonymous class for implementing the callback method
    ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {//Anonymous class
                @Override
                public void onActivityResult(ActivityResult result) {//Callback method
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        Bundle extras = intent.getExtras();

                        //Log.d("DEBUG", "\nReturned :- \n 1. Item name = "+extras.getString(AddItem.ITEM_NAME_TAG)+ " \n 2. Quantity = "+extras.getInt(AddItem.QUANTITY_TAG));
                    }
                }
            });

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
        activityLauncher.launch(intent); //Using the recommended Activity Result API for launching another activity
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