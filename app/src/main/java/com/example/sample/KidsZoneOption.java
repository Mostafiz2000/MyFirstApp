package com.example.sample;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class KidsZoneOption extends AppCompatActivity {
private Button btnmath,btndraw,btnstop;
MediaPlayer player;
    int  f = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_zone_option);
        btndraw=findViewById(R.id.btndraw);
        btnmath=findViewById(R.id.btnmath);
btnstop=findViewById(R.id.button5);

btnmath.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent;
        if(player!=null)
            player.stop();
        intent=new Intent(getApplicationContext(),Kidsmath.class);

        startActivity(intent);
    }
});
        btndraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                if(player!=null)
                player.stop();
                intent=new Intent(getApplicationContext(),Kidszone.class);

                startActivity(intent);
            }
        });
        player=MediaPlayer.create(this,R.raw.cartoon);
        player.start();

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

player.stop();

            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent;
        if(player!=null)
            player.stop();
        intent=new Intent(getApplicationContext(),MainActivity.class);

        startActivity(intent);
    }


}