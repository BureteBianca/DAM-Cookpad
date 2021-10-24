package com.example.cookpad;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {


    private Button btn_conectare;
    private final int mainActivityRequest=100;
    private EditText email;
    private EditText parola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn_conectare=findViewById(R.id.button4);
        email = findViewById(R.id.email_conectare);
        parola = findViewById(R.id.parola_conectare);

        Intent intent=getIntent();
        Bundle bu=intent.getBundleExtra("transfer");
        Cont cont1=(Cont) bu.getSerializable("cont");
        Toast.makeText(MainActivity3.this,cont1.toString(),Toast.LENGTH_SHORT).show();

        email.setText(cont1.getEmail());
        parola.setText(cont1.getParola());
    }


}