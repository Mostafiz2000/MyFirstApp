package com.example.sample;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class WebsearchActivity extends AppCompatActivity {
WebView w1;
    String s;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websearch);
        w1=findViewById(R.id.web1);
        Intent intent;
        intent=getIntent();
       s= intent.getStringExtra("sea");
        w1.loadUrl("https://www.google.com/search?q="+s);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent;
        intent=new Intent(getApplicationContext(),barcode_scanner.class);

        startActivity(intent);
    }

}