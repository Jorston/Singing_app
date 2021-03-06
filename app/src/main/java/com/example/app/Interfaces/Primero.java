package com.example.app.Interfaces;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.room.Room;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.app.ConexionPSQL.ConexionPsql;
import com.example.app.ConexionesRoom.MetodosRoom;
import com.example.app.ConexionesRoom.MyDatabaseRoom;
import com.example.app.R;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Primero extends Fragment {
    //declaracion variables globales
    private OnFragmentInteractionListener mListener;

    ImageButton botonEntrada,botonSalida;

    View vista;

    TextView textUsuario,textFecha;

    //declaramos variables para usarlas en el contexto
    String recuperamos_variable_string,fechaComoCadena,horaComoCadena;

    public static MyDatabaseRoom myDatabaseRoom;

    final MetodosRoom metodosRoom = new MetodosRoom();

    public Primero() {
        // Required empty public constructor

    }

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //construccion de formateo de fecha
        final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        final SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

        fechaComoCadena = sdf.format(new Date());

        horaComoCadena = hourFormat.format(new Date());

        //recuperacion de dato enviado por activity Main
        recuperamos_variable_string = getActivity().getIntent().getStringExtra("usuario");

        //variables para setear por el id
        vista = inflater.inflate(R.layout.fragment_primero, container, false);

        textUsuario = vista.findViewById(R.id.textUsuario);

        textUsuario.setText(recuperamos_variable_string);

        textFecha = vista.findViewById(R.id.textFecha);

        textFecha.setText(fechaComoCadena);

        botonEntrada = vista.findViewById(R.id.btnEntrada);

        botonSalida = vista.findViewById(R.id.btnSalida);

        //boton ejecuta el metodo para captura fichaje entrada
        botonEntrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


             //instacia de postgres
             final hiloRegisterHoras hilos = new hiloRegisterHoras(fechaComoCadena,horaComoCadena,"entrada",recuperamos_variable_string);

             hilos.execute();


            //metodo para insertar en BD con Room instancia a la conexion y objetos de la clase MyDatabaseRoom de Room y creamos la base de datos
            myDatabaseRoom = Room.databaseBuilder(getActivity().getApplicationContext(),MyDatabaseRoom.class, "usuariosLoginRoom.db").allowMainThreadQueries().build();

            metodosRoom.insertarFichajes(recuperamos_variable_string,fechaComoCadena,horaComoCadena,"entrada");

            showMessage("fichaje Room introducido correctamente en la BD");

            myDatabaseRoom.close();

            }
        });

        //boton ejecuta el metodo para captura fichaje salida
        botonSalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            //instacia de postgres
            final hiloRegisterHoras hilos = new hiloRegisterHoras( fechaComoCadena,horaComoCadena,"salida",recuperamos_variable_string);

            hilos.execute();

            //metodo para insertar en BD con Room instancia a la conexion y objetos de la clase MyDatabaseRoom de Room y creamos la base de datos
            myDatabaseRoom = Room.databaseBuilder(getActivity().getApplicationContext(),MyDatabaseRoom.class, "usuariosLoginRoom.db").allowMainThreadQueries().build();

            metodosRoom.insertarFichajes(recuperamos_variable_string,fechaComoCadena,horaComoCadena,"salida");

            showMessage("fichaje Room introducido correctamente en la BD");

            myDatabaseRoom.close();

            }
        });

        return vista;
    }

    //clase multitarea
    public class hiloRegisterHoras extends AsyncTask<String,Void,String> {

        private final String fechaActual;

        private final String horaActual;

        private final String tipoFichajeActual;

        private final String usuarioActual;

        public hiloRegisterHoras(String fechaActual, String horaActual, String tipoFichajeActual, String usuarioActual) {

            this.fechaActual = fechaActual;

            this.horaActual = horaActual;

            this.tipoFichajeActual = tipoFichajeActual;

            this.usuarioActual = usuarioActual;
        }

        @Override
        protected String doInBackground(String... strings) {
            //conexion para PSQL Instanciamos objetos
            ConexionPsql conexionPsql = new ConexionPsql();

            Connection con = null;

            con = conexionPsql.conectar();

            //si coneccion insertamos en PSQL
            if (con != null) {
                try{

                    String inserFichajeTabla = "insert into fichajesPostSQL(diafichaje,horafichaje,tipofichaje,usuarioNick) values (?,?,?,?);";

                    PreparedStatement insertFichaje;

                    insertFichaje = con.prepareStatement(inserFichajeTabla);

                    insertFichaje.setString(1, fechaActual);

                    insertFichaje.setString(2, horaActual);

                    insertFichaje.setString(3,tipoFichajeActual);

                    insertFichaje.setString(4,recuperamos_variable_string);

                    insertFichaje.executeUpdate();

                } catch (Exception e) {

                    System.out.println("error al insertar el marcaje en la tabla");

                    e.printStackTrace();
                }

            }else{



            }
            return null;
        }
    }

    //metodo atajo para el toast vista usuario
    protected void showMessage(String message){

        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

