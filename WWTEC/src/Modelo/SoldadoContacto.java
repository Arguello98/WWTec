/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;




/**
 *
 * @author tefad
 */
public class SoldadoContacto extends Ejercito {
    ImageIcon Apariencia1=new ImageIcon(getClass().getResource("/Img/samuraicaminando.png"));
    ImageIcon Apariencia2=new ImageIcon(getClass().getResource("/Img/samuraiatacando.png"));
    ImageIcon Apariencia3=new ImageIcon(getClass().getResource("/Img/cequiz.gif"));
    int posx;
    int posy;
   
    int cont=0;
    private boolean isRunning = true;
    boolean banderaMuro1;
    boolean banderaMuro2;
    boolean atacado=false;
    String nombreE;
    
    public SoldadoContacto(int x, int y, ModeloEjercito ejercito){
        super(x, y, ejercito);
        this.posx=x/35;
        this.posy=y/35;
        
        //System.out.println("posicion inicial "+posx+", "+posy);
        banderaMuro1=false;
        banderaMuro2=false;
        pnlEjercito.setIcon(Apariencia1);   
    }
    
    @Override
    public void agregados(int vida, int golpesXtiempo, String nombre, String img1, String img2){
        this.vida = vida;
        this.golpesXtiempo = golpesXtiempo;
        this.nombre = nombre;
        Apariencia1 = new ImageIcon(img1);
        Apariencia2 = new ImageIcon(img2);
        pnlEjercito.setIcon(Apariencia1);
    }
       
