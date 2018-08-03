package com.example.android.hhack;

public class Person {


    private String mName, mNationality, mOrganizer, mLocation, id;
    private int pictureId;

    public Person(){}

    public Person(String mName) {
        this.mName = mName;
    }

    public Person(String mName, String mNationality) {
        this.mName = mName;
        this.mNationality = mNationality;
    }

    public Person(String mName, String mNationality, String mOrganizer) {
        this.mName = mName;
        this.mNationality = mNationality;
        this.mOrganizer = mOrganizer;
    }

    public Person(String mName, String mNationality, String mOrganizer, String mLocation) {
        this.mName = mName;
        this.mNationality = mNationality;
        this.mOrganizer = mOrganizer;
        this.mLocation = mLocation;
    }

    public Person(String mName, String mNationality, String mOrganizer, String mLocation, int pictureId) {
        this.mName = mName;
        this.mNationality = mNationality;
        this.mOrganizer = mOrganizer;
        this.mLocation = mLocation;
        this.pictureId = pictureId;
    }

    public Person(String mName, String mNationality, String mOrganizer, String mLocation, int pictureId, String id) {
        this.mName = mName;
        this.mNationality = mNationality;
        this.mOrganizer = mOrganizer;
        this.mLocation = mLocation;
        this.pictureId = pictureId;
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public String getmNationality() {
        return mNationality;
    }

    public String getmOrganizer() {
        return mOrganizer;
    }

    public String getmLocation() {
        return mLocation;
    }

    public int getPictureId() {
        return pictureId;
    }

    public String getId() {
        return id;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmNationality(String mNationality) {
        this.mNationality = mNationality;
    }

    public void setmOrganizer(String mOrganizer) {
        this.mOrganizer = mOrganizer;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public void setId(String id) {
        this.id = id;
    }
}
