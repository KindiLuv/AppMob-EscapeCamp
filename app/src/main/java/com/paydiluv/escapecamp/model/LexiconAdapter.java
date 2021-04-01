package com.paydiluv.escapecamp.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paydiluv.escapecamp.R;

import java.util.List;

public class LexiconAdapter extends RecyclerView.Adapter<LexiconAdapter.LexiconViewHolder> {

    private List<FloraAndFauna> items;

    public LexiconAdapter(List<FloraAndFauna> items) {
        this.items = items;
    }

    public void setLexiconList(List<FloraAndFauna> fList){
        this.items.clear();
        this.items.addAll(fList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LexiconViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new LexiconViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LexiconViewHolder holder, int position) {
        TextView species = holder.itemView.findViewById(R.id.species);
        TextView description = holder.itemView.findViewById(R.id.description);
        TextView danger = holder.itemView.findViewById(R.id.danger);

        species.setText(items.get(position).species);
        description.setText(items.get(position).info);
        danger.setText(items.get(position).danger);
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class LexiconViewHolder extends RecyclerView.ViewHolder {
        public View itemView;

        public LexiconViewHolder(@NonNull View itemView){
            super(itemView);
            this.itemView = itemView;
        }
    }
}
