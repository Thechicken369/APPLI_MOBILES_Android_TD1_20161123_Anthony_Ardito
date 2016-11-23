package com.example.anthony.controle_android_aa_23112016;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by anthony on 16/11/2016.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private  ArrayList<animale> animalsList;

    private Resources res;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //Instentiation des donné de linterface de chaque element de la liste
        public TextView nom;
        public TextView espece;
        public ImageView image;
        public TextView desc;
        public CardView cardview;

        //Constructeur du ViewHolder
        public ViewHolder(View view) {
            super(view);
            nom = (TextView) view.findViewById(R.id.textVewName);
            espece = (TextView) view.findViewById(R.id.textView_espece);
            image = (ImageView) view.findViewById(R.id.imageView_animal);
            desc = (TextView) view.findViewById(R.id.textView_descripton);
            cardview = (CardView) view.findViewById(R.id.Cardview_pla);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Récuperation des ressources pour les image
        this.res = parent.getContext().getResources();
        //ainsi que du context
        this.context = parent.getContext();

        //j'ai pas compris
        View v = LayoutInflater.from(context).inflate(R.layout.list_element,parent,false);

        //Création du viewHolder
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final animale monAnimale = animalsList.get(position);
        holder.cardview.setRadius(32);
        holder.nom.setText(monAnimale.getNom());
        holder.desc.setText(monAnimale.getDesc());

        holder.espece.setText(monAnimale.getEspece());
        holder.image.setImageResource(res.getIdentifier(monAnimale.getImg() , "drawable", context.getPackageName()));
    }

    //Constructeur de la classe RecyclerViewAdapter
    public RecyclerViewAdapter(ArrayList<animale> ani)
    {
        animalsList = ani;
    }

    //Fonction qui retourne la taille de mon "DataSet"
    @Override
    public int getItemCount() {
        return animalsList.size();
    }






}