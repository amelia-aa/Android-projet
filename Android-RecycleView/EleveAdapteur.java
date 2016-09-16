package com.example.recycleviewmodule;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DEV on 15/09/2016.
 */
public class EleveAdapteur extends RecyclerView.Adapter<EleveAdapteur.ViewHolder> {

    private ArrayList<EleveBean> eleveBeanList;

    //Constructeur
    public EleveAdapteur(ArrayList<EleveBean> eleveBeanList) {
        this.eleveBeanList = eleveBeanList;
    }

    //Classe qui stocke les composants graphiques d'1 ligne
    protected static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_nom, tv_prenom;
        // public ImageView ec_iv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_nom = (TextView) itemView.findViewById(R.id.nom);
            tv_prenom = (TextView) itemView.findViewById(R.id.prenom);
            // ec_iv = (ImageView) itemView.findViewById(R.id.ec_iv);
        }
    }

    //Détermine quel fichier XML on utilise pour représanter une cellule
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cellule_eleve, parent, false);
        return new EleveAdapteur.ViewHolder(v);
    }

    //Remplir les composants graphique de chaque cellule
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //L'élève correspondant à la ligne
        EleveBean eleve = eleveBeanList.get(position);
        holder.tv_nom.setText(eleve.getNom());
        holder.tv_prenom.setText(eleve.getPrenom());
    }

    //Combien de cellule on affiche
    @Override
    public int getItemCount() {
        return eleveBeanList.size();
    }
}