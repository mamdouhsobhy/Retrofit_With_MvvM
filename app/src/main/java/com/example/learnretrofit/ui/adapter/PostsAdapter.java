package com.example.learnretrofit.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnretrofit.R;
import com.example.learnretrofit.pojo.PostModel;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {


    private ArrayList<PostModel>arrayList=new ArrayList<>();

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_posts, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {

        holder.body.setText(arrayList.get(position).getBody());
        holder.title.setText(arrayList.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void setlist(ArrayList<PostModel>arrayList){
        this.arrayList=arrayList;
        notifyDataSetChanged();
    }
    public class PostsViewHolder extends RecyclerView.ViewHolder {

        TextView title,body;
        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.txt1);
            body=itemView.findViewById(R.id.txt2);
        }
    }
}
