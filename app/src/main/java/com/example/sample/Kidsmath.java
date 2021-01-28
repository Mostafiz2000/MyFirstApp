package com.example.sample;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Kidsmath extends AppCompatActivity {
TextView t1,t2,t3,t5,t8,t9;
EditText t4;
Button b1;
int d,e,f;
    MediaPlayer player,player1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kidsmath);
        t1=findViewById(R.id.tnum1);
        t2=findViewById(R.id.tnum2);
        t3=findViewById(R.id.tnum3);
        t4=findViewById(R.id.tnum4);
        t5=findViewById(R.id.tnum5);
        b1=findViewById(R.id.beql);
        t8=findViewById(R.id.tnum8);
        final Random a=new Random();
        player=MediaPlayer.create(this,R.raw.correct);
        player1=MediaPlayer.create(this,R.raw.wrong2);
        e=a.nextInt(1000);
        final  Random b=new Random();
f=b.nextInt(100);
 d=a.nextInt(4);
if(d==1)
{
    t2.setText("-");
}
        if(d==0)
        {
            t2.setText("+");
        }
        if(d==2)
        {
            t2.setText("*");
        }
        if(d==3)
        {
            t2.setText("/");
        }

        t1.setText(String.valueOf(e));
        t3.setText(String.valueOf(f));
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

int result=0;
                if(d==1)
                {
                  result=e-f;
                }
                if(d==0)
                {
                  result=e+f;
                }
                if(d==2)
                {
                 result=e*f;
                }
                if(d==3)
                {
                    result=e/f;
                }
if(result==Integer.parseInt(t4.getText().toString()))
{
    t8.setText(null);
    t5.setText("Correct");
    player.start();
    e=a.nextInt(1000);
    t1.setText(String.valueOf(e));
    f=b.nextInt(100);
    t3.setText(String.valueOf(f));
    d=a.nextInt(4);
    if(f>e)
    {
      int  temp=f;
        f=e;
        e=temp;
    }
    if(d==1)
    {
        t2.setText("-");
    }
    if(d==0)
    {
        t2.setText("+");
    }
    if(d==2)
    {
        t2.setText("*");
    }
    if(d==3)
    {
        t2.setText("/");
    }

}
else {
    t5.setText(null);
    t8.setText("Wrong");
    player1.start();



}
t4.setText(null);
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent;
        intent=new Intent(getApplicationContext(),KidsZoneOption.class);

        startActivity(intent);
    }
}