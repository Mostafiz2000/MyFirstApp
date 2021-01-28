package com.example.sample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;

public class noteeditor extends AppCompatActivity {
    Button newButton,saveButton,openButton;
    DatabaseHelper myDB;
    EditText t8;
    int noteId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noteeditor);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        t8=findViewById(R.id.edittext1);
        saveButton=findViewById(R.id.button);
        myDB = new DatabaseHelper(this);
        Intent intent=getIntent();

        noteId=intent.getIntExtra("nameID",-1);
        if(noteId!=-1)
        {
            t8.setText(Showlogin.notes.get(noteId));
        }
        t8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
             Showlogin.notes.set(noteId,String.valueOf(charSequence));


                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("com.example.sample;", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet<>(Showlogin.notes);

                sharedPreferences.edit().putStringSet("notes",set).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

saveButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Intent i;
        i=new Intent(getApplicationContext(),Showlogin.class);
     startActivity(i);
    }
});

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent;
        intent=new Intent(getApplicationContext(),Showlogin.class);

        startActivity(intent);
    }

}