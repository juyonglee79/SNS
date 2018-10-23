package com.dsm2018.sns.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dsm2018.sns.ChangingProfileActivity;
import com.dsm2018.sns.R;

public class UserFragment extends Fragment {
    public UserFragment()
    {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = (View) inflater.inflate(R.layout.fragment_user, container, false);
        Button setting = (Button)view.findViewById(R.id.profile_setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDetail();
            }
        });
        return view;
    }

    public void updateDetail() {
        Intent intent = new Intent(getActivity(),ChangingProfileActivity.class);
        startActivity(intent);
    }
}
