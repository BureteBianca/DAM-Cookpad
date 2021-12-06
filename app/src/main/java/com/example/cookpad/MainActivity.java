package com.example.cookpad;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btn_conectare;
    private Button btn_inregistrare;
    private Button btn_database;
    private final int mainActivityRequest=100;
    private Cont cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("tagCautare", "Found.");
        Log.e("tagCautare", "Found. Error");
        Log.i("tagCautare", "Found. Info");
        Log.d("tagCautare", "Found. Debug");

        Log.v("lifecycle", "onCreate");

        btn_conectare=findViewById(R.id.buton_conectare);
        btn_inregistrare=findViewById(R.id.buton_inregistrare);
        btn_database=findViewById(R.id.btn_database);

        btn_database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity5.class);
                startActivity(intent);
            }
        });

        btn_conectare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle but = new Bundle();
                but.putSerializable("cont", cont);
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                intent.putExtra("transfer", but);
                startActivity(intent);
            }
        });
        btn_inregistrare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                // startActivity(intent);
                startActivityForResult(intent,mainActivityRequest);
            }
        });

        //Toast.makeText(MainActivity.this,cont.toString(),Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==mainActivityRequest){
            if(resultCode==RESULT_OK){
                if(data!=null){
                    Bundle newBundle =  data.getBundleExtra("raspunsBundle");
                    cont = (Cont) newBundle.getSerializable("cont");
                }
            }

        }


    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.v("lifecycle","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.v("lifecycle","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("lifecycle","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("lifecycle","onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.v("lifecycle","onDestroy");
    }


}