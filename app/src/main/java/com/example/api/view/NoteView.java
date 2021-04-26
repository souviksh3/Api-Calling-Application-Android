package com.example.api.view;

public interface NoteView {
    Void showProgress();
    Void hideProgress();
    Void onRequestSuccess(String message);
    Void onRequestError(String message);
}
