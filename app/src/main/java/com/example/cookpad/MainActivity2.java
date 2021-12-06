package com.example.cookpad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private Button btn_creare;
    private EditText etNume;
    private EditText etEmail;
    private EditText etParola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_creare=findViewById(R.id.button);
        etNume = findViewById(R.id.nume_inregistrare);
        etEmail= findViewById(R.id.mail_inregistrare);
        etParola = findViewById(R.id.parola_inregistrare);

        btn_creare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValid()) {
                    Cont cont = new Cont();
                    cont.setNume(etNume.getText().toString());
                    cont.setEmail(etEmail.getText().toString());
                    cont.setParola(etParola.getText().toString());
                    Toast.makeText(MainActivity2.this, cont.toString(), Toast.LENGTH_SHORT).show();
                    Bundle wrapperObject = new Bundle();
                    wrapperObject.putSerializable("cont", cont);
                    Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                    intent.putExtra("raspunsBundle", wrapperObject);
                    setResult(RESULT_OK, intent);
                    finish();
                }}
        });
    }

    private boolean isValid() {
        if(etNume.getText().toString().isEmpty()){
            Toast.makeText(MainActivity2.this, "Completati numele", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(etEmail.getText().toString().isEmpty()){
            Toast.makeText(MainActivity2.this, "Completati email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(etParola.getText().toString().isEmpty()){
            Toast.makeText(MainActivity2.this, "Completati parola", Toast.LENGTH_SHORT).show();
            return false;
        }
        else return true;
    }

}