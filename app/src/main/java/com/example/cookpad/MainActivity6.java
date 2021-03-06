package com.example.cookpad;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        writeToDataBase();
        readFromDataBase();

    }

    private void writeToDataBase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://cookpad-3a5e7-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference("utilizator");

        List<Utilizator> lista = getUtilizator();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < lista.size(); i++) {
                    myRef.setValue(lista.get(i));
                }
            }});
    }

    private void readFromDataBase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://cookpad-3a5e7-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference("utilizator");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = String.valueOf(dataSnapshot.getValue());
                Log.d("util", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("cancel", "Failed to read value.", error.toException());
            }
        });
    }
    public List<Utilizator> getUtilizator(){
        Utilizator u1 = new Utilizator("Vasile",12,"Cl??tite cu mere","400 ml ap?? mineral??/lapte/b??utur?? vegetal??," +
                "1 praf sare," +
                "1 plic zah??r vanilat," +
                "200 gr f??in??," +
                "Esen???? de vanilie," +
                "1 lingur?? unt de arahide," +
                "1 lingur?? ulei," +
                "1 linguri???? praf de copt," +
                "2 mere rase.","Apa mineral?? se amestec?? cu praful de sare, praful de copt, zah??rul vanilat, esen??a de vanilie ??i uleiul." +
                "Se adaug?? f??ina ??i untul de arahide." +
                "Se adaug?? merele rase ??i se ??ncorporeaz??." +
                "Aluatul ob??inut se las?? la odihnit 10 minute, dup?? care se preg??tesc cl??titele." +
                "Poft?? bun?? !");
        Utilizator u2 = new Utilizator("Marius",20,"Bomboane din chec de post","1 can?? zah??r," +
                "200 gr margarina topit??," +
                "2 plicuri zah??r vanilat," +
                "1 plic praf de copt," +
                "1 praf sare," +
                "3 linguri cacao," +
                "150 gr dulcea???? de cire??e","??ntr-un vas se adaug?? : margarin??, dulcea????, zah??rul, apa, zah??rul vanilat, praful de copt, sare. Se amestec?? energic cca 1 min apoi se adaug?? f??ina amestecat?? cu cacao. Se amestec?? p??n?? se ??ncorporeaz?? ??i ob??inem o compozi??ie omogen??. Se tapeteaz?? o tav?? de cozonac cu h??rtie de copt, se adaug?? compozi??ia ob??inut?? ??i se introduce ??n cuptorul ??nc??lzit la 160 grade C ??i se las?? la copt cca 30-40 min."+
                "??i pentru ca ne-a r??mas am zis s?? facem ??i bomboane." +
                "Am f??r??mi??at checul r??mas." +
                "Am mai ad??ugat 1 sticluta esen??a de rom, 2 linguri cacao, 2 linguri dulcea??a ??i suc de portocale. Am amestecat apoi cu m??inile umede ??i am f??cut bomboane." +
                "Poft?? bun??!" +
                "Mul??umesc pentru vizita ??i te mai a??tept!");
        List<Utilizator> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        return list;
    }
}
