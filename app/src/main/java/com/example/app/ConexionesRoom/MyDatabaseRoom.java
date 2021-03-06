package com.example.app.ConexionesRoom;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserRoom.class,FichajeRoom.class}, version = 1, exportSchema = false)
public abstract class MyDatabaseRoom extends RoomDatabase {

    public abstract UtilidadesDao utilidadesDao();

    public  abstract UtilidadesDaoFichajes utilidadesDaoFichajes();
}
