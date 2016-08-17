package com.spizzyrichlife.todone;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

//        Requirements
//TODO   [ ]    Implement the prototype you created
//TODOne [X]    View a collection of to-do lists
//TODO   [ ]    View items on a to-do list
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
//    HOW TO: alertDialog (POP UP) example
//public void changeTheText(View v) {
//    AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//    final EditText input = new EditText(this);
//    input.setInputType(InputType.TYPE_CLASS_TEXT);
//
//    builder.setView(input);
//
//    builder.setMessage(R.string.change_the_text)
//            .setPositiveButton(R.string.change, new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialog, int id) {
//                    textView.setText(input.getText().toString());
//                }
//            })
//            .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialog, int id) {
//                    textView.setText(R.string.nevermind);
//                }
//            });



//   TODO: add an on item click listener
//    TODO: make on item click redirect to TODO activity with apporopriate info displayed
//    HOW TO: OnItemClickListener example
//      listView.setOnItemClickListener(new OnItemClickListener() {
//
//        public void onItemClick(AdapterView<?> adapterView, View v, int pos,
//        long arg3) {
//            Item i = (Item) adapterView.getItemAtPosition(pos);
//            ImageView iv = (ImageView) v.findViewById(R.id.imageView1);
//            iv.setImageResource(R.drawable.your_image);
//
//            mPlay = MediaPlayer.create( getApplicationContext(), sarkilar[pos] );
//            mPlay.start();
//        }
//    });
}
