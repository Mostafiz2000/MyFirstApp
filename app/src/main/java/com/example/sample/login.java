package com.example.sample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {
    public static final String TAG="login";
private EditText t1,t2,t3,t4;
private TextView t5;
private Button b1;
    FirebaseFirestore firebaseFirestore;
    // Access a Cloud Firestore instance from your Activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        firebaseFirestore = FirebaseFirestore.getInstance();

        t1=(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.t2);
        t3=(EditText)findViewById(R.id.t3);
        t4=(EditText)findViewById(R.id.t4);
        t5=(TextView) findViewById(R.id.t5);
        b1=(Button)findViewById(R.id.b1);
        String s=t1.getText().toString();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppData();
            }
        });

    }
   
    public void AppData(){
        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("Name",t2.getText().toString());
        user.put("Email", t3.getText().toString());
        user.put("Password",t4.getText().toString());

// Add a new document with a generated ID
        firebaseFirestore.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                        Intent i;
                        finish();
                        i = new Intent(getApplicationContext(), MainActivity.class);

                        startActivity(i);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }
}