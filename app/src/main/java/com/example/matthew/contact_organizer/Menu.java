package com.example.matthew.contact_organizer;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Matthew on 1/9/2016.
 * menu for all the different apps
 *
 * extends a list activity which extends activity
 *
 * //also need to make sure this menu is set up in the manifest
 * as well as called from the splash screen
 */
public class Menu extends ListActivity{

    String classes[] = {"MainActivity", "TextPlay", "Email",
            "Camera", "example4" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //kind of like a list view
        //for most of these, would setcontentview to a layout
        //use setlistadapter instead which takes an array/list adapter
        //first param is this
        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
    }

    /*
    *
    *input
    * l: what list view was clicked
    * v: what view was clicked,
    * position: (coencides with string array)
    * id:
    * */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //the class that was clicked
        String classAtPos = classes[position];
        //starting an activity
        //creates a class variable for the path name of the input
        Class ourClass = null;
        try {
            //wont work if the class from the string is not created
            ourClass = Class.forName("com.example.matthew.contact_organizer."+classAtPos);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //using class variable instead of action name from manifest
        //this means that the name doesnt really need to be defined
        //in the manifest file
        Intent ourIntent = new Intent(Menu.this, ourClass);
        startActivity(ourIntent);
    }
}
