package com.example.android.hhack;

public class Person {


    private String mName, mNationality, mOrganizer, mLocation;
    private int pictureId;

    public Person(String mLocation, int pictureId) {
        this.mLocation = mLocation;
        this.pictureId = pictureId;
    }

    public Person(String mOrganizer, String mLocation, int pictureId) {
        this.mOrganizer = mOrganizer;
        this.mLocation = mLocation;
        this.pictureId = pictureId;
    }

    public Person(String mNationality, String mOrganizer, String mLocation, int pictureId) {
        this.mNationality = mNationality;
        this.mOrganizer = mOrganizer;
        this.mLocation = mLocation;
        this.pictureId = pictureId;
    }

    public Person(String mName, String mNationality, String mOrganizer, String mLocation, int pictureId) {
        this.mName = mName;
        this.mNationality = mNationality;
        this.mOrganizer = mOrganizer;
        this.mLocation = mLocation;
        this.pictureId = pictureId;
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

    public int getThumbnail() {
        return pictureId;
    }

    public String getmLocation() {
        return mLocation;
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
}
