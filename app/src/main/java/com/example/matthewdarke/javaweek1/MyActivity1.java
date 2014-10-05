/*

* Matthew Darke
* Java1
* term 1410
* 10/01/14

*/
package com.example.matthewdarke.javaweek1;

import android.app.Activity;
import android.os.Bundle;
//import android.text.Editable;
//import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashSet;


public class MyActivity1 extends Activity {

    //set Member Variables
    public EditText textView2, itemsEntered, AveNumItems;
    public ListView entryList;
    public String entryString;
    public HashSet<String> userString = new HashSet<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity1);

        textView2 = (EditText) findViewById(R.id.textView2);


        final Button addBTn = (Button) findViewById(R.id.buttonsub);
        addBTn.setOnClickListener(new View.OnClickListener() {

            //onclick event
            @Override
            public void onClick(View view) {

                //add more stuff
                entryList = (ListView) findViewById(R.id.entryList);
                textView2 = (EditText) findViewById(R.id.textView2);
                entryString = textView2.getText().toString();

                //call addto method
               //addToListView();

                if (userString.contains(textView2.getText().toString())) {

                    Toast.makeText(getApplicationContext(), "You have entered a previous entry please enter somthing else!", Toast.LENGTH_LONG).show();

                } else if (!entryString.equals("")) {

                 //adds userString into HashSet
                    userString.add(entryString);

                } else {

                    Toast.makeText(getApplicationContext(), "Please enter some text", Toast.LENGTH_SHORT).show();


                }
//call to method for adding entry to the listView
                addToListView();

              //reset TextView
                textView2.setText("");
            }
                TextView itemsEntered = (TextView)findViewById(R.id.itemsEntered);






        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_activity1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }


//set up method
     private void addToListView() {

         // Constructing the data source
         ArrayList<String> arrayOfUsers = new ArrayList<String>(userString);
    // Create the adapter to convert the array to views
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayOfUsers);
//Attach the adapter to a ListView
         ListView listView = (ListView) findViewById(R.id.entryList);
         listView.setAdapter(adapter);


     }


//set up averageText method
//private aveText() {

//}





}