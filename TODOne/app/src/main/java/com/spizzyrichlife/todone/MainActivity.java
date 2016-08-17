package com.spizzyrichlife.todone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

//        Requirements
//TODO   [ ]    Implement the prototype you created
//TODO   [ ]    View a collection of to-do lists
//TODO   [ ]    View items on a to-do list
//TODO   [ ]    Allow the user to create a new to-do list
//TODO   [ ]    Add items to each to-do list
//TODO   [ ]    Display correctly in both landscape and portrait orientations
//        Bonus:
//TODO   [ ]    Show an error message if invalid input is given
//TODO   [ ]    Allow the user to check off and remove completed items
//TODO   [ ]    Add an item detail screen that allows the user to give an optional description for each item.

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//    TODO: add an on item click listener
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

//    TODO: add click listener to button
//    TODO: add pop-out window to enter title of list
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
//    TODO: make pop-out redirect to TODO activity
}
