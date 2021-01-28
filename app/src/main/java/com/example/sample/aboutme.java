package com.example.sample;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class aboutme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutme);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent;
        intent=new Intent(getApplicationContext(),MainActivity.class);

        startActivity(intent);
    }

}