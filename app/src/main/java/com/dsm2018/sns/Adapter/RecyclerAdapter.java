package com.dsm2018.sns.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import com.dsm2018.sns.Item.RecyclerItem;
import com.dsm2018.sns.OtherUsersProfileActivity;
import com.dsm2018.sns.PopupOthersActivity;
import com.dsm2018.sns.R;

import java.util.ArrayList;

import static com.facebook.FacebookSdk.getApplicationContext;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {
    ArrayList<RecyclerItem> mItems;
    Context context;
    OnItemClick onItemClick;

    public RecyclerAdapter(ArrayList<RecyclerItem> items,OnItemClick onItemClick) {
        mItems = items;
        this.context = getApplicationContext();
        this.onItemClick=onItemClick;
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
        holder.profileImg.setImageResource(mItems.get(position).getProfileIMG());
        holder.name.setText(mItems.get(position).getName(""));
        holder.postingImg.setImageResource(mItems.get(position).getPostingIMG());
        holder.like_count.setText(mItems.get(position).getHowManyLike());
        holder.posting_who.setText(mItems.get(position).getPostingWho());
        holder.posting_contents.setText(mItems.get(position).getPosting_contents());
        holder.comment_who.setText(mItems.get(position).getComment_who());
        holder.comment_who.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, OtherUsersProfileActivity.class));
            }
        });
        holder.comment_contents.setText(mItems.get(position).getComment_contents());
        holder.post_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //자신의 게시물일때와 자신의 게시물이 아닐때 다르게 보여줘야함
                context.startActivity(new Intent(context, PopupOthersActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                );
            }
        });

        holder.like.setOnClickListener(new View.OnClickListener()

        {
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



        //jungHyeon
        holder.comment_who.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onWhoClicked();
            }
        });
        //jungHyeon
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onLikeClicked(true,holder.like);
                //  OnItemClick override 해서 구현 하는 곳 에서 true false 값으로 클릭이 되어있는지 확인하고 이미지 세팅해주면 됨
                //
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView profileImg;
        private TextView name;
        private TextView post_setting;
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
            post_setting = (TextView) itemView.findViewById(R.id.post_setting);
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

        public void bindTo(RecyclerItem item){
            //binding
        }

    }

    interface OnItemClick{
        void onProfileClicked();
        void onWhoClicked();
        void onLikeClicked(Boolean clickable,ImageView like);
    }
}
