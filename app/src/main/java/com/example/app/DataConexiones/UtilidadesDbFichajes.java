package com.example.app.DataConexiones;

public class UtilidadesDbFichajes {
    //constantes campos y tabla de DB Fichajes
    public static final String TABLA_FICHAJES = "db_fichajes";
    public static final String USUARIO = "usuario";
    public static final String FECHA_FICHAJE ="fechaFichaje";
    public static final String HORA_FICHAJE ="horaFichaje";
    public static final String TIPO_FICHAJE ="tipoFichaje";
    public static final String CREAR_TABLA_FICHAJES =
            "CREATE TABLE "+TABLA_FICHAJES+" ( "+USUARIO+" text,"+FECHA_FICHAJE+" text,"+HORA_FICHAJE+" text,"+TIPO_FICHAJE+" text);";
}
