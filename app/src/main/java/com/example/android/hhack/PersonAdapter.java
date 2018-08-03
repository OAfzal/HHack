package com.example.android.hhack;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends ArrayAdapter<Person> {

    public PersonAdapter(@NonNull Context context, ArrayList<Person> resource) {
        super(context,0,resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        //Setting up the image of a person

        Person currentPerson= getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        imageView.setImageResource(currentPerson.getPictureId());


        //Setting up the person's name

        TextView personName = (TextView) listItemView.findViewById(R.id.name);

        personName.setText(currentPerson.getmName());

        //Setting up the person's nationality

        TextView personNationaolity = (TextView) listItemView.findViewById(R.id.nationality);

        personNationaolity.setText(currentPerson.getmNationality());


        //Setting up person's location

        TextView personLocation = (TextView) listItemView.findViewById(R.id.location);

        personLocation.setText(currentPerson.getmLocation());

        return listItemView;
    }
}
