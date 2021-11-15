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
        private List<Integer> images;

    public MeniuAdapter(List<Model> lista , List<Integer> images){
            this.lista=lista;
            this.images=images;
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
            ImageView t_imag=itemView.findViewById((R.id.poza));
            TextView t_nume = itemView.findViewById(R.id.nume);
            Model current = lista.get(position);
            t_imag.setImageResource(images.get(position));
            t_nume.setText(current.getNume());
            return itemView;
        }
        public void updateList(List<Model> list, List<Integer> images){
//            this.lista.clear();
            this.lista.addAll(list);
            this.images.addAll(images);
            notifyDataSetChanged();
        }
    }
