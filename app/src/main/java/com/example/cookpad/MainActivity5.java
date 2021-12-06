package com.example.cookpad;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {
    private UtilizatorDAO utilizatorDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        utilizatorDAO = Database.getInstance(this).getDataBase().utilizatorDAO();

        List<Utilizator> lista = getUtilizator();
        for(int i=0;i<lista.size();i++){
            utilizatorDAO.insert(lista.get(i));
        }

        List<Utilizator> rezultat = utilizatorDAO.getUtilizatorVarstaHigher(14);
        Log.v("varsta>", rezultat.toString());
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