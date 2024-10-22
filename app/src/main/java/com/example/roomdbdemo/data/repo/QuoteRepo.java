package com.example.roomdbdemo.data.repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.roomdbdemo.data.roomDB.dao.QuoteDao;
import com.example.roomdbdemo.data.model.CreateQuote;
import com.example.roomdbdemo.data.roomDB.QuotesDataBase;
import com.example.roomdbdemo.data.roomDB.entity.QuoteEntity;

import java.util.List;

public class QuoteRepo {

    private QuoteDao dao;
    public LiveData<List<QuoteEntity>> createQuote;

    public QuoteRepo(){
        QuotesDataBase db = QuotesDataBase.INSTANCE;
        dao = db.QuoteDao();
        createQuote  = dao.getAllQuotes();
    }
    public void createQuote(QuoteEntity createQuoteData){
        dao.createQuote(createQuoteData);
    }

}
