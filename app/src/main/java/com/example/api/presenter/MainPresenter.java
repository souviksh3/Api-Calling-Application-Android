package com.example.api.presenter;

import com.example.api.api.ApiClient;
import com.example.api.api.ApiInterface;
import com.example.api.model.Note;
import com.example.api.view.MainView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

  public MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void readNotePresenter(){

        view.showRefresh();

        ApiInterface apiInterface = ApiClient.getRetrofitClint().create(ApiInterface.class);
        Call<List<Note>> call = apiInterface.readNote();

       call.enqueue(new Callback<List<Note>>() {
           @Override
           public void onResponse(Call<List<Note>> call, Response<List<Note>> response) {
               view.hideRefresh();
               if(response.isSuccessful()){
                   view.getNote(response.body());
               }
           }

           @Override
           public void onFailure(Call<List<Note>> call, Throwable t) {
               view.hideRefresh();
               view.onRequestError(t.getLocalizedMessage());

           }
       });
    }

    public void deleteNotePresenter(String id){
        view.showRefresh();

        ApiInterface apiInterface = ApiClient.getRetrofitClint().create(ApiInterface.class);
        Call<Note> call = apiInterface.deleteNote(id);
        call.enqueue(new Callback<Note>() {
            @Override
            public void onResponse(Call<Note> call, Response<Note> response) {
                view.hideRefresh();
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
                view.hideRefresh();
                view.onRequestError(t.getLocalizedMessage());

            }
        });


    }
}
