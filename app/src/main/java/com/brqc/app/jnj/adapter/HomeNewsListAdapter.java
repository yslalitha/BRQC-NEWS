package com.brqc.app.jnj.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.brqc.app.jnj.R;
import com.brqc.app.jnj.activity.BRQCNewsDetailActivity;
import com.brqc.app.jnj.constants.BRQCConstants;
import com.brqc.app.jnj.model.GetNewsFeedForUser;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 09/01/18.
 */

public class HomeNewsListAdapter extends RecyclerView.Adapter<HomeNewsListAdapter.HomeNewsViewHolder> {

    private List<GetNewsFeedForUser.NewsFeed> mNewsFeedList = null;
    private Context mContext = null;

    public HomeNewsListAdapter(Context context, ArrayList<GetNewsFeedForUser.NewsFeed> restaurants) {
        mContext = context;
        mNewsFeedList = restaurants;
    }


    @Override
    public HomeNewsListAdapter.HomeNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.brqc_home_new_item, parent, false);
        HomeNewsViewHolder viewHolder = new HomeNewsViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HomeNewsListAdapter.HomeNewsViewHolder holder, final int position) {


        Glide.with(mContext)
                .load(mNewsFeedList.get(position).getNewsItemURL().toString())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(30,30)
                .into(holder.mNewsImageView);

        String region = mNewsFeedList.get(position).getRegions().get(0).getRegionValue();

        holder.mNewsTitle.setText(mNewsFeedList.get(position).getNewsTitle());
        holder.mNewsTimeStamp.setText(mNewsFeedList.get(position).getPublishDate());
        holder.mNewsRegion.setText(region);
        holder.mNewsLikes.setText(mNewsFeedList.get(position).getLikes().toString());
        holder.mNewsListCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(mContext, BRQCNewsDetailActivity.class);
                mIntent.putExtra(BRQCConstants.NEWSLIST_DESC_KEY , mNewsFeedList.get(position).getDescription());
                mIntent.putExtra(BRQCConstants.NEWSLIST_IMAGE_URL,mNewsFeedList.get(position).getNewsImageURL());
                mIntent.putExtra(BRQCConstants.NEWSLIST_TITLE_KEY,mNewsFeedList.get(position).getNewsTitle());
                mContext.startActivity(mIntent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mNewsFeedList.size();
    }

    public class HomeNewsViewHolder extends RecyclerView.ViewHolder {

        TextView mNewsTitle;
        TextView mNewsTimeStamp;
        TextView mNewsRegion;
        TextView mNewsLikes;
        ImageView mNewsImageView;
        CardView mNewsListCV;



        public HomeNewsViewHolder(View itemView) {
            super(itemView);

            mNewsImageView = itemView.findViewById(R.id.home_news_image_id);
            mNewsTitle = itemView.findViewById(R.id.home_news_title_id);
            mNewsTimeStamp = itemView.findViewById(R.id.new_time_stamp);
            mNewsRegion = itemView.findViewById(R.id.news_region);
            mNewsLikes = itemView.findViewById(R.id.new_likes);
            mNewsListCV = itemView.findViewById(R.id.card_view);

        }
    }
}
