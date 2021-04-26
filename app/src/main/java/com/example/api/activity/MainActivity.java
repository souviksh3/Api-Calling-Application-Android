package com.example.api.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.api.R;
import com.example.api.adapter.MainAdapter;
import com.example.api.model.Note;
import com.example.api.presenter.MainPresenter;
import com.example.api.view.MainView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MainActivity extends AppCompatActivity implements MainView {

    SwipeRefreshLayout mSwip;
    RecyclerView mRecyclerView;
    MainPresenter mainPresenter;
    MainAdapter mainAdaptar;
    FloatingActionButton fltbtn;

    List<Note> note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSwip=findViewById(R.id.swipe_refresh);
        mRecyclerView=findViewById(R.id.recyclerView);
        fltbtn = findViewById(R.id.floatbtn);

        mainPresenter = new MainPresenter(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mainPresenter.readNotePresenter();
        mSwip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mainPresenter.readNotePresenter();

            }
        });




    }

    @Override
    public Void showRefresh() {

        mSwip.setRefreshing(true);
        return null;

    }

    @Override
    public Void hideRefresh() {
        mSwip.setRefreshing(false);
        return null;

    }

    @Override
    public Void getNote(List<Note> notes) {
        mainAdaptar = new MainAdapter(MainActivity.this, (Note) notes);
        mRecyclerView.setAdapter(mainAdaptar);
        note = notes;
        return null;


    }

    @Override
    public Void onRequestSuccess(String message) {

        Toast.makeText(MainActivity.this,"sucessfull",Toast.LENGTH_LONG).show();
        return null;

    }

    @Override
    public Void onRequestError(String message) {
        Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
        return null;

    }
}
