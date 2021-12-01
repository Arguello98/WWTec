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
import Modelo.OperacionesGuardado;
import Modelo.guardarArchivos;
import Vista.Compra;
import Vista.Config;
import Vista.Pantalla;
import Vista.Pantalla_Principal;
import javax.swing.JOptionPane;

/**
 *
 * @author tefad
 */
public class WWTEC {
    private static Pantalla vista;
    private static Controlador controlador;
    private static Pantalla_Principal pantallaP;
    private static Compra tienda;
    private static Config config;
    
    
    public static void abrirPantallaPrincipal(){
        pantallaP.setVisible(true);
        pantallaP.colocarNombre();
    }
    
    public static void iniciarPartida(int [] unidades){
        controlador.iniciar(unidades);
        vista.setVisible(true);
    }
    
    public static void abrirTienda(){
        tienda.abrirTienda();
        tienda.setVisible(true);
    }
    
    public static void abrirConfig(){
        config.setVisible(true);
    }
    
    public void pasarDeNivel(int nivel){
        
    }
    
    public static void main(String[] args) {
        String persona = JOptionPane.showInputDialog("ingrese el nombre de usuario");
        guardarArchivos informacion = OperacionesGuardado.leer(persona);
        
        if(informacion == null){
            informacion = new guardarArchivos(persona);
        }
        vista = new Pantalla();
        tienda = new Compra(informacion);
        pantallaP = new Pantalla_Principal(informacion);
        config = new Config(informacion);
        
        
        ModeloEjercito modeloE = new ModeloEjercito();
        ModeloPueblo modeloP = new ModeloPueblo();
        controlador = new Controlador(vista, modeloP, modeloE, informacion);
        abrirPantallaPrincipal();
    }
    
}