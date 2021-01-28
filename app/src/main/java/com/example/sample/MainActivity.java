package com.example.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import static org.mozilla.javascript.Context.exit;

public class MainActivity extends AppCompatActivity {
private TextView t1,t2;
LinearLayout l1;
private ImageView i1,i2;
private RelativeLayout layout1;
private Button b1,b2;
private EditText e1,p1;
private TextView t6,t7;
FirebaseAuth fAuth;
FirebaseFirestore fStore;
String userID;

Animation topanim,botomanim,sideanim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

l1=findViewById(R.id.li);
t7=findViewById(R.id.textView12);
i1=findViewById(R.id.imageView9);
t6=findViewById(R.id.textView5);
t2=findViewById(R.id.textView11);
i2=findViewById(R.id.imageView);


t6.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Intent i;
        i = new Intent(getApplicationContext(), aboutme.class);
        startActivity(i);
        return false;
    }
});
        t7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent i;
                i = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(i);
                return false;
            }
        });
        i1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent i;
                i = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(i);
                return false;

            }
        });
        i2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent i;
                i = new Intent(getApplicationContext(),KidsZoneOption.class);
                startActivity(i);
                return false;

            }
        });
        t2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent i;
                i = new Intent(getApplicationContext(),KidsZoneOption.class);
                startActivity(i);
                return false;

            }
        });












        topanim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        botomanim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        sideanim= AnimationUtils.loadAnimation(this,R.anim.sidex);




    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent;
       exit();
    }
}