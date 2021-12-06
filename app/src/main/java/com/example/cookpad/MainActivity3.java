package com.example.cookpad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {


    private Button btn_conectare;
    private final int mainActivityRequest = 100;
    private EditText email;
    private EditText parola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn_conectare = findViewById(R.id.button4);
        email = findViewById(R.id.email_conectare);
        parola = findViewById(R.id.parola_conectare);

        btn_conectare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this,MainActivity4.class);
                // startActivity(intent);
                startActivityForResult(intent,mainActivityRequest);
            }
        });

        //if (isValid()) {
        // Intent intent = getIntent();
        // Bundle bu = intent.getBundleExtra("transfer");
        // Cont cont1 = (Cont) bu.getSerializable("cont");
        //Toast.makeText(MainActivity3.this, cont1.toString(), Toast.LENGTH_SHORT).show();
        // email.setText(cont1.getEmail());
        //parola.setText(cont1.getParola());
        //}

    }

    //private boolean isValid() {
    //if (email.getText().toString().isEmpty()) {
    // Toast.makeText(MainActivity3.this, "Completati email", Toast.LENGTH_SHORT).show();
    // return false;
    // }
    // if (parola.getText().toString().isEmpty()) {
    // Toast.makeText(MainActivity3.this, "Completati parola", Toast.LENGTH_SHORT).show();
    //  return false;
    // }
    // else return true;
    //}


}