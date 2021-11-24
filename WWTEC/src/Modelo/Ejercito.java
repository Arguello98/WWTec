/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import javax.swing.ImageIcon;
import static java.lang.Thread.sleep;
/**
 *
 * @author tefad
 */
public abstract class Ejercito extends Thread{
    String nombre;
    String tipo;
    ImageIcon Apariencia1;
    ImageIcon Apariencia2;
    int vida;
    int golpesXtiempo;
    int nivel;
    int campos;
    int nivelAparicion;
    int costo;
    int daño=0;
    
    public abstract void Moverse();
    public abstract void Atacar();
    
    public void recibirDaño(int recibido){
        this.daño=daño+recibido;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getCosto() {
        return costo;
    }

    public void setVida(int vida) {
        this.vida = vida-daño;
    }

    public int getVida() {
        return vida;
    }

    public void setApariencia1(ImageIcon Apariencia1) {
        this.Apariencia1 = Apariencia1;
    }

    public void setApariencia2(ImageIcon Apariencia2) {
        this.Apariencia2 = Apariencia2;
    }

    public void setCampos(int campos) {
        this.campos = campos;
    }

    public int getCampos() {
        return campos;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getGolpesXtiempo() {
        return golpesXtiempo;
    }

    public void setGolpesXtiempo(int golpesXtiempo) {
        this.golpesXtiempo = golpesXtiempo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getNivelAparicion() {
        return nivelAparicion;
    }

    public void setNivelAparicion(int nivelAparicion) {
        this.nivelAparicion = nivelAparicion;
    }
    
    
}
