package com.example.cookpad;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MeniuAdapter extends BaseAdapter {

        private List<Model> lista;

    public MeniuAdapter(List<Model> lista){
            this.lista=lista;
        }
        @Override
        public int getCount() {
            return lista.size();
        }

        @Override
        public Model getItem(int position) {
            return lista.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater infl= LayoutInflater.from(parent.getContext());
            View itemView= infl.inflate(R.layout.activity_meniu_adapter,parent,false);
            TextView t_nume = itemView.findViewById(R.id.nume);
            TextView t_ingrediente = itemView.findViewById(R.id.ingrediente);
            TextView t_reteta = itemView.findViewById(R.id.reteta);
            Model current = lista.get(position);
            t_nume.setText(current.getNume());
            t_ingrediente.setText(current.getIngrediente());
            t_reteta.setText(current.getReteta());
            return itemView;
        }
        public void updateList(List<Model> list){
            this.lista.clear();
            this.lista.addAll(list);
            notifyDataSetChanged();
        }
    }
