package com.example.api.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.api.R;
import com.example.api.presenter.NotePresenter;
import com.example.api.view.NoteView;

public class SimpleNote extends AppCompatActivity implements NoteView {

    EditText medt1,medt2,medt3,medt4;
    Button mbtn;
    NotePresenter notePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_note);
        mbtn = findViewById(R.id.btn1);
        medt1 = findViewById(R.id.edt1);
        medt2 = findViewById(R.id.edt2);
        medt3 = findViewById(R.id.edt3);
        medt4 = findViewById(R.id.edt4);


        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                notePresenter.noteSavePresenter(medt1.toString(),medt2.toString(),medt3.toString(),medt4.toString());
                finish();

            }
        });
    }

    @Override
    public Void showProgress() {

        return null;
    }

    @Override
    public Void hideProgress() {

        return null;
    }

    @Override
    public Void onRequestSuccess(String message) {
        Toast.makeText(SimpleNote.this,"sucessfull",Toast.LENGTH_LONG).show();

        return null;
    }

    @Override
    public Void onRequestError(String message) {

        Toast.makeText(SimpleNote.this,message,Toast.LENGTH_LONG).show();

        return null;
    }
}
