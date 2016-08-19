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
import android.widget.TextView;

import java.util.ArrayList;

public class TODO extends AppCompatActivity {
    TextView titleTV;
    ListView mrTodoListview;
    ArrayAdapter<String> mrArrayAdapter;
    Button mrAddItemButton;
    //TODOne: refactor mrTestList when user lists are functional
    ArrayList<String> mrItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        titleTV = (TextView) findViewById(R.id.todoTitle);
//        TODOne: remove mrTestList when user lists are functional
//        mrItemList.add("The first step");
//        mrItemList.add("The second step");
//        mrItemList.add("The third step");

//    TODOne: implament list view with array adapter and notify dataset change (notify after a change has been made)
        mrTodoListview = (ListView) findViewById(R.id.todoListView);
        mrArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mrItemList);
        mrTodoListview.setAdapter(mrArrayAdapter);

//    TODO: Add onitemclicklistener to edit text in item
        mrTodoListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            TODO: set text for item at position
            }
        });

//          TODOne: Get intent from MainActivity
        Intent intent = getIntent();
        String title = intent.getStringExtra("TITLE");
        titleTV.setText(title);

        if (title.equals("Requirements")) {
            mrItemList.add("Implement the prototype you created");
            mrItemList.add("View a collection of to-do lists");
            mrItemList.add("View items on a to-do list");
            mrItemList.add("Allow the user to create a new to-do list");
            mrItemList.add("Add items to each to-do list");
            mrItemList.add("Display correctly in both landscape and portrait orientations");
        }
        if (title.equals("Hide These")) {
//            TextView tint = (TextView) findViewById(R.id.whereTheColorsWillChange);
//            tint.setBackground(#05cfc5);
            mrItemList.add("These are hidden strings");
            mrItemList.add("But if you looked at the code, you probably saw them");
            mrItemList.add("I wanted to see if I could make the colors change");
            mrItemList.add("Do the colors look any different?");
            mrItemList.add("No they don't, it didn't like the pound-color-code");
        }

        mrTodoListview = (ListView) findViewById(R.id.todoListView);

        ArrayAdapter<String> mrArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mrItemList);

        //    TODOne: add click listener to button
//        TODO: make TODO remember specific lists for each title
        mrAddItemButton = (Button) findViewById(R.id.addItemButton);
        mrAddItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setItemPopUp();
            }
        });
    }

    //    TODOne: add pop-up to button to enter desired text
    public void setItemPopUp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        builder.setMessage("Add an item to your TODO list").setPositiveButton("Set item", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialogue, int id) {
                mrItemList.add(input.getText().toString());
                mrArrayAdapter.notifyDataSetChanged();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialogue, int id) {

            }
        });
        Dialog dialog = builder.create();
        dialog.show();
    }

//    TODO: add text edit popup
//public void editTextPopUp(final int position) {
//    AlertDialog.Builder builder = new AlertDialog.Builder(this);
//    final EditText input = new EditText(this);
//    input.setInputType(InputType.TYPE_CLASS_TEXT);
//    builder.setView(input);
//    builder.setMessage("Rename your item").setPositiveButton("Set item", new DialogInterface.OnClickListener() {
//
//        public void onClick(DialogInterface dialogue, int id) {
//            mrItemList[position].setText(input);
//            mrArrayAdapter.notifyDataSetChanged();
//        }
//    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//
//        public void onClick(DialogInterface dialogue, int id) {
//
//        }
//    });
//    Dialog dialog = builder.create();
//    dialog.show();
//}


//    TODO: (Last): add check boxes in item view
//    TODOne: (Last): make check box remove item when list is closed (not in scope)
}
