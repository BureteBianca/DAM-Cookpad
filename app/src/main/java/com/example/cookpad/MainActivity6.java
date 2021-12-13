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
        Utilizator u1 = new Utilizator("Vasile",12,"Clătite cu mere","400 ml apă minerală/lapte/băutură vegetală," +
                "1 praf sare," +
                "1 plic zahăr vanilat," +
                "200 gr făină," +
                "Esență de vanilie," +
                "1 lingură unt de arahide," +
                "1 lingură ulei," +
                "1 linguriță praf de copt," +
                "2 mere rase.","Apa minerală se amestecă cu praful de sare, praful de copt, zahărul vanilat, esența de vanilie și uleiul." +
                "Se adaugă făina și untul de arahide." +
                "Se adaugă merele rase și se încorporează." +
                "Aluatul obținut se lasă la odihnit 10 minute, după care se pregătesc clătitele." +
                "Poftă bună !");
        Utilizator u2 = new Utilizator("Marius",20,"Bomboane din chec de post","1 cană zahăr," +
                "200 gr margarina topită," +
                "2 plicuri zahăr vanilat," +
                "1 plic praf de copt," +
                "1 praf sare," +
                "3 linguri cacao," +
                "150 gr dulceaţă de cireșe","Într-un vas se adaugă : margarină, dulceață, zahărul, apa, zahărul vanilat, praful de copt, sare. Se amestecă energic cca 1 min apoi se adaugă făina amestecată cu cacao. Se amestecă până se încorporează și obținem o compoziție omogenă. Se tapetează o tavă de cozonac cu hârtie de copt, se adaugă compoziția obținută și se introduce în cuptorul încălzit la 160 grade C și se lasă la copt cca 30-40 min."+
                "Și pentru ca ne-a rămas am zis să facem și bomboane." +
                "Am fărâmițat checul rămas." +
                "Am mai adăugat 1 sticluta esența de rom, 2 linguri cacao, 2 linguri dulceața și suc de portocale. Am amestecat apoi cu mâinile umede și am făcut bomboane." +
                "Poftă bună!" +
                "Mulțumesc pentru vizita și te mai aștept!");
        List<Utilizator> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        return list;
    }
}
