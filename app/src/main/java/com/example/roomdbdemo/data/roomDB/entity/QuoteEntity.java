package com.example.roomdbdemo.data.roomDB.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Quote_Table")
public class QuoteEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "quote")
    private String quote;

    @ColumnInfo(name = "description")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
