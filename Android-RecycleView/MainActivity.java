package com.example.recycleviewmodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // Composant Graphique
    private Button button_ajouter;
    private RecyclerView rv;
    // adapteur
    private EleveAdapteur eleveAdapteur;
    // Données
    private ArrayList<EleveBean> eleveList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // instanciation
        eleveList = new ArrayList<>();
        eleveAdapteur = new EleveAdapteur(eleveList);

        //Composant graphique
        button_ajouter = (Button) findViewById(R.id.button_ajouter);
        rv = (RecyclerView) findViewById(R.id.rv);

        button_ajouter.setOnClickListener(this);

        // L’adapter que l’on souhaite afficher
        rv.setAdapter(eleveAdapteur);

        //Réglage : Est ce qu'on affiche ligne par ligne ou
        rv.setLayoutManager(new LinearLayoutManager(this));
        //new GridLayoutManager(this, 2) //Sous forme de tableau à 2 colonnes

        //Réglage : type d’animation qu’on utilise
        rv.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onClick(View v) {
        // ajout d'un toast
        //Toast.makeText(this, "Ceci est un Toast", Toast.LENGTH_LONG).show();

        // Creation  d'un eleve
        EleveBean eleveBean = new EleveBean("Andre", "amel");
        eleveList.add(0, eleveBean);
        //Indiquer que ma source de donnée à changé et qu'il faut rafraichir
        //eleveAdapteur.notifyDataSetChanged();

        //Si on sait ce qui a changé, on l'indique pour une animation d'insertion d'in serer à la fin
        //eleveAdapteur.notifyItemInserted(eleveList.size() - 1);

        // ajout au début
        eleveAdapteur.notifyItemInserted(0);
    }
}
