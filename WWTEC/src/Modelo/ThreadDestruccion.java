/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Pantalla;
import javax.swing.JOptionPane;

public class ThreadDestruccion extends Thread{
    
    private boolean isRunning = true;
    private int total;
    private ModeloPueblo pueblo;
    private Pantalla vista;
    private double porcentaje;
    private int totalEstructuras;

    public ThreadDestruccion(ModeloPueblo pueblo, Pantalla vista) {
        this.pueblo = pueblo;
        this.vista = vista;
        totalEstructuras = pueblo.getCantidadDefensas()+(pueblo.getNivel()-1) + 56 + 1;
    }
    
    public void run(){
        while(isRunning){
            try {
                sleep(1000);
                if (total==1000 || total == totalEstructuras) {//destruyo el ayuntamiento
                    JOptionPane.showMessageDialog(vista, "Felicidades", "Pueblo Destruido", JOptionPane.INFORMATION_MESSAGE);
                }else{//obtiene el porcentaje de destruccion
                    porcentaje = total*100/totalEstructuras;
                    pueblo.setPorcentaje(porcentaje);
                }
                //falta el caso se queda sin soldados pero destruyo el 50% y el caso se queda sin soldados y no destruyo el 50%
            } 
            catch (InterruptedException ex) {} 
        }
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
