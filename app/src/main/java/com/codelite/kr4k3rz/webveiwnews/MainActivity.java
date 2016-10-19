package com.codelite.kr4k3rz.webveiwnews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] newspapers = {"onlinekhabar", "thehimalayantimes", "ekantipur", "setopati", "ratopati"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        /*declare ArrayAdapter used to set the Newspaper ArrayList on ListView*/
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, newspapers);
        listView.setAdapter(arrayAdapter);

        /*a callback when item is clicked*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("NEWSPAPER", newspapers[i]); //to send the newspaper eg. setopati to second activity
                startActivity(intent);  //starts the movement from MainActivity to SecondActivity
            }
        });
    }
}
