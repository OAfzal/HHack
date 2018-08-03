package com.example.android.hhack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegisterPerson extends AppCompatActivity {

    private Person missing_person = new Person();
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessagesDatabaseRefrence;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.register_missing_person);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMessagesDatabaseRefrence = mFirebaseDatabase.getReference("missing_person");
        final Button register = (Button) findViewById(R.id.register_button);

        final Spinner spinner = (Spinner) findViewById(R.id.register_nationality);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.countries_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        final EditText id = (EditText) findViewById(R.id.register_id);

        id.addTextChangedListener(new TextWatcher() {

            @Override

            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override

            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.toString().trim().length() > 0) {
                    register.setEnabled(true);

                } else {

                    register.setEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        final EditText name = (EditText) findViewById(R.id.register_name);

        name.addTextChangedListener(new TextWatcher() {

            @Override

            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override

            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.toString().trim().length() > 0) {
                    register.setEnabled(true);

                } else {

                    register.setEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });


        final EditText organizer = (EditText) findViewById(R.id.register_organization);

        organizer.addTextChangedListener(new TextWatcher() {

            @Override

            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override

            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.toString().trim().length() > 0) {
                    register.setEnabled(true);

                } else {

                    register.setEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        spinner.getSelectedItem().toString();

        /**Filling up the Person Object **/

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMessagesDatabaseRefrence.push().setValue(new Person(name.getText().toString(),spinner.getSelectedItem().toString(),organizer.getText().toString(),id.getText().toString()));
                Toast toast = Toast.makeText(getApplicationContext(),"Added Successfully",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
