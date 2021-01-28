package com.example.sample;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashSet;

public class Showlogin extends AppCompatActivity {

    private Button b2,b4,b5;
    static ArrayList<String>notes=new ArrayList<>();
    static ArrayAdapter arrayAdapter;

    private TextView t6;
    private Button b6;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
Bitmap bitmap;
ListView listView;
SearchView s1;
DatabaseHelper myDB;

private  ArrayAdapter<String>stringArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showlogin);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
b6=(findViewById(R.id.button7));
b4=(findViewById(R.id.calbtn));
b5=(findViewById(R.id.button3));
s1=findViewById(R.id.s1);
        myDB = new DatabaseHelper(this);


b4.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i;
        i=new Intent(getApplicationContext(),Calculator.class);
        startActivity(i);
    }
});
b5.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i;
        i=new Intent(getApplicationContext(),barcode_scanner.class);
        startActivity(i);
    }
});
listView =findViewById(R.id.li);

        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("com.example.sample;", Context.MODE_PRIVATE);
        HashSet<String> set =(HashSet)sharedPreferences.getStringSet("notes",null);
if(set==null)
{
    notes.add("");
}
else {
    notes=new ArrayList<>(set);
}

stringArrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,notes);


listView.setAdapter(stringArrayAdapter);

        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();


        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
notes.add("...");
stringArrayAdapter.notifyDataSetChanged();
            }
        });
        s1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                stringArrayAdapter.getFilter().filter(s);
                Intent intent;
                intent=new Intent(getApplicationContext(),noteeditor.class);
                intent.putExtra("nameID",s);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Showlogin.this.stringArrayAdapter.getFilter().filter(s);
                return false;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                intent=new Intent(getApplicationContext(),noteeditor.class);
                intent.putExtra("nameID",i);
                startActivity(intent);

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
final int itemtodelete=i;
new AlertDialog.Builder(Showlogin.this)
        .setTitle("Are You Want to Delete?")
        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                notes .remove(itemtodelete);
                stringArrayAdapter.notifyDataSetChanged();
                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("com.example.sample;", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet<>(Showlogin.notes);

                sharedPreferences.edit().putStringSet("notes",set).apply();

            }
        })
        .setNegativeButton("NO",null)
        .show();
return  true;



            }
        });






    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent;
        intent=new Intent(getApplicationContext(),MainActivity2.class);

        startActivity(intent);
    }


    }
