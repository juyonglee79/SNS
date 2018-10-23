package com.dsm2018.sns.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.dsm2018.sns.Adapter.RecyclerAdapter;
import com.dsm2018.sns.ChangingProfileActivity;
import com.dsm2018.sns.Item.RecyclerItem;
import com.dsm2018.sns.MainActivity;
import com.dsm2018.sns.R;

import java.util.ArrayList;

public class PostFragment extends Fragment {

    ArrayList<RecyclerItem> arrayList;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    RecyclerAdapter recyclerAdapter;
    ImageView like = null;

    public PostFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arrayList = new ArrayList<>();

        arrayList.add(new RecyclerItem((R.drawable.profile_img), "이주용", (R.drawable.img_example),(R.drawable.ic_like_unclicked), (R.drawable.ic_comment), "100 iked", "이주용","나 개잘생김","황신우", "ㅈㄹ"));
        arrayList.add(new RecyclerItem((R.drawable.profile_img), "이주용", (R.drawable.img_example),(R.drawable.ic_like_unclicked), (R.drawable.ic_comment), "100 iked","이주용","나 개잘생김","황신우", "ㅈㄹ"));
        arrayList.add(new RecyclerItem((R.drawable.profile_img), "이주용", (R.drawable.img_example),(R.drawable.ic_like_unclicked), (R.drawable.ic_comment), "100 iked","이주용","나 개잘생김","황신우", "ㅈㄹ"));
        arrayList.add(new RecyclerItem((R.drawable.profile_img), "이주용", (R.drawable.img_example),(R.drawable.ic_like_unclicked), (R.drawable.ic_comment), "100 iked","이주용","나 개잘생김","황신우", "ㅈㄹ"));

//        like = (ImageView) recyclerView.findViewById(R.id.like);
//        like.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                like.setImageResource(R.drawable.ic_like_clicked);
//            }
//        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_posting, container, false);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.user_post_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerAdapter = new RecyclerAdapter(arrayList);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.scrollToPosition(0);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return view;
    }
}
