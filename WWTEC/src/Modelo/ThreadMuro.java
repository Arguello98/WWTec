/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class ThreadMuro extends Thread{
    
    private boolean isRunning = true;
    private int vida;
    private int danno;
    private Estructuras estructura;

    public ThreadMuro(Estructuras estructura, int vida, int danno) {
        this.estructura = estructura;
        this.vida = vida;
        this.danno = danno;
    }
    
    public void run(){
        while(isRunning){
            try {
                sleep(1000);
                if (danno!=0){
                    vida -=danno;
                }
                if (vida<=0) {
                    estructura.cambiarImagenRecompensa(0);
                    stop();
                }
            } 
            catch (InterruptedException ex) {
                
            } 
        }
    }
    
    public int getDanno() {
        return danno;
    }

    public void setDanno(int danno) {
        this.danno = danno;
    }
}
