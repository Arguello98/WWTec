/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.image.BufferedImage;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author tefad
 */
public class Avion extends Ejercito {
    ImageIcon Apariencia1=new ImageIcon(getClass().getResource("/Img/mediocaminando.jpg"));
    ImageIcon Apariencia2=new ImageIcon(getClass().getResource("/Img/medioatacando.jpg"));;
    ImageIcon Apariencia3=new ImageIcon(getClass().getResource("/Img/cequiz.gif"));
    int posx;
    int posy;
    int cont=0;
    private boolean isRunning = true;
    boolean banderaMuro1;
    boolean banderaMuro2;
    boolean atacado=false;
    String nombreE;
    
    public Avion(int x, int y, ModeloEjercito ejercito){
        super(x, y, ejercito);
        this.posx=x/35;
        this.posy=y/35;
        
        //System.out.println("posicion inicial "+posx+", "+posy);
        banderaMuro1=false;
        banderaMuro2=false;
        pnlEjercito.setIcon(Apariencia1);   
    }
        public void Buscar(){
       // System.out.println("posicion actual "+posx+", "+posy);
        String ubicacion;
        boolean salir=false;
        if (posx<=9&&posy<=9) {
           // System.out.println("DR");
            for (int i = posx+1; i < 20; i++) {//DR
                for (int j = posy+1; j < 20; j++) {
                    if(existe(i,j)){
                      //  System.out.println(i+", "+j);
                        Identificar(i,j);
                        salir=true;
                        break;
                    }
                    
                }
                if(salir){
                    break;
                }
            }
        }
        else if (posx>9&&posy<=9) {//DL
           /// System.out.println("DL");
            for (int i = posx-1; i > 2; i--) {
                for (int j = posy+1; j < 20; j++) {
                    if(existe(i,j)){
                       Identificar(i,j);
                        salir=true;
                        break;
                    }
                }
                 if(salir){
                    break;
                }
            }
        }
        else if (posx<=9&&posy>9) {//UR
           // System.out.println("UR");
            for (int i = posx+1; i < 20; i++) {
                for (int j = posy-1; j > 0; j--) {
                   if(existe(i,j)){
                        Identificar(i,j);
                        salir=true;
                        break;
                    }
                }
                 if(salir){
                    break;
                }
            }
        }
        else if (posx>9&&posy>9) {//UL
          //  System.out.println("UL");
            for (int i = posx-1; i > 2; i--) {
                for (int j = posy-1; j > 2; j--) {
                    if(existe(i,j)){
                       Identificar(i,j);
                       salir=true;
                       break;
                    }
                }
                 if(salir){
                    break;
                }
            }
        }
    }
    
   
    public boolean existe(int i, int j){
        //System.out.println("existe " );
        try{
            return matrizPueblo[i][j]!=null;}
        catch(Exception e){
            return false;
        }
    }
    
    public void Identificar(int i, int j){
        //System.out.println("Identificar ");
        nombreE=matrizPueblo[i][j].getNombre();
       // System.out.println(nombreE);
        if(null != nombreE)switch (nombreE) {
            case "Muro":
                banderaMuro1=true;
                try{
                    while((matrizPueblo[i][j].getThreadEstructuras().getVida()>0)){
                    Atacar(i,j);
                    //atacado=true;
                    }
                    matrizPueblo[i][j].getPnlEstructura().setVisible(false);
                    matrizPueblo[i][j]=null;
                        
               }
                catch(Exception ex){
                    atacado=false;
                }
                
                break;

            default:
                try{
                    while((matrizPueblo[i][j].getThreadEstructuras().getVida()>0)){
                    //atacado=true;
                    Atacar(i,j);
                    }
                    matrizPueblo[i][j].getPnlEstructura().setVisible(false);
                    matrizPueblo[i][j]=null;
                        
               }
                catch(Exception ex){
                    atacado=false;
                }
                break;
        }
    }
    
    
    public void Espera(){
        try {
            sleep(1000);
        } catch (InterruptedException ex1) {
            Logger.getLogger(SoldadoContacto.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }
    
    
    public void Espera2(){
        try {
            sleep(1000);
        } catch (InterruptedException ex1) {
            Logger.getLogger(SoldadoContacto.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }
     
 
   
   
    @Override
    public void Atacar(int x, int y){
        //System.out.println(matrizPueblo[x][y].getNombre());
        matrizPueblo[x][y].getThreadEstructuras().setDanno(golpesXtiempo);
        pnlEjercito.setIcon(Apariencia2);
        //this.atacando=true;
        Espera2();
    }
    
    @Override
    public void run(){
        while(isRunning){
            if (danno!=0) {
                vida-=danno;
                danno=0;
                //System.out.println(vida+"--------"+danno);
            }
            if (vida<=0) {
                pnlEjercito.setIcon(Apariencia3);
                isRunning=false;
                ejercito.sumarContador();
                Espera();
                pnlEjercito.setVisible(false);
                matrizEjercito[posx][posy]=null;
                this.stop();
            }
            Buscar();
            pnlEjercito.setIcon(Apariencia1);
        }
    }
}
