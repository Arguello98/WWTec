/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Persona
 */
public class OperacionesGuardado {
    public static void guardar(String nombre, guardarArchivos guardar){
        FileOutputStream fileOutputStream= null;
        try {
            fileOutputStream = new FileOutputStream(nombre);
            ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(guardar);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("no existe");
        } catch (IOException ex) {
            Logger.getLogger(guardarArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(guardarArchivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static guardarArchivos leer(String nombre){

        guardarArchivos archivoLeido = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(nombre);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream); 
            archivoLeido= (guardarArchivos) objectInputStream.readObject();
            objectInputStream.close();
        } catch (FileNotFoundException ex) {
            archivoLeido = null;
            System.out.println("no se entcontro");
            return archivoLeido;
        } catch (IOException ex) {
            Logger.getLogger(OperacionesGuardado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OperacionesGuardado.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return archivoLeido;
    }
}
