package com.example.api.presenter;

import com.example.api.api.ApiClient;
import com.example.api.api.ApiInterface;
import com.example.api.model.Note;
import com.example.api.view.NoteView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotePresenter {

    public NoteView view;

    public NotePresenter(NoteView view) {
        this.view = view;
    }

    public void noteSavePresenter(String name, String address, String contact, String registration){

        view.showProgress();

        ApiInterface apiInterface = ApiClient.getRetrofitClint().create(ApiInterface.class);
        Call<Note> call = apiInterface.saveNote( name,address,contact,registration);

        call.enqueue(new Callback<Note>() {
            @Override
            public void onResponse(Call<Note> call, Response<Note> response) {
                view.hideProgress();
                if(response.isSuccessful()){
                    if(response.body().getSuccess()){
                        view.onRequestSuccess(response.body().getValue());
                    }else{
                        view.onRequestError(response.body().getValue());
                    }
                }
            }

            @Override
            public void onFailure(Call<Note> call, Throwable t) {
                view.hideProgress();
                view.onRequestError(t.getLocalizedMessage());

            }
        });

    }

    public void updateNotePresenter(String id,String title,String message){
        view.showProgress();

        ApiInterface apiInterface = ApiClient.getRetrofitClint().create(ApiInterface.class);

        Call<Note> call = apiInterface.updateNote(id, title,message);

        call.enqueue(new Callback<Note>() {
            @Override
            public void onResponse(Call<Note> call, Response<Note> response) {
                view.hideProgress();
                if(response.isSuccessful()){
                    if(response.body().getSuccess()){
                        view.onRequestSuccess(response.body().getValue());
                    }else{
                        view.onRequestError(response.body().getValue());
                    }
                }
            }

            @Override
            public void onFailure(Call<Note> call, Throwable t) {
                view.hideProgress();
                view.onRequestError(t.getLocalizedMessage());

            }
        });


    }


}
