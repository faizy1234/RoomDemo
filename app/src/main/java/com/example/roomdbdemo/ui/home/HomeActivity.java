package com.example.roomdbdemo.ui.home;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.roomdbdemo.R;
import com.example.roomdbdemo.data.roomDB.entity.QuoteEntity;
import com.example.roomdbdemo.databinding.ActivityHomeBinding;
import com.example.roomdbdemo.ui.createData.CreateQuoteViewModel;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private CreateQuoteViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewModel = new ViewModelProvider(this).get(CreateQuoteViewModel.class);

        viewModel.getAllQuotes.observe(this, new Observer<List<QuoteEntity>>() {
            @Override
            public void onChanged(List<QuoteEntity> quoteEntities) {

                QuoteAdapter adapter = new QuoteAdapter(HomeActivity.this , quoteEntities);
                binding.quoteRV.setAdapter(adapter);

            }
        });
    }
}