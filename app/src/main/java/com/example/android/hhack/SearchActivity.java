package com.example.android.hhack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

 class SearchActivity extends AppCompatActivity {

    private EditText mSearchField;
    private ImageButton mSearchBtn;

    private RecyclerView mResultList;

    private DatabaseReference mUserDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.search_layout);

        mUserDatabase = FirebaseDatabase.getInstance().getReference("missing_person");


        mSearchField = (EditText) findViewById(R.id.search_field);
        mSearchBtn = (ImageButton) findViewById(R.id.search_btn);

        mResultList = (RecyclerView) findViewById(R.id.result_list);
        mResultList.setHasFixedSize(true);
        mResultList.setLayoutManager(new LinearLayoutManager(this));

        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String searchText = mSearchField.getText().toString();

                firebaseUserSearch(searchText);

            }
        });

    }

    private void firebaseUserSearch(String searchText) {

        Toast.makeText(SearchActivity.this, "Started Search", Toast.LENGTH_LONG).show();

        Query firebaseSearchQuery = mUserDatabase.orderByChild("name").startAt(searchText).endAt(searchText + "\uf8ff");

        FirebaseRecyclerAdapter<Person, UsersViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Person, UsersViewHolder>(

                Person.class,
                R.layout.list_item,
                UsersViewHolder.class,
                firebaseSearchQuery

        ) {
            @Override
            protected void populateViewHolder(UsersViewHolder viewHolder, Person model, int position) {


                viewHolder.setDetails(model.getmName(), model.getmNationality(), model.getmLocation(),model.getmOrganizer());

            }
        };

        mResultList.setAdapter(firebaseRecyclerAdapter);


    }
}

// View Holder Class

class UsersViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public UsersViewHolder(View itemView) {
        super(itemView);

        mView = itemView;

    }

    public void setDetails(String userName, String userNationality, String userOrganization, String userLocation){

        TextView user_name = (TextView) mView.findViewById(R.id.name);
        TextView user_nationality = (TextView) mView.findViewById(R.id.nationality);
        TextView user_organization = (TextView) mView.findViewById(R.id.organization);
        TextView user_location = (TextView) mView.findViewById(R.id.location);

        user_name.setText(userName);
        user_nationality.setText(userNationality);
        user_location.setText(userLocation);
        user_organization.setText(userOrganization);
    }




}


