package com.example.jamessmith.newsfeedexample.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.jamessmith.newsfeedexample.R;
import com.example.jamessmith.newsfeedexample.WebActivity;
import com.example.jamessmith.newsfeedexample.rest.model.Model;

/**
 * Created by James on 24/06/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder> {

    private Context context;
    protected Model model;

    public RecyclerAdapter(Context context, Model model){
        this.context = context;
        this.model = model;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_adapter_layout, parent, false);
        return new CustomViewHolder(view, context, model);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.shortDescription.setText(model.getArticles().get(position).getHeadline());
        holder.headline.setText(model.getArticles().get(position).getShortHeadline());

        Glide.with(context)
                .load(model.getArticles().get(position).getImage().getThumbnail())
                .crossFade()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .dontAnimate()
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return model == null ? 0 : model.getArticles().size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{

        public TextView headline, shortDescription;
        public ImageView image;
        public CardView cardView;
        Context context;
        Intent intent;

        public CustomViewHolder(View view, final Context context, final Model customModel){
            super(view);
            image = view.findViewById(R.id.iv_thumbnail);
            headline = view.findViewById(R.id.tv_headline);
            shortDescription = view.findViewById(R.id.tv_decription);
            cardView = view.findViewById(R.id.card_view);
            this.context = context;
            intent = new Intent(context, WebActivity.class);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent.putExtra("webContent", customModel.getArticles().get(getAdapterPosition()).getBody());
                    context.startActivity(intent);
                }
            });
        }
    }
}