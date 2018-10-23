package com.dsm2018.sns.Adapter;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dsm2018.sns.ChangingProfileActivity;
import com.dsm2018.sns.Item.RecyclerItem;
import com.dsm2018.sns.MainActivity;
import com.dsm2018.sns.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {
    ArrayList<RecyclerItem> mItems;

    public RecyclerAdapter(ArrayList<RecyclerItem> items) {
        mItems = items;
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position, boolean isUser);
    }

    private OnItemClickListener onItemClickListener;

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new ItemViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        int i = 10;
        int sum1, sum2;
        holder.profileImg.setImageResource(mItems.get(position).getProfileIMG());
        holder.name.setText(mItems.get(position).getName("이주용"));
        holder.postingImg.setImageResource(mItems.get(position).getPostingIMG());
        holder.like_count.setText(mItems.get(position).getHowManyLike());
        holder.posting_who.setText(mItems.get(position).getPostingWho());
        holder.posting_contents.setText(mItems.get(position).getPosting_contents());
        holder.comment_who.setText(mItems.get(position).getComment_who());
        holder.comment_contents.setText(mItems.get(position).getComment_contents());

        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.like.setImageResource(R.drawable.ic_like_clicked);
            }
        });
//        holder.like.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                holder.like.setImageResource(R.drawable.ic_like_unclicked);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView profileImg;
        private TextView name;
        private ImageView postingImg;
        //        private ViewPager postingImg;
        private ImageView like;
        private ImageView comment;
        private TextView like_count;
        private TextView posting_who;
        private TextView posting_contents;
        private TextView comment_who;
        private TextView comment_contents;

        public ItemViewHolder(View itemView) {
            super(itemView);
            profileImg = (ImageView) itemView.findViewById(R.id.profile_img);
            name = (TextView) itemView.findViewById(R.id.profile_name);
            postingImg = (ImageView) itemView.findViewById(R.id.post_img_vp);
//            postingImg = (ViewPager) itemView.findViewById(R.id.post_img_vp);
            like = (ImageView) itemView.findViewById(R.id.like);
            comment = (ImageView) itemView.findViewById(R.id.comment);
            like_count = (TextView) itemView.findViewById(R.id.how_many_like);
            posting_who = (TextView) itemView.findViewById(R.id.posting_who);
            posting_contents = (TextView) itemView.findViewById(R.id.post_contents);
            comment_who = (TextView) itemView.findViewById(R.id.comment_who);
            comment_contents = (TextView) itemView.findViewById(R.id.comment_contents);

        }
    }
}