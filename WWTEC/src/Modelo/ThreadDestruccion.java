/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controlador;
import Vista.Pantalla;
import static java.lang.Thread.sleep;
import javax.swing.JOptionPane;
import wwtec.WWTEC;

public class ThreadDestruccion extends Thread{
    
    private boolean isRunning = true;
    private int total;
    private ModeloPueblo pueblo;
    private Pantalla vista;
    private double porcentaje;
    private int totalEstructuras;
    private Controlador jugador;
    private ModeloEjercito ejercito;
    private WWTEC inicio;

    public ThreadDestruccion(ModeloPueblo pueblo, Pantalla vista, Controlador jugador, ModeloEjercito ejercito) {
        this.pueblo = pueblo;
        this.vista = vista;
        this.jugador = jugador;
        this.ejercito = ejercito;
        totalEstructuras = pueblo.getCantidadDefensas()+(pueblo.getNivel()-1) + 56 + 1;
    }
    
    public void run(){
        while(isRunning){
            try {
                sleep(1000);
                System.out.println(ejercito.getSoldadosTotales());
                System.out.println(ejercito.getContador());
                int soldadosVivos = 0;
                for (int i = 0; i < 21; i++) {
                    for (int j = 0; j < 21; j++) {
                        if (ejercito.getMatrizEjercito()[i][j]!=null && ejercito.getMatrizEjercito()[i][j].getVida()>0) {
                            soldadosVivos+=1;
                        }
                    }
                }
                //System.out.println(soldadosVivos+"--shdkjshdkjhskjdhkjshdkjkjhskjfgfghfghfghfghfgh");
                if (total>=1000 || total == totalEstructuras) {//destruyo el ayuntamiento
                    JOptionPane.showMessageDialog(vista, "Felicidades", "Pueblo Destruido al 100%", JOptionPane.INFORMATION_MESSAGE);
                    pueblo.getLblPorcentage().setText("Destrucción total: " + 100.0);
                    reiniciarEjercito();
                    reiniciarPueblo();
                    //inicio.pasarDeNivel(pueblo.getNivel()+1);
                    //jugador.iniciarJuego(pueblo.getNivel()+1);
                    stop();
                }else{//obtiene el porcentaje de destruccion
                    porcentaje = total*100/totalEstructuras;
                    pueblo.setPorcentaje(porcentaje);
                    pueblo.getLblPorcentage().setText("Destrucción total: " + porcentaje);
                }
                if (ejercito.getSoldadosTotales()==ejercito.getContador() && porcentaje>50) {
                    JOptionPane.showMessageDialog(vista, "Felicidades", "Pueblo Destruido al 50%", JOptionPane.INFORMATION_MESSAGE);
                    reiniciarEjercito();
                    reiniciarPueblo();
                    //jugador.iniciarJuego(pueblo.getNivel()+1);
                    stop();
                }else if(ejercito.getSoldadosTotales()==ejercito.getContador() && porcentaje<50){
                    JOptionPane.showMessageDialog(vista, "Fin del juego", "No se destruyo el 50% del pueblo", JOptionPane.INFORMATION_MESSAGE);
                    reiniciarEjercito();
                    reiniciarPueblo();
                    stop();
                }
            } 
            catch (InterruptedException ex) {} 
        }
    }

    public void reiniciarPueblo(){
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                if (pueblo.getMatrizPueblo()[i][j]!=null) {
                    pueblo.getMatrizPueblo()[i][j].getThreadEstructuras().stop();
                    pueblo.getMatrizPueblo()[i][j].getPnlEstructura().setVisible(false);
                    pueblo.getMatrizPueblo()[i][j]=null;
                    pueblo.setPorcentaje(0.0);
                    pueblo.getLblPorcentage().setText("Destrucción total: " + 0.0);
                }
            }
        }
    }
    
    public void reiniciarEjercito(){
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                try {
                    ejercito.setSoldadosTotales(0);
                    ejercito.setContador(0);
                    ejercito.getMatrizEjercito()[i][j].stop();
                    ejercito.getMatrizEjercito()[i][j].getPnlEjercito().setVisible(false);
                    ejercito.getMatrizEjercito()[i][j]=null;
                } catch (Exception e) {
                }
                /*if (ejercito.getMatrizEjercito()[i][j]!=null) {
                    ejercito.getMatrizEjercito()[i][j].stop();
                    ejercito.getMatrizEjercito()[i][j].getPnlEjercito().setVisible(false);
                    ejercito.getMatrizEjercito()[i][j]=null;
                }*/
            }
        }
    }
    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
