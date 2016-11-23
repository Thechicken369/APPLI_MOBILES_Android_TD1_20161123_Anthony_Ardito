package com.example.anthony.controle_android_aa_23112016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView afficheNom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        afficheNom = (TextView)  findViewById(R.id.textViewName);

        final ArrayList<animale> maList = new ArrayList<animale>();

        initlist(maList);

        RecyclerView rView= (RecyclerView) findViewById(R.id.recycler_view);


        //Instenciation LinearLayout Manager
        LinearLayoutManager monManager = new LinearLayoutManager(this);

        rView.setLayoutManager(monManager);

        final RecyclerViewAdapter monAdpter = new RecyclerViewAdapter(maList);

        rView.setAdapter(monAdpter);

        rView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                animale selected = (animale) maList.get(position);

                //Log.v("list perso", "Element selct : "+selected.getNom());
                afficheNom.setText(selected.getNom());

            }
        }));




    }

    public void initlist(ArrayList<animale> nList){
        animale a1 = new animale();
        a1.setNom("Baliste picasso");
        a1.setEspece("Poisson");
        a1.setDesc("Gros yeux");
        a1.setImg("baliste_picaso");
        nList.add(a1);
        animale a2= new animale();
        a2.setNom("Poisson clown");
        a2.setEspece("Poisson");
        a2.setDesc("nemo");
        a2.setImg("nemo");
        nList.add(a2);
        animale a3= new animale();
        a3.setNom("Canard");
        a3.setEspece("Oiseaux");
        a3.setDesc("Coin Coin");
        a3.setImg("canard");
        nList.add(a3);
        animale a4= new animale();
        a4.setNom("Chimpanzé");
        a4.setEspece("Mamifére");
        a4.setDesc("singe");
        a4.setImg("chimpanze");
        nList.add(a4);
        animale a5= new animale();
        a5.setNom("Coq");
        a5.setEspece("Oiseaux");
        a5.setDesc("reveil matin");
        a5.setImg("coq");
        nList.add(a5);
        animale a6= new animale();
        a6.setNom("Emeu");
        a6.setEspece("Oiseaux");
        a6.setDesc("Toufus");
        a6.setImg("emeu");
        nList.add(a6);
        animale a7= new animale();
        a7.setNom("Grenouille");
        a7.setEspece("Emphibien");
        a7.setDesc("relax");
        a7.setImg("grenouille");
        nList.add(a7);
        animale a8= new animale();
        a8.setNom("Poulet");
        a8.setEspece("Oiseaux");
        a8.setDesc("Miam...");
        a8.setImg("poulet");
        nList.add(a8);


    }

    public void clearNom(View view){
        afficheNom.setText("");
    }
}
