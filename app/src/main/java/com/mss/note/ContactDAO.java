package com.mss.note;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactDAO {

    @Insert
    Void Insert(Contact contact);

    @Update
    Void Update(Contact contact);

    @Delete
    Void Delete(Contact contact);

    @Query("SELECT * from note_Database ORDER BY ID DESC")
    List<Contact> getAllData();

}
