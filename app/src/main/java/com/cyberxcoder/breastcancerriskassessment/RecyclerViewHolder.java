package com.cyberxcoder.breastcancerriskassessment;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textData);
    }
}
