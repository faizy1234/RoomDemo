package com.example.roomdbdemo.data.roomDB.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomdbdemo.data.model.CreateQuote;
import com.example.roomdbdemo.data.roomDB.entity.QuoteEntity;

import java.util.List;

@Dao
public interface QuoteDao {
    @Insert
    void createQuote(QuoteEntity createQuote);

    @Query("SELECT * FROM Quote_Table")
    LiveData<List<QuoteEntity>> getAllQuotes();
}
