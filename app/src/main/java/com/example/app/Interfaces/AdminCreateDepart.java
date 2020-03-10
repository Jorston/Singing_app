package com.example.app.Interfaces;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.app.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class AdminCreateDepart extends Fragment {

    DatabaseReference mRootReference;

    Button btnGuardarDepart;

    TextView textoDepartamento;

    public AdminCreateDepart() {
        // Required empty public constructor
    }

    public static AdminCreateDepart newInstance(String param1, String param2) {
        AdminCreateDepart fragment = new AdminCreateDepart();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_admin_create_depart, container, false);

        textoDepartamento = vista.findViewById(R.id.txtDepart);

        mRootReference = FirebaseDatabase.getInstance().getReference();

        btnGuardarDepart = vista.findViewById(R.id.btndepartfirebase);

        btnGuardarDepart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                crearDepartamento();
            }
        });





        return vista;
    }

    private void crearDepartamento() {

        String parte = textoDepartamento.getText().toString();

        Map<String, Object> datosDepart = new HashMap<>();

       datosDepart.put("nombre","hola mundo");

        mRootReference.child("Departamentoooos").child(parte).push().setValue(datosDepart);
    }
}