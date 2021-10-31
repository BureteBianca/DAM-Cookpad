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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        meniuAdapter=new MeniuAdapter(getModele());
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
        lst.add(new Model("Salam de biscuiti","Ingrediente:", "250gr biscuiti" +'\n'+"200gr ciocolata neagra"+'\n'+"50gr unt"+'\n'+"100gr lapte"));
        lst.add(new Model("Budinca de orez cu lapte","Ingrediente:","500 ml lapte" +'\n'+"2 oua"+'\n'+"100gr orez"+'\n'+"2 linguri zahar"+'\n'+"1 plic zahar vanilat"+'\n'+"coaja de lamaie"));
        lst.add(new Model("Piept de pui cu spanac","Ingrediente:","300g piept de pui"+'\n'+"700g spanac"+'\n'+"60g seminte pin"+'\n'+"1 buc. unt"+'\n'+"2 linguri cu ulei"+'\n'+"2 catei de usturoi"+'\n'+"20g vin"+'\n'+"sare, piper si boia de ardei dulce"+'\n'+"1 lingurita sare groasa"));
        lst.add(new Model("Piept pui in fulgi de porumb","Ingrediente:", "10 pulpe pui" +'\n'+"500g fulgi porumb"+'\n'+"5-6 oua"+'\n'+"cat cuprinde faina"+'\n'+"3 linguri mustar"+'\n'+"3 linguri ketchup"+'\n'+"1 varf lingurita de comino"+'\n'+"1 varf lingurita oregano"+'\n'+"dupa gust sare"+'\n'+"ulei de masline"+'\n'+"dupa gust piper negru"));
        lst.add(new Model("Burger cu branza si oua","Ingrediente:", "4 burger" +'\n'+"2 oua"+'\n'+"2 felii branza topita"+'\n'+"salata"+'\n'+"1 lingura de mustar"+'\n'+"3 linguri ulei"+'\n'+"1 lingura de otet alb"+'\n'+"sare"+'\n'+"piper"));
        lst.add(new Model("Creveti cu gnocchi","Ingrediente:", "450g creveti" +'\n'+"500g gnocchi cu rosii si spanac"+'\n'+"zeama de la o jumatate de lamaie"+'\n'+"50g unt"+'\n'+"2 linguri ulei"+'\n'+"patrunjel tocat"+'\n'+"sare/piper"+'\n'+"5 catei usturoi"));
        return lst;
    }
    private List<Model> getModele2(){
        List<Model> lst2 = new ArrayList<>();
        lst2.add(new Model("Paste cu ton","Ingrediente:","1 pachet paste mici"+'\n'+" 2 cutii ton in ulei"+'\n'+"3 linguri pasta de tomate"+'\n'+" apa"+'\n'+" sare"));
       lst2.add(new Model("Tochitura moldoveneasca","Ingrediente:","300g carne porc"+'\n'+"300g sold de porc cu sorici afumat"+'\n'+"300g carne de vita"+'\n'+"4 carnati proaspeti"+'\n'+"200 ml vin alb"+'\n'+"1 lingura de sare"+'\n'+"3 catei de usturoi"+'\n'+"20 ml ulei"+'\n'+"500 ml apa"));
        lst2.add(new Model("Tortilla taraneasca","Ingrediente:","3 oua"+'\n'+"jumari"+'\n'+"sare si piper"+'\n'+"ceapa"));
        return lst2;
    }
}