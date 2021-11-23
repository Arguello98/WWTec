/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtec;

import Controlador.Controlador;
//import Modelo.Estructuras;
import Modelo.ModeloEjercito;
import Modelo.ModeloPueblo;
import Vista.Pantalla;

/**
 *
 * @author tefad
 */
public class WWTEC {

    public static void main(String[] args) {
        Pantalla vista = new Pantalla();
        ModeloEjercito modeloE = new ModeloEjercito();
        //Estructuras estructuras = new Estructuras();
        ModeloPueblo modeloP = new ModeloPueblo();
        Controlador controlador = new Controlador(vista, modeloP, modeloE);
        vista.setVisible(true);
    }
    
}