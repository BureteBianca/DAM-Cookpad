package com.example.cookpad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_conectare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("tagCautare", "Found.");
        Log.e("tagCautare", "Found. Error");
        Log.i("tagCautare", "Found. Info");
        Log.d("tagCautare", "Found. Debug");

        Log.v("lifecycle", "onCreate");

        btn_conectare=findViewById(R.id.button2);
        btn_conectare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newWindow = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(newWindow);
            }
        });
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