/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class ThreadEstructuras extends Thread{
    
    private boolean isRunning = true;
    private int vida;
    private int ataque = 0;
    private int danno;
    private int x;
    private int y;
    private Estructuras estructura;
    private ModeloPueblo pueblo;
    private int tipoEstructura;
    private int iniciox = 0;
    private int finalx = 0;
    private int inicioy = 0;
    private int finaly = 0;

    public ThreadEstructuras(Estructuras estructura, int vida, int ataque, int danno, int x, int y, ModeloPueblo pueblo, int tipoEstructura) {
        this.estructura = estructura;
        this.vida = vida;
        this.ataque = ataque;
        this.danno = danno;
        this.x = x;
        this.y = y;
        this.pueblo = pueblo;
        this.tipoEstructura = tipoEstructura;
    }
    
    @Override
    public void run(){
        while(isRunning){
            try {
                sleep(1000);
                if (danno!=0){//pierde vida
                    vida -=danno;
                }
                if (vida<=0) {//es destruida
                    switch (tipoEstructura) {
                        case 6://es ayuntamiento gana el juego
                            estructura.cambiarImagenRecompensa(1);
                            break;
                        case 2://es bomba explota
                            estructura.cambiarImagenRecompensa(0);
                            for (int i = x-3; i < x+3; i++) {
                                for (int j = y-3; j < y+3; j++) {
                                    if ((i>=0 && i<=20) && (j>=0 && j<=20)) {
                                        if (pueblo.getMatrizPueblo()[i][j]!=null) {
                                            //preguntar si es soldado
                                        }
                                    }
                                }
                            }   
                            break;
                        default:
                            estructura.cambiarImagenRecompensa(0);
                            break;
                    }
                    stop();
                }
                if (ataque!=0 && tipoEstructura!=2) {
                    //rango de alcance de las estructuras
                    switch (tipoEstructura) {
                        case 0://cañon
                            iniciox = x-5;
                            finalx = x+5;
                            inicioy = y-5;
                            finaly = y+5;
                            break;
                        case 1://aereo
                            iniciox = x-10;
                            finalx = x+10;
                            inicioy = y-10;
                            finaly = y+10;
                            break;
                        case 3://mortero
                            iniciox = x-10;
                            finalx = x+10;
                            inicioy = y-10;
                            finaly = y+10;
                            break;
                        case 4://torre
                            iniciox = x-7;
                            finalx = x+7;
                            inicioy = y-7;
                            finaly = y+7;
                            break;
                        default:
                            break;
                    }
                    //ataque
                    for (int i = iniciox; i < finalx; i++) {
                        for (int j = inicioy; j < finaly; j++) {
                            if ((i>=0 && i<=20) && (j>=0 && j<=20)) {
                                if (pueblo.getMatrizPueblo()[i][j]!=null) {
                                    //preguntar si es soldado
                                }
                            }
                        }
                    }
                }
            } 
            catch (InterruptedException ex) {} 
        }
    }
    //getter and setter
    public int getDanno() {
        return danno;
    }

    public void setDanno(int danno) {
        this.danno = danno;
    }
}
