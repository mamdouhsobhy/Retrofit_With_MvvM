package com.example.learnretrofit.data;

import com.example.learnretrofit.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {

    private static final String URL="https://jsonplaceholder.typicode.com/" ;
    private static PostsClient INSTANCE;
    private PostInterface postInterface;

    public PostsClient(){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        postInterface=retrofit.create(PostInterface.class);

    }

    public static PostsClient getINSTANCE(){

        if(null==INSTANCE){
            INSTANCE=new PostsClient();
        }
        return INSTANCE;
    }

    public Call<List<PostModel>> getpost(){

        return postInterface.getPosts();
    }

}
