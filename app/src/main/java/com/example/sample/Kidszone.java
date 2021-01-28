package com.example.sample;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Random;


public class Kidszone extends AppCompatActivity {
    private PaintView2 paintview;
    TextView tset;
TextToSpeech textToSpeech;
Button bclr,banother,bclr3;
    public String[] alpha={"a","A","b","B","c","C","d","D","e","E","f","F","g","G","h","H"
    ,"I","i","j","J","k","K","l","L","m","M","N","n","O","o","p","P","Q","q","r","R","s","S","T","t","u"
    ,"U","v","V","w","W","y","Y","z","Z","0","1","2","3","4","5","6","7","8","9"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kidszone);

        paintview =  findViewById(R.id.paintview);
        tset=findViewById(R.id.textView3);
        bclr=findViewById(R.id.bclr);
        bclr3=findViewById(R.id.bclr3);
        banother=findViewById(R.id.bclr2);
       final Random a1=new Random();
        banother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int d=a1.nextInt(60);
                tset.setText(alpha[d]);


            }
        });
        textToSpeech=new TextToSpeech(getApplicationContext(),
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if(i==TextToSpeech.SUCCESS)
                        {
                            int lang=textToSpeech.setLanguage(Locale.ENGLISH);

                        }
                    }
                });
        bclr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=tset.getText().toString();
                int speech=textToSpeech.speak(s,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintview.init(metrics);
        paintview.emboss();
        bclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               paintview.clear();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.normal:
                paintview.normal();
                return true;
            case R.id.emboss:
                paintview.emboss();
                return true;
            case R.id.blur:
                paintview.blur();
                return true;
            case R.id.clear:
                paintview.clear();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent;
        intent=new Intent(getApplicationContext(),KidsZoneOption.class);

        startActivity(intent);
    }
}