package com.mss.note;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class}, version = 1)
public abstract class ContactDB extends RoomDatabase {

    public abstract ContactDAO contactDAO();

    public static ContactDB contactDB = null;

    public static ContactDB getContactDB(Context context){

        if(contactDB == null){
            contactDB = Room.databaseBuilder(
                    context,
                    ContactDB.class,
                    "Contact_Database"
            ).allowMainThreadQueries().build();
        }

        return contactDB;

    }
}
