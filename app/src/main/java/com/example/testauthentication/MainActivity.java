package com.example.testauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_screen);


        skipAuth();


        Button signUp = findViewById(R.id.btCreateAcc);
        signUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SignUp_Activity.class);
                startActivity(i);
            }
        });

        TextView signIn = findViewById(R.id.txHaveAcc);
        signIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(MainActivity.this,SignIn_Activity.class);
                startActivity(i);
            }
        });



    }
    private void skipAuth(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null)
            startActivity(new Intent(MainActivity.this,UserActivity.class));
        else return;
    }
}