package com.example.app.data;

import android.content.Context;
import com.example.app.Modelos.MformRegister;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Escrituras {
    private Context context;
    private String fileName = "NuevoArchivo.txt";
    String nombre,apellidos,correos,userNick,contra,repContra;
    public void setContext(Context context) {
        this.context = context;
    }
    public void serializadionOuput(ArrayList<MformRegister> listadoRegistros) throws  IOException{
        try{
            MformRegister persona = new MformRegister(nombre,apellidos,correos,userNick,contra,repContra);
            listadoRegistros.add(persona);
            FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_APPEND);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(listadoRegistros);
            System.out.println("escritura correcta");
            os.close();
            fos.close();
        }catch (Exception e) {
            System.out.println("no se pudo escribir");
            e.printStackTrace();
        }
    }

    public void lecturaArchivo(String userNick,String contrasenha)  {
        try{
            ObjectInputStream lectura = new ObjectInputStream(new FileInputStream("/data/data/com.example.app/files/"+fileName));
            ArrayList<MformRegister> listadoRegistros = (ArrayList<MformRegister>) lectura.readObject();
            for (MformRegister list : listadoRegistros){
                System.out.println("el usuario es:" +list.getUserNick()+" "+list.getContrasenha());
            }
        System.out.println("ARCHIVOOOOOOOOOO LIEDOOOOOOOOOOOOO");
        lectura.close();
        } catch(FileNotFoundException e) {
            System.out.println("error 1");
        }catch (ClassNotFoundException e) {
            System.out.println("error 2");
        } catch (IOException e) {
            System.out.println("error 3");
        }
    }
}
