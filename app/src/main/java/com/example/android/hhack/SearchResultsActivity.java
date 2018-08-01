package com.example.android.hhack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result_view);


        ArrayList<Person> People = new ArrayList<Person>();


        ListView listView = (ListView) findViewById(R.id.list);

        PersonAdapter personAdapter = new PersonAdapter(getApplicationContext(),People);

        listView.setAdapter(personAdapter);
    }
}
