package com.dsm2018.sns.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.dsm2018.sns.R;

public class OtherUsersProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_othersusers_profile);

        ImageView back_btn = (ImageView)findViewById(R.id.goto_back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtherUsersProfileActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        final Button follow_btn = (Button)findViewById(R.id.follow_btn);
        follow_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                follow_btn.setText("팔로잉");
                follow_btn.setTextColor(Color.parseColor("#000000"));
                view.setBackgroundResource(R.drawable.btn_setting);
            }
        });

    }
}
