package com.example.app.ConexionMetodosFirebase;

import androidx.annotation.NonNull;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class LoginFirebaseDepart {

    DatabaseReference mRootReference;

    String valorDepartTemporal ,usuarioPorDepart;

    ArrayList<AdminDepartDetalles> listadoDetallesDepartamentos;

    String valor;

    String acumulador;

    int contador;

    public void ValidacionDepart(String datoEnviado){

        acumulador = datoEnviado;

        mRootReference = FirebaseDatabase.getInstance().getReference();

        mRootReference.child("Departamentos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                lecturaDepartamentos(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private String lecturaDepartamentos(DataSnapshot dataSnapshot) {

        for (final  DataSnapshot snapshot : dataSnapshot.getChildren()){
            mRootReference.child("Departamentos").child(snapshot.getKey()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    valorDepartTemporal = dataSnapshot.getKey();

                    datosUsuarioporDepart(valorDepartTemporal);

                   //System.out.println("LOS DEPARTAMENTOS SON "+ acumulador);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }

        return valorDepartTemporal;
    }

    ////lisener de los datos que estan en firebase
    //        mRootReference.child("Departamentos").child(valorEnviado).addValueEventListener(new ValueEventListener() {

    private void datosUsuarioporDepart(final String valorDepartTemporal){

        mRootReference.child("Departamentos").child(valorDepartTemporal).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                valor = valorDepartTemporal;

                obtencionDatosUserDepart(dataSnapshot,valor);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



    private int obtencionDatosUserDepart(DataSnapshot dataSnapshot,String valor){


        listadoDetallesDepartamentos = new ArrayList<AdminDepartDetalles>();

        for(final DataSnapshot snapshot : dataSnapshot.getChildren()){


            mRootReference.child(valor).child(snapshot.getKey()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    AdminDepartDetalles adminDepartDetallesFirebase = snapshot.getValue(AdminDepartDetalles.class);

                    System.out.println("EL DATO ENVIADO ES "+acumulador);

                    System.out.println(adminDepartDetallesFirebase.getNombre());

                    if (adminDepartDetallesFirebase.getNombre().equals(acumulador)){

                        contador++;
                        System.out.println("EL CONTADOR VA EN "+contador);

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        return contador;
    }

}
