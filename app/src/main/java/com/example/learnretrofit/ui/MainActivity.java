package com.example.learnretrofit.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.learnretrofit.R;
import com.example.learnretrofit.data.PostsClient;
import com.example.learnretrofit.pojo.PostModel;
import com.example.learnretrofit.ui.adapter.PostsAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    PostsViewModel postsViewModel;
    PostsAdapter postsAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        setupRecycler_with_adapter();

        observe_Data();




    }

    private void observe_Data() {
        postsViewModel.postMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                postsAdapter.setlist((ArrayList<PostModel>) postModels);
            }
        });
    }

    private void setupRecycler_with_adapter() {
        postsAdapter =new PostsAdapter();
        recyclerView=findViewById(R.id.recycler_Item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postsAdapter);

    }

    private void initialize() {
        postsViewModel= ViewModelProviders.of(this).get(PostsViewModel.class);

        postsViewModel.getPosts();
    }
}