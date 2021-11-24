/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.ModeloEjercito;
import Modelo.ModeloPueblo;
import Vista.Pantalla;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author tefad
 */
public class Controlador{
    private Pantalla vista;
    private ModeloPueblo modeloP;
    private ModeloEjercito modeloE;
    public Controlador(Pantalla vista, ModeloPueblo modeloP, ModeloEjercito modeloE) {
        this.vista = vista;
        this.modeloP = modeloP;
        this.modeloE = modeloE;  
        modeloP.colocarAyuntamiento(vista);
        modeloP.colocarMuros(vista);
        modeloP.colocarDefensas(vista);
        modeloP.iniciarDestruccion(vista);
        //modeloP.porcentajeDestruccion(vista);
        //modeloP.matriz();
    }
}
