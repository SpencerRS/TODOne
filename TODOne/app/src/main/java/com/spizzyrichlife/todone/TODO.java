package com.spizzyrichlife.todone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class TODO extends AppCompatActivity {

    ListView mrTodoListview;
    Button mrAddItemButton;
    //TODO: remove/refactor mrTestList when user lists are functional
    ArrayList<String> mrTestList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
//        TODO: remove mrTestList when user lists are functional
        mrTestList.add("The first step");
        mrTestList.add("The second step");
        mrTestList.add("The third step");
        mrTodoListview = (ListView) findViewById(R.id.todoListView);
//        TODO: insert list of strings to display in ListView (Replace mrTestList with lists user will fill out)
        ArrayAdapter<String> mrArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mrTestList);
    }
//    TODO: implament list view with array adapter and notify dataset change (notify after a change has been made)
//    HOW TO: ListView, adapter and notify
//      mrMainListview = (ListView) findViewById(R.id.mainListView);
//      ArrayAdapter<String>  mrArrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,LIST);
//      mrMainListview.setAdapter(mrArrayAdapter);
//      mrArrayAdapter.notifyDataSetChanged();
//    TODO: Add onitemclicklistener to edit text in item
//    TODO: (Last): add check boxes in item view
//    TODO: (Last): make check box remove item when list is closed

//    TODO: add click listener to button
//    HOW TO: Set on click listener example
//    mrAddListButton = (Button) findViewById(R.id.addListButton);
//    mrAddListButton.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//
//        }
//    };
//    TODO: add pop-up to button to enter desired text
}
