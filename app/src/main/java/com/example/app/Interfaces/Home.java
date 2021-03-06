package com.example.app.Interfaces;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.app.R;

public class Home extends AppCompatActivity implements View.OnClickListener, Primero.OnFragmentInteractionListener, Segundo.OnFragmentInteractionListener, Tercero.OnFragmentInteractionListener,TerceroA.OnFragmentInteractionListener, Cuarto.OnFragmentInteractionListener, Quinto.OnFragmentInteractionListener{

    Button boton1,boton2,boton3,boton4,boton5,boton6;

    String recuperamos_variable_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if(getSupportActionBar() != null)

            getSupportActionBar().hide();

        setContentView(R.layout.activity_home);

        recuperamos_variable_string = getIntent().getStringExtra("usuario");

        Bundle bundle = new Bundle();

        Intent intent = new Intent(getApplicationContext(), Primero.class);

        bundle.putString("usuarioLogin",recuperamos_variable_string);

        intent.putExtras(bundle);

        boton1 = findViewById(R.id.btn1);

        boton2 = findViewById(R.id.btn2);

        boton3 = findViewById(R.id.btn3);

        boton4 = findViewById(R.id.btn4);

        boton5 = findViewById(R.id.btn5);

        boton6 = findViewById(R.id.btn6);

        boton1.setOnClickListener(this);

        boton2.setOnClickListener(this);

        boton3.setOnClickListener(this);

        boton4.setOnClickListener(this);

        boton5.setOnClickListener(this);

        boton6.setOnClickListener(this);

        boton1.setBackgroundColor(Color.parseColor("#cfcfcf"));
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:

                cambioColor("boton1");

                MainActivity.media.stop();

                Fragment primero = new Primero();

                FragmentTransaction transactionuno = getSupportFragmentManager().beginTransaction();

                transactionuno.replace(R.id.contenedor_general,primero);

                transactionuno.commit();

                break;

            case R.id.btn2:
                cambioColor("boton2");

                MainActivity.media.stop();

                Fragment segundo = new Segundo();

                FragmentTransaction transactiondos = getSupportFragmentManager().beginTransaction();

                transactiondos.replace(R.id.contenedor_general,segundo);

                transactiondos.commit();

                break;

            case R.id.btn3:
                cambioColor("boton3");

                //Fragment tercero = new Tercero();

                MainActivity.media.stop();

                //Fragment terceroA = new TerceroA();

                //FragmentTransaction transactiontres = getSupportFragmentManager().beginTransaction();

                //transactiontres.replace(R.id.contenedor_general,tercero);

                Fragment cuartos = new Cuarto();

                FragmentTransaction transactiontres = getSupportFragmentManager().beginTransaction();

                transactiontres.replace(R.id.contenedor_general,cuartos);

                transactiontres.commit();

                break;

            case R.id.btn4:
                cambioColor("boton4");

                //Fragment cuarto = new Cuarto();

                MainActivity.media.stop();

                Fragment cuarto = new FragmentPerfilUser();

                FragmentTransaction transactioncuatro = getSupportFragmentManager().beginTransaction();

                transactioncuatro.replace(R.id.contenedor_general,cuarto);

                transactioncuatro.commit();

                break;

            case R.id.btn5:
                cambioColor("boton5");

                Fragment quinto = new Quinto();

                FragmentTransaction transactioncinco = getSupportFragmentManager().beginTransaction();

                transactioncinco.replace(R.id.contenedor_general,quinto);

                transactioncinco.commit();

                break;

            case R.id.btn6:
                cambioColor("boton6");

                /*Fragment sexto = new Sexto();

                FragmentTransaction transactionsexto = getSupportFragmentManager().beginTransaction();

                transactionsexto.replace(R.id.contenedor_general,sexto);

                transactionsexto.commit();*/

                break;
        }
    }

    public void cambioColor(String cambio){

        switch (cambio){
            case"boton1":
                boton1.setBackgroundColor(Color.parseColor("#cfcfcf"));
                boton3.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton2.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton4.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton5.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton6.setBackgroundColor(Color.parseColor("#f5f5f5"));
                break;

            case"boton2":
                boton1.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton2.setBackgroundColor(Color.parseColor("#cfcfcf"));
                boton3.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton4.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton5.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton6.setBackgroundColor(Color.parseColor("#f5f5f5"));
                break;

            case"boton3":
                boton1.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton2.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton3.setBackgroundColor(Color.parseColor("#cfcfcf"));
                boton4.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton5.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton6.setBackgroundColor(Color.parseColor("#f5f5f5"));

                break;

            case"boton4":
                boton1.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton2.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton3.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton4.setBackgroundColor(Color.parseColor("#cfcfcf"));
                boton5.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton6.setBackgroundColor(Color.parseColor("#f5f5f5"));
                break;

            case"boton5":
                boton1.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton2.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton3.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton4.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton5.setBackgroundColor(Color.parseColor("#cfcfcf"));
                boton6.setBackgroundColor(Color.parseColor("#f5f5f5"));
                break;

            case"boton6":
                boton1.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton2.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton3.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton4.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton5.setBackgroundColor(Color.parseColor("#f5f5f5"));
                boton6.setBackgroundColor(Color.parseColor("#cfcfcf"));
                break;
        }
    }
}
