package com.example.apinews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private Context context;
    private List newsList;

    public NewsAdapter(Context context,List news){
        this.context=context;
        newsList=news;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        News news = (News) newsList.get(position);
        holder.title.setText(news.getTitle());
        holder.description.setText(news.getDescription());
        holder.author.setText(news.getAuthor());
        holder.publishedAt.setText(news.getPublishedAt());
        Glide.with(context).load(news.getUrlToImage()).into(holder.imageView);
//        Picasso.get().load(news.getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title,description,author,publishedAt;
        public NewsHolder(@NonNull View itemView) {

            super(itemView);

            imageView=itemView.findViewById(R.id.gambarberita);
            title=itemView.findViewById(R.id.judulberita);
            description=itemView.findViewById(R.id.deskripsiberita);
            author=itemView.findViewById(R.id.pengarangberita);
            publishedAt=itemView.findViewById(R.id.rilisberita);
        }
    }
}
