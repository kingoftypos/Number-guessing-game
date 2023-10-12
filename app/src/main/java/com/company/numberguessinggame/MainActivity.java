package com.company.numberguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
RadioButton btn2,btn3,btn4;
Button play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn2=findViewById(R.id.btn2dig);
        btn3=findViewById(R.id.btn3dig);
        btn4=findViewById(R.id.btn4dig);
        play=findViewById(R.id.playbtn);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!btn2.isChecked()&&!btn3.isChecked()&&!btn4.isChecked())
                {
                    Snackbar.make(v,"Please select an option",Snackbar.LENGTH_SHORT).show();
                }
                else if(btn2.isChecked())
                {
                   Intent intent=new Intent(MainActivity.this,GameActivity.class);
                   intent.putExtra("option2",true);
                   startActivity(intent);
                   finish();
                }
                else if(btn3.isChecked())
                {
                    Intent intent=new Intent(MainActivity.this,GameActivity.class);
                    intent.putExtra("option3",true);
                    startActivity(intent);
                    finish();
                }
                else if(btn4.isChecked())
                {
                    Intent intent=new Intent(MainActivity.this,GameActivity.class);
                    intent.putExtra("option4",true);
                    startActivity(intent);
                    finish();
                }
            }
        });



    }
}