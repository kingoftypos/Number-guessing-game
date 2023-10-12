package com.company.numberguessinggame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
TextView hint,right,last;
EditText guess;
Boolean opt2,opt3,opt4;
Button confirm;
int random;
int userrights=10;
int userattempts=0;
ArrayList<Integer> guesslist= new ArrayList<>();
Random r=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        last=findViewById(R.id.guesstext);
        right=findViewById(R.id.rightstext);
        hint=findViewById(R.id.commandtext);
        guess=findViewById(R.id.ans);
        confirm=findViewById(R.id.confirmbtn);

        opt2=getIntent().getBooleanExtra("option2",false);
        opt3=getIntent().getBooleanExtra("option3",false);
        opt4=getIntent().getBooleanExtra("option4",false);

        if(opt2)
        {
            random=r.nextInt(90)+10;
        }
        if(opt3)
        {
            random=r.nextInt(900)+100;
        }
        if(opt4) {
            random = r.nextInt(9000) + 1000;
        }




        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer=guess.getText().toString();
                int ans=Integer.valueOf(answer);
                guesslist.add(ans);
                if(answer.equals(""))
                {
                    Toast.makeText(GameActivity.this, "Enter a no please", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    last.setVisibility(View.VISIBLE);
                    right.setVisibility(View.VISIBLE);
                    hint.setVisibility(View.VISIBLE);

                    userrights=userrights-1;
                    userattempts=userattempts+1;
                    last.setText("Your last Guess is: "+answer);
                    right.setText("Your remaining rights are: "+userrights);

                    if(ans==random)
                    {
                        AlertDialog.Builder alert= new AlertDialog.Builder(GameActivity.this);
                        alert.setCancelable(false);
                        alert.setTitle("Number Guessing Game");
                        alert.setMessage("Congratulation! \n\n you have guessed it right in "+userattempts+"  userattempts\n\n" +
                                "your guesses are: "+ guesslist+"\n\n Would you like play Game again??\n\n");
                        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent=new Intent(GameActivity.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                               GameActivity.this.finishAffinity();
                            }
                        });
                        alert.create().show();
                    }
                    if(ans>random)
                    {
                      hint.setText("Decrease Your Guess");
                    }
                    if(ans<random)
                    {
                     hint.setText("Increase Your Guess");
                    }
                    if(userrights==0)
                    {
                        AlertDialog.Builder alert= new AlertDialog.Builder(GameActivity.this);
                        alert.setCancelable(false);
                        alert.setTitle("Number Guessing Game");
                        alert.setMessage("Sorry! \n\n you have guessed it wrong /n/n" +
                                "the number was: "+random+
                                "\n\nyour guesses are: "+ guesslist+"\n\n Would you like play Game again??\n\n");
                        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent=new Intent(GameActivity.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                GameActivity.this.finishAffinity();
                            }
                        });
                        alert.create().show();
                    }

                    guess.setText("");
                }
            }
        });



    }
}