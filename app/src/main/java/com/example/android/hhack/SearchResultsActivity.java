package com.example.android.hhack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SearchResultsActivity extends AppCompatActivity {

    private Person person = new Person();
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessagesDatabaseRefrence;
    private ChildEventListener mChildEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result_view);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMessagesDatabaseRefrence = mFirebaseDatabase.getReference().child("Person");
        person.setmName(getIntent().getStringExtra("name"));
        person.setmOrganizer(getIntent().getStringExtra("organization"));
        person.setId(getIntent().getStringExtra("id"));
        person.setmNationality(getIntent().getStringExtra("nationality"));


        ArrayList<Person> People = new ArrayList<Person>();

        People.add(person);

        ListView listView = (ListView) findViewById(R.id.list);

        PersonAdapter personAdapter = new PersonAdapter(getApplicationContext(),People);

        listView.setAdapter(personAdapter);
    }

}
