package com.dsm2018.sns.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dsm2018.sns.LoginCallback;
import com.dsm2018.sns.R;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    private Context mContext;
    private TextView signin_tv;
    private Button facebook_login, login;
    private LoginCallback mLoginCallback;
    private CallbackManager mCallbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = getApplicationContext();
        mCallbackManager = CallbackManager.Factory.create();
        mLoginCallback = new LoginCallback();
        login = (Button) findViewById(R.id.login_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        facebook_login = (Button) findViewById(R.id.facebook_login_btn);
        facebook_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                LoginManager loginManager = LoginManager.getInstance();
                loginManager.logInWithReadPermissions(LoginActivity.this,
                        Arrays.asList("public_profile", "email"));
                loginManager.registerCallback(mCallbackManager, mLoginCallback);
            }
        });
        signin_tv = (TextView) findViewById(R.id.signin_tv);
        signin_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

}


