package com.example.roomdbdemo.ui.createData;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomdbdemo.data.repo.QuoteRepo;
import com.example.roomdbdemo.data.roomDB.entity.QuoteEntity;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreateQuoteViewModel extends ViewModel {

    private QuoteRepo repo = new QuoteRepo();
    public LiveData<List<QuoteEntity>> getAllQuotes = repo.createQuote;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public void insertData(QuoteEntity quoteEntity){
        executorService.execute(() -> repo.createQuote(quoteEntity));
    }
}
