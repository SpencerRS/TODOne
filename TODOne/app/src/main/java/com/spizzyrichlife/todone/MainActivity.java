package com.spizzyrichlife.todone;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

//        Requirements
//TODO   [V]    Implement the prototype you created
//TODOne [X]    View a collection of to-do lists
//TODOne [X]    View items on a to-do list
//TODOne [X]    Allow the user to create a new to-do list
//TODO   [ ]    Add items to each to-do list
//TODO   [V]    Display correctly in both landscape and portrait orientations
//        Bonus:
//TODO   [ ]    Show an error message if invalid input is given
//TODO   [ ]    Allow the user to check off and remove completed items
//TODO   [ ]    Add an item detail screen that allows the user to give an optional description for each item.

public class MainActivity extends AppCompatActivity {
    ListView mrMainListView;
    ArrayAdapter<String> mrArrayAdapter;
    Button mrAddListButton;
    ArrayList<String> mrUserTitlesList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TODO: remove when user lists are functional?
        mrUserTitlesList.add("Requirements for TODO List app");


//    TODOne: implament list view with array adapter and notify dataset change (notify after a change has been made)
        mrMainListView = (ListView) findViewById(R.id.mainListView);
        mrArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mrUserTitlesList);
        mrMainListView.setAdapter(mrArrayAdapter);

//        TODO: add an on item click listener
        mrMainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, TODO.class);
                intent.putExtra("TITLE", (mrUserTitlesList.get(position)));
                startActivity(intent);
            }
        });

//    TODOne: add click listener to button
        mrAddListButton = (Button) findViewById(R.id.addListButton);
        mrAddListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTitlePopUp();
            }
        });
    }


    public void setTitlePopUp() {
//      TODOne: add pop-up window to enter title of list
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        builder.setMessage("Name your new List").setPositiveButton("Set title", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialogue, int id) {
                mrUserTitlesList.add(input.getText().toString());
                mrArrayAdapter.notifyDataSetChanged();
//                TODO: make pop-out redirect to TODO activity?
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialogue, int id) {
//                TODOne: Ask how to cancel an alert dialogue; add it here
            }
        });
        Dialog dialog = builder.create();
        dialog.show();
    }

//    TODO: make on item click redirect to TODO activity with apporopriate info displayed
}
