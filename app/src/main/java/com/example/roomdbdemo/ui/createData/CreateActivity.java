package com.example.roomdbdemo.ui.createData;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.roomdbdemo.R;
import com.example.roomdbdemo.data.roomDB.entity.QuoteEntity;
import com.example.roomdbdemo.databinding.ActivityMain2Binding;
import com.example.roomdbdemo.ui.home.HomeActivity;

public class CreateActivity extends AppCompatActivity {

    private ActivityMain2Binding binding;
    private CreateQuoteViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewModel = new ViewModelProvider(this).get(CreateQuoteViewModel.class);

        binding.btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String quote = binding.quoteET.getText().toString();

                QuoteEntity quoteEntity = new QuoteEntity();
                quoteEntity.setQuote(quote);

                viewModel.insertData(quoteEntity);

            }
        });
        binding.btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateActivity.this , HomeActivity.class));
            }
        });
    }
}