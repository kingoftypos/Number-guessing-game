package com.company.numberguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splashscreen extends AppCompatActivity {
TextView text;
ImageView img;

Animation animimg,animtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        text=findViewById(R.id.textsplash);
        img=findViewById(R.id.imgsplash);
        getSupportActionBar().hide();

       animimg= AnimationUtils.loadAnimation(this,R.anim.animation);
       animtext=AnimationUtils.loadAnimation(this,R.anim.text_animation);
       img.setAnimation(animimg);
       text.setAnimation(animtext);


        new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent= new Intent(splashscreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();


    }
}