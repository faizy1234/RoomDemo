package com.example.roomdbdemo.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdbdemo.R;
import com.example.roomdbdemo.data.roomDB.entity.QuoteEntity;

import java.util.List;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.MyViewHolder> {

    private List<QuoteEntity> quotes;
    private Context context;

    QuoteAdapter(Context context , List<QuoteEntity> quotes){
        this.context = context;
        this.quotes = quotes;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_rv , parent , false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        QuoteEntity quote = quotes.get(position);
        holder.quoteTV.setText(quote.getQuote());

    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView quoteTV;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            quoteTV = itemView.findViewById(R.id.quoteTV);
        }
    }
}
