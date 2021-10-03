package com.example.learnretrofit.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.learnretrofit.data.PostsClient;
import com.example.learnretrofit.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsViewModel extends ViewModel {


    MutableLiveData<List<PostModel>>postMutableLiveData=new MutableLiveData<>();


    public void getPosts(){

     Call<List<PostModel>> listCall= PostsClient.getINSTANCE().getpost();

     listCall.enqueue(new Callback<List<PostModel>>() {
         @Override
         public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
             postMutableLiveData.setValue(response.body());
         }

         @Override
         public void onFailure(Call<List<PostModel>> call, Throwable t) {

         }
     });
    }




}