    public void Buscar(){
        //System.out.println("posicion actual "+posx+", "+posy);
        String ubicacion;
        boolean salir=false;
        if (posx<=9&&posy<=9) {
            //System.out.println("DR");
            for (int i = posx+1; i < 20; i++) {//DR
                for (int j = posy+1; j < 20; j++) {
                    if(existe(i,j)){
                        //System.out.println(i+", "+j);
                        if(banderaMuro1==false){ 
                            ubicacion=ubicar(i,j);
                            direccion(ubicacion,i,j);
                        } 
                        salir=true;
                        break;
                    }
                    else{
                        i+=2;
                        j+=2;
                        banderaMuro1=false;
                        ubicacion=ubicar(i,j);
                        direccion(ubicacion,i,j);
                        }
                }
                if(salir){
                    break;
                }
            }
        }
        else if (posx>9&&posy<=9) {//DL
            //System.out.println("DL");
            for (int i = posx-1; i > 2; i--) {
                for (int j = posy+1; j < 20; j++) {
                    if(existe(i,j)){
                        //System.out.println(i+", "+j);
                        if(banderaMuro1==false){ 
                            ubicacion=ubicar(i,j);
                            direccion(ubicacion,i,j);
                        } 
                        else{
                            i-=2;
                            j+=2;
                            banderaMuro1=false;
                            ubicacion=ubicar(i,j);
                            direccion(ubicacion,i,j);
                        }
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
            //System.out.println("UR");
            for (int i = posx+1; i < 20; i++) {
                for (int j = posy-1; j > 0; j--) {
                   if(existe(i,j)){
                        System.out.println(i+", "+j);
                        if(banderaMuro1==false){ 
                           ubicacion=ubicar(i,j);
                           direccion(ubicacion,i,j);
                        } 
                        else{
                            i+=2;
                            j-=2;
                            banderaMuro1=false;
                            ubicacion=ubicar(i,j);
                            direccion(ubicacion,i,j);
                        }
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
          // System.out.println("UL");
            for (int i = posx-1; i > 2; i--) {
                for (int j = posy-1; j > 2; j--) {
                    if(existe(i,j)){
                       // System.out.println(i+", "+j);
                        if(banderaMuro1==false){ 
                            ubicacion=ubicar(i,j);
                            direccion(ubicacion,i,j);

                        } 
                       else{
                            i-=2;
                            j-=2;
                            banderaMuro1=false;
                            ubicacion=ubicar(i,j);
                            direccion(ubicacion,i,j);
                        }
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
    
    public void direccion(String ubicacion,int i, int j){
       // System.out.println("ubicacion "+ubicacion);
        if("up".equals(ubicacion)&&i==posx&&j==posy-1
            ||"down".equals(ubicacion)&&i==posx&&j==posy+1
            ||"left".equals(ubicacion)&&i==posx-1&&j==posy
            ||"right".equals(ubicacion)&&i==posx+1&&j==posy
            ||"diagonalDR".equals(ubicacion)&&i==posx+1&&j==posy+1
            ||"diagonalDL".equals(ubicacion)&&i==posx-1&&j==posy+1
            ||"diagonalUR".equals(ubicacion)&&i==posx+1&&j==posy-1
            ||"diagonalUL".equals(ubicacion)&&i==posx-1&&j==posy-1
            ){//pregunta si esta a la par del objetivo
            Identificar(i,j);  
            //Moverse(ubicacion);
            // si esta ataca
        }
        else{
            Moverse(ubicacion);
            //si no, se mueve
        }
    }
    public String ubicar(int i, int j){
        String lado="";
        if(this.posx<i&&this.posy<j){//pregunta a que lado queda
            lado="diagonalDR";
        }
        else if (this.posx>i&&this.posy<j){
            lado="diagonalDL";
        }
        else if (this.posx==i&&this.posy<j){
            lado="down";
        }
        else if (this.posx<i&&this.posy==j){
            lado="right";
        }
        else if (this.posx>i&&this.posy==j){
            lado="left";
        }
        else if (this.posx==i&&this.posy>j){
            lado="up";
        }
        else if (this.posx<i&&this.posy>j){
           lado="diagonalUR";
        }
        else if (this.posx>i&&this.posy>j){
           lado="diagonalUL";
        }
        
        return lado;
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
        //System.out.println(nombreE);
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
     
 
   public void Moverse(String lado){
       int i;
       int j;
        switch (lado) {
            case "diagonalUL":
                matrizEjercito[posx][posy]=null;
                this.posx-=1;
                this.posy-=1;
                Espera();
                while(matrizEjercito[posx][posy]!=null){
                    Espera2();
                }
                for (i = (this.posx+1)*35; i>this.posx*35; i--) {
                    for (j = (this.posy+1)*35; j > this.posy*35; j--) {
                        pnlEjercito.setLocation(i, j);
                    }
                    
                }
                break;
            case "diagonalDL":
                matrizEjercito[posx][posy]=null;
                this.posx-=1;
                this.posy+=1;
                Espera();
                while(matrizEjercito[posx][posy]!=null){
                    Espera2();
                }
                for (i = (this.posx+1)*35; i>this.posx*35; i--) {
                    for (j = (this.posy-1)*35; j < this.posy*35; j++) {
                        pnlEjercito.setLocation(i, j);
                    }
                    
                }
                break;
            case "left":
                matrizEjercito[posx][posy]=null;
                this.posx-=1;
                Espera();
                while(matrizEjercito[posx][posy]!=null){
                    Espera2();
                }
                for (i = (this.posx+1)*35; i>this.posx*35; i--) {
                   pnlEjercito.setLocation(i, posy*35);
                }
                break;
                
            case "diagonalUR":
                matrizEjercito[posx][posy]=null;
                this.posx+=1;
                this.posy-=1;
                Espera();
                while(matrizEjercito[posx][posy]!=null){
                    Espera2();
                }
                for (i =(this.posx-1)*35; i < this.posx*35; i++) {
                    for (j = (this.posy-1)*35; j < this.posy*35; j++) {
                        pnlEjercito.setLocation(i, j);
                    }
                    
                }
                break; 
            case "diagonalDR":
                matrizEjercito[posx][posy]=null;
                this.posx+=1;
                this.posy+=1;
                Espera();
                while(matrizEjercito[posx][posy]!=null){
                    Espera2();
                }
                for (i =(this.posx-1)*35; i < this.posx*35; i++) {
                    for (j = (this.posy-1)*35; j < this.posy*35; j++) {
                        pnlEjercito.setLocation(i, j);
                    }
                }
                break;
            case "rigth":
                matrizEjercito[posx][posy]=null;
                this.posx+=1;
                Espera();
                while(matrizEjercito[posx][posy]!=null){
                    Espera2();
                }
                for (i = (this.posx+1)*35; i>this.posx*35; i--) {
                   pnlEjercito.setLocation(i, posy*35);
                }
                break;
            case "up":
                matrizEjercito[posx][posy]=null;
                this.posy-=1;
                Espera();
                while(matrizEjercito[posx][posy]!=null){
                    Espera2();
                }
                for (j = this.posy*35; j > this.posy*35; j--) {
                    pnlEjercito.setLocation(posx*35, j);
                }
                break;
            case "down":
                matrizEjercito[posx][posy]=null;
                this.posy+=1;
                Espera();
                while(matrizEjercito[posx][posy]!=null){
                    Espera2();
                }
                for (j = (this.posy-1)*35; j < this.posy*35; j++) {
                    pnlEjercito.setLocation(posx*35, j);
                }
                break;
            default:
                break;
        }
        //System.out.println("moverse  "+posx +", "+ posy);
        matrizEjercito[posx][posy]=this;
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
