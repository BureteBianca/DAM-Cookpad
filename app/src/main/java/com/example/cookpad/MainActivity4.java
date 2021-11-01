package com.example.cookpad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity4 extends AppCompatActivity {


    private ListView lv;
    private MeniuAdapter meniuAdapter;
    private int[] images={R.drawable.rsz_1salam_de_bisc,R.drawable.orez_cu_lapte_budinca_de_orez,R.drawable.piept_de_pui_cu_spanac,R.drawable.piept_pui_in_fulgi_de_porumb,R.drawable.burger_cu_branza_si_oua,R.drawable.creveti_cu_gnocchi};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        meniuAdapter=new MeniuAdapter(getModele(), images);
        lv=findViewById(R.id.listView);
        lv.setAdapter(meniuAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Random rnd = new Random(2);
                int rand_int = rnd.nextInt();
                if(rand_int%2==0){
                    meniuAdapter.updateList(getModele());
                }
               else{
                   meniuAdapter.updateList(getModele2());
                }
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity4.this,meniuAdapter.getItem(position).toString(), Toast.LENGTH_LONG).show();
                return false;
            }
        });

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
    private List<Model> getModele2(){
        List<Model> lst2 = new ArrayList<>();
        lst2.add(new Model("Paste cu ton"));
        lst2.add(new Model("Tochitura moldoveneasca"));
        lst2.add(new Model("Tortilla taraneasca"));
        return lst2;
    }
}