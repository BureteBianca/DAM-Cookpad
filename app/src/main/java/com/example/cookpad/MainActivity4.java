package com.example.cookpad;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {


    private ListView lv;
    private MeniuAdapter meniuAdapter;
    private List<Integer> images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        images = new ArrayList<>();
        images.add(R.drawable.rsz_1salam_de_bisc);
        images.add(R.drawable.orez_cu_lapte_budinca_de_orez);
        images.add(R.drawable.piept_de_pui_cu_spanac);
        images.add(R.drawable.piept_pui_in_fulgi_de_porumb);
        images.add(R.drawable.burger_cu_branza_si_oua);
        images.add(R.drawable.creveti_cu_gnocchi);

        List<Integer> imag;
        imag=new ArrayList<>();
        imag.add(R.drawable.negresa_cu_glazura);
        imag.add(R.drawable.rulouri_cu_bacon);
        imag.add(R.drawable.placinta_cu_carne_si_foietaj);
        imag.add(R.drawable.ciorba_de_conopida);
        imag.add(R.drawable.strudel_cu_mere);
        imag.add(R.drawable.reteta_de_chec_cu_lamaie);

        meniuAdapter = new MeniuAdapter(getModele(), images);
        lv = findViewById(R.id.listView);
        lv.setAdapter(meniuAdapter);

        // lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        //   @Override
        // public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //   Random rnd = new Random(2);
        //   int rand_int = rnd.nextInt();
        // if(rand_int%2==0){
        //  meniuAdapter.updateList(getModele());
        // }
        // else{
        // meniuAdapter.updateList(getModele2());
        // }
        // }
        //  });
        // lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        //  @Override
        // public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        //  Toast.makeText(MainActivity4.this,meniuAdapter.getItem(position).toString(), Toast.LENGTH_LONG).show();
        //  return false;
        // }
        // });

        JSONReader reader = new JSONReader();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                reader.read("https://jsonkeeper.com/b/BYEX", new IResponse() {
                    @Override
                    public void onSuccess(List<Model> preparat) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
//                               Toast.makeText(MainActivity4.this, preparat.toString(), Toast.LENGTH_SHORT).show();
                                meniuAdapter.updateList(preparat,imag);
                            }
                        });
                    }

                    @Override
                    public void onError(String mesaj) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity4.this, mesaj, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

            }
        });
        thread.start();

    }
    private List<Model> getModele(){
        List<Model> lst = new ArrayList<>();
        lst.add(new Model("Salam de biscuiti"));
        lst.add(new Model("Budinca de orez cu lapte"));
        lst.add(new Model("Piept de pui cu spanac"));
        lst.add(new Model("Piept pui in fulgi de porumb"));
        lst.add(new Model("Burger cu branza si oua"));
        lst.add(new Model("Creveti cu gnocchi"));
        return lst;
    }
    //private List<Model> getModele2(){
    //  List<Model> lst2 = new ArrayList<>();
    // lst2.add(new Model("Paste cu ton"));
    // lst2.add(new Model("Tochitura moldoveneasca"));
    // lst2.add(new Model("Tortilla taraneasca"));
    // return lst2;
    // }
}