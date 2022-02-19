package com.mss.note;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_Database")
public class Contact {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "user_title")
    String title;

    @ColumnInfo(name = "user_description")
    String description;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
