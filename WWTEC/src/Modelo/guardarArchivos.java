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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Persona
 */
public class guardarArchivos implements Serializable {
    public int nivel;
    public int [] listax;
    public int [] listax2;
    public int [] listay;
    public int [] listay2;
    public int [] tipos;
    
    guardarArchivos(int nivel, int []listax,int[]listax2,int []listay, int []listay2, int []tipos){
        this.nivel = nivel;
        this.listax = listax;
        this.listax2 = listax2;
        this.listay = listay;
        this.listay2 = listay2;
        this.tipos = tipos;
    }
    
    
    
}
