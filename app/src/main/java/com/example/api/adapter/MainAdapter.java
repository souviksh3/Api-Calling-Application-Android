package com.example.api.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api.R;
import com.example.api.model.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter< MainAdapter.MyRecyclerViewAdapter> {

    Context context;
   Note note;

    public MainAdapter(Context context, Note note) {
        this.context = context;
        this.note = note;
    }

    @Override
    public MyRecyclerViewAdapter onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.design, parent,false);
        return new MyRecyclerViewAdapter(view);
    }

    @Override
    public void onBindViewHolder( MyRecyclerViewAdapter holder, int position) {

        Note notes = note;

        holder.mtv1.setText( notes.getName());
        holder.mtv1.setText(notes.getAddress());
        holder.mtv1.setText(notes.getContact());
        holder.mtv1.setText(notes.getRegistration());

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyRecyclerViewAdapter extends RecyclerView.ViewHolder{
        TextView mtv1;

        public MyRecyclerViewAdapter( View itemView) {
            super(itemView);

            mtv1 = itemView.findViewById(R.id.tv1);

        }
    }
}
