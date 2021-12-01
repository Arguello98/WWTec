/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Persona
 */
public class informacionEjercito implements Serializable{
    public int tipo;
    public int vida;
    public int nivelAparicion;
    public int espacioOcupado;
    public int golpesXTiempo;
    public String nombre;
    public String nombreImagen;
    public String nombreImagen2;
    
    public informacionEjercito(int tipo, int vida, int nivelAparicion,int espacioOcupado, int golpesXTiempo, String nombre, String nombreImagen, String nombreImagen2){
        this.tipo = tipo;
        this.vida = vida;
        this.espacioOcupado = espacioOcupado;
        this.nivelAparicion = nivelAparicion;
        this.golpesXTiempo = golpesXTiempo;
        this.nombre = nombre;
        this.nombreImagen = nombreImagen;
        this.nombreImagen2 = nombreImagen2;
    }
    public String imprimir(){
        String imrpimido;
        imrpimido ="|Nombre de la unidad"+ this.nombre +"|Espacio Ocupado: "+ this.espacioOcupado +"|Nivel de Aparicion "+ this.nivelAparicion + "|Imagen 1: " + nombreImagen + "|Imagen 2:" + nombreImagen2;
        
        return imrpimido;
    }
    
}
