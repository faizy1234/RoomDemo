package com.example.roomdbdemo.data.roomDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdbdemo.data.roomDB.dao.QuoteDao;
import com.example.roomdbdemo.data.roomDB.entity.QuoteEntity;

@Database(entities = {QuoteEntity.class} , version = 1 , exportSchema = false )
public abstract class QuotesDataBase extends RoomDatabase {

    public static QuotesDataBase INSTANCE;
    public abstract QuoteDao QuoteDao();
    public static final String DB_NAME = "quoteDb";

    public static QuotesDataBase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context , QuotesDataBase.class , DB_NAME).build();
        }
        return INSTANCE;
    }
}
