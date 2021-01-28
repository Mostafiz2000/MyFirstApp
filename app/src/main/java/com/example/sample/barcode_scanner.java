package com.example.sample;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class barcode_scanner extends AppCompatActivity implements View.OnClickListener {
Button b12,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_scanner);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        b12=findViewById(R.id.button4);
        b12.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        scanCode();

    }
    private void scanCode()
    {
        IntentIntegrator integrator=new IntentIntegrator(this );
        integrator.setCaptureActivity(capture.class);
        integrator.setOrientationLocked(false);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Scanning code");
        integrator.initiateScan();

    }
   @Override
    protected void onActivityResult(int requestCode, int resulCode, Intent data){
       IntentResult result=IntentIntegrator.parseActivityResult(requestCode,resulCode,data);
       if(result!=null)
       {
           if(result.getContents()!=null)
           {
               AlertDialog.Builder builder=new AlertDialog.Builder(this);
               builder.setMessage(result.getContents());
               Intent intent;
               intent=new Intent(getApplicationContext(),WebsearchActivity.class);
               String s=result.getContents().toString();
               intent.putExtra("sea",s);
               startActivity(intent);
               builder.setTitle("Scanning Result");
               builder.setPositiveButton("scan Again", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       scanCode();

                   }
               }).setNegativeButton("Finish", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       finish();
                   }
               });
               AlertDialog dialog=builder.create();
               dialog.show();
           }else
           {
               Toast.makeText(this,"NO Results",Toast.LENGTH_LONG).show();


           }
       }else
       {
          super.onActivityResult(requestCode,resulCode,data);
       }
   }
}