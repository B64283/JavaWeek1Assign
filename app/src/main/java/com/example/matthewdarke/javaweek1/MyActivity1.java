/*
* ************************
*
* Matthew Darke
* Java1 week 2
* term 1410
מַתִּתְיָהוּ
*
*************************
*/
package com.example.matthewdarke.javaweek1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
//import android.text.Editable;
//import android.text.TextWatcher;
import android.preference.DialogPreference;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
    public ListView listView;
    public ArrayAdapter adapter;
    final Context contThis = (this);
    public AlertDialog.Builder alertDialog;

    //wondering if I could use an ordered set???
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

                //checks to see if the list already CONTAINS whats in the edit feild
                if (userString.contains(textView2.getText().toString())) {

                    Toast.makeText(getApplicationContext(), R.string.same_text, Toast.LENGTH_LONG).show();

                //if not emty then add to Hashset for the listview list
                } else if (!entryString.equals("")) {

                    //adds userString into HashSet
                    userString.add(entryString);

                } else {

                    Toast.makeText(getApplicationContext(), R.string.some_text, Toast.LENGTH_SHORT).show();


                }

                //gets total entries int in set and puts it to a string and sets it to the textView
                TextView itemsEntered = (TextView) findViewById(R.id.itemsEntered);
                int numOfEntries = userString.size();
                String entrySize = String.valueOf(numOfEntries);
                itemsEntered.setText( entrySize);


                //call to method for adding entry to the listView
                //
                aveTextLength();
                addToListView();

                //reset TextView
                textView2.setText("");
            }

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
        final ArrayList<String> arrayOfUsers = new ArrayList<String>(userString);

// Create the adapter to convert the array to views
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayOfUsers);

//Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.entryList);
        listView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View viewItemClicked, final int position, long id) {


                TextView textView = (TextView)viewItemClicked;
                String message = "You clicked on position"+ position + "which is "+ entryList.getItemAtPosition(position);

                //add alert for user
                Toast.makeText(MyActivity1.this, message, Toast.LENGTH_LONG).show();

// add alert
                alertDialog = new AlertDialog.Builder(contThis);
                alertDialog.setTitle(message);
                alertDialog.setMessage("Click Remove to delete. Click OK to cancel.");

                alertDialog.setPositiveButton("Remove", new DialogInterface.OnClickListener() {
                    //adapter.remove(adapter);

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ListView listView = (ListView) findViewById(R.id.entryList);

                      userString.remove(position);






                        Toast.makeText(getApplicationContext(), "You have pressed yes!", Toast.LENGTH_SHORT).show();


                    }


                });

                alertDialog.setNegativeButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "You have pressed no", Toast.LENGTH_SHORT).show();

                    }

                });

                alertDialog.show();



            }
        });


    }

    /*public void showAlertDialog() {


        AlertDialog.Builder  alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Confirm");
        alertDialog.setMessage("Click Remove to delete. Click OK to cancel.");

        alertDialog.setPositiveButton("Remove", new DialogInterface.OnClickListener() {
            //adapter.remove(adapter);

            @Override
            public void onClick(DialogInterface dialog, int which) {

                //ListView listView = (ListView) findViewById(R.id.entryList);


                adapter.remove(adapter);

                //removeItem(userString);

               listView.setAdapter(adapter);
                //adapter.remove(adapter);

                Toast.makeText(getApplicationContext(), "You have pressed yes!", Toast.LENGTH_SHORT).show();


            }


        });

        alertDialog.setNegativeButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You have pressed no", Toast.LENGTH_SHORT).show();

            }

        });

        alertDialog.show();

    }*/


            //set up averageText method
            private void aveTextLength() {

                double size = 0;

                //create for loop through every element in array
                for (int i = 0; i < userString.size(); i++) {
                    String currentEntries = String.valueOf(userString);
                    size += currentEntries.length();

                    size = size / userString.size();
                }


                TextView AveNumItems = (TextView) findViewById(R.id.AveNumItems);

                AveNumItems.setText(": " + size);

            }



        }