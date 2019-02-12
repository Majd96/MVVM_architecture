package com.example.majdbaniodeh.mvvm_architecture.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.majdbaniodeh.mvvm_architecture.R;
import com.example.majdbaniodeh.mvvm_architecture.model.Article;


import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>{

    private ArrayList<Article> ArticleArrayList;
    private Context context;

    public ArticleAdapter(ArrayList<Article> ArticleArrayList, Context context) {
        this.ArticleArrayList = ArticleArrayList;
        this.context = context;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        return new ArticleViewHolder(layoutInflater.inflate(R.layout.article_item,parent,false));

    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        holder.titleTextView.setText(ArticleArrayList.get(position).getTitle());
//        holder.authorTextView.setText(ArticleArrayList.get(position).getTags().get(0).getAuthorName());
        holder.dateTextView.setText(ArticleArrayList.get(position).getDate());
        holder.sectionTextView.setText(ArticleArrayList.get(position).getSection());


    }

    @Override
    public int getItemCount() {
        if(ArticleArrayList==null)
            return 0;
        return ArticleArrayList.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        TextView sectionTextView;
        TextView titleTextView;
        TextView authorTextView;
        TextView dateTextView;


        public ArticleViewHolder(View itemView) {
            super(itemView);
            sectionTextView=itemView.findViewById(R.id.textViewSection);
            titleTextView=itemView.findViewById(R.id.textViewTitle);
            authorTextView=itemView.findViewById(R.id.textViewAuthor);
            dateTextView=itemView.findViewById(R.id.textViewDate);
        }



    }
}