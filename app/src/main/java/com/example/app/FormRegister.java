package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.data.ConexionSQLiteHelper;
import com.example.app.data.Escrituras;
import com.example.app.data.UtilidadesDB;

import java.io.IOException;

import static java.security.AccessController.getContext;

public class FormRegister extends AppCompatActivity {
    Escrituras escrituras = new Escrituras();
    Button buton,btnInsert;
    TextView nombre,apellidos,correo,userNick,contrasenha,repContrasenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_register);
        nombre = findViewById(R.id.textnombre);
        apellidos = findViewById(R.id.textapellido);
        userNick = findViewById(R.id.userNick);
        correo = findViewById(R.id.userCorreo);
        contrasenha = findViewById(R.id.textcontrasenha);
        repContrasenha = findViewById(R.id.textRepContrasenha);
        buton = findViewById(R.id.btnFormRegister);
        btnInsert = findViewById(R.id.btnBaseDatos);
        escrituras.setContext(this);
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //accion serializacion
                try {
                    escrituras.serializadionOuput(nombre.getText().toString(),apellidos.getText().toString(),userNick.getText().toString(),correo.getText().toString(),contrasenha.getText().toString(),repContrasenha.getText().toString());
                    showMessage("Usuario Serializado");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConexionSQLiteHelper helper = new ConexionSQLiteHelper(getApplicationContext());
                helper.abrir();
                helper.insertar(nombre.getText().toString(),apellidos.getText().toString(),correo.getText().toString(),userNick.getText().toString(),contrasenha.getText().toString(),repContrasenha.getText().toString());
                helper.cerrar();
                Toast.makeText(getApplicationContext(),"usuario insertado en la base de datos",Toast.LENGTH_SHORT).show();
            }
        });
    }



    protected void showMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}