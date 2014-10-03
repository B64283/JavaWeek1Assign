/*

* Matthew Darke
* Java1
* term 1410
* 10/01/14

*/
package com.example.matthewdarke.javaweek1;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class MyActivity1 extends Activity {

    //set Member Variables
    EditText textView2, editText, editText2;
    ListView entryList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity1);

    textView2 = (EditText) findViewById(R.id.textView2);


      final Button addBTn = (Button)findViewById(R.id.buttonsub);
        addBTn.setOnClickListener(new View.OnClickListener() {

//onclick event
    @Override
    public void onClick(View view) {

  //add more stuff
    Toast.makeText(getApplicationContext(),"It can hear the click!", Toast.LENGTH_SHORT).show();
    }
});














    textView2.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {


        }

        @Override
        public void afterTextChanged(Editable editable) {

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
}
