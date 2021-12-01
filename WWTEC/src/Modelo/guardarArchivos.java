/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Persona
 */
public class guardarArchivos implements Serializable {
    public int nivel;
    public String nombreJugador;
    public int dinero;
    public int [] listax= null;
    public int [] listax2 = null;
    public int [] listay = null;
    public int [] listay2 = null;
    public int [] tipos = null;
    public ArrayList<informacionEjercito> informacion;
    
    public guardarArchivos(String nombreJugador){
        this.nombreJugador = nombreJugador;
        this.nivel = 1;
        this.dinero = 1000;
        this.informacion = new ArrayList();
        this.informacion.add(new informacionEjercito(0,4,1,2,2,"Samurai","samuraicaminando.png","samuraiatacando.png"));
        this.informacion.add(new informacionEjercito(1,5,1,3,2,"Francotirador","mediocaminando.jpg","medioatacando.jpg"));
    }
    
    public guardarArchivos(int nivel, int []listax,int[]listax2,int []listay, int []listay2, int []tipos){
        this.nivel = nivel;
        this.listax = listax;
        this.listax2 = listax2;
        this.listay = listay;
        this.listay2 = listay2;
        this.tipos = tipos;
    }
    
    
    
}
