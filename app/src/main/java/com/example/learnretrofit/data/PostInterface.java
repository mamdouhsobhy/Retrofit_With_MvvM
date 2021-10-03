package com.example.learnretrofit.data;

import com.example.learnretrofit.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PostInterface {

    @GET("posts")
    public Call<List<PostModel>> getPosts();

}
