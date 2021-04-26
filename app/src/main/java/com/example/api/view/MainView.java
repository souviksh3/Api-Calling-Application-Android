package com.example.api.view;

import com.example.api.model.Note;

import java.util.List;

public interface MainView {
    Void showRefresh();
    Void hideRefresh();
    Void getNote(List<Note> notes);
    Void onRequestSuccess(String message);
    Void onRequestError(String message);
}
