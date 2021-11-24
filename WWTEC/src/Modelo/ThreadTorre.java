/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class ThreadTorre extends Thread{
    
    private boolean isRunning = true;
    private int vida;
    private int ataque;
    private int danno;
    private int x;
    private int y;
    private Estructuras estructura;
    private ModeloPueblo pueblo;

    public ThreadTorre(Estructuras estructura, int vida, int ataque, int danno, int x, int y, ModeloPueblo pueblo) {
        this.estructura = estructura;
        this.vida = vida;
        this.ataque = ataque;
        this.danno = danno;
        this.x = x;
        this.y = y;
        this.pueblo = pueblo;
    }
    
    public void run(){
        while(isRunning){
            try {
                sleep(1000);
                if (danno!=0){
                    vida -=danno;
                }
                if (vida<=0) {
                    estructura.cambiarImagenRecompensa(4);
                    stop();
                }
                for (int i = x-7; i < x+7; i++) {
                    for (int j = y-7; j < y+7; j++) {
                        if ((i>=0 && i<=20) && (j>=0 && j<=20)) {
                            if (pueblo.getMatrizPueblo()[i][j]!=null) {
                                //preguntar si es soldado
                            }
                        }
                    }
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
