
package Modelo;
import javax.swing.JButton;
/**
 *
 * @author tefad
 */
public abstract class Ejercito extends Thread{
    String nombre;
    int vida;
    int campos;
    int danno=0;
    int golpesXtiempo;
    Estructuras[][] matrizPueblo;
    Ejercito[][] matrizEjercito;
    public ModeloEjercito ejercito;
    public javax.swing.JButton pnlEjercito = new javax.swing.JButton();
    
    
    public Ejercito(int x, int y, ModeloEjercito ejercito){
        this.ejercito = ejercito;
        this.pnlEjercito.setBounds(x, y, 35, 35);

    }
     public void agregados(int vida, int golpesXtiempo, String nombre, String img1, String img2){}
     
    
    //public abstract void Moverse(int x, int y);
    public abstract void Atacar(int x, int y);

    public void setMatrizEjercito(Ejercito[][] matrizEjercito) {
        this.matrizEjercito = matrizEjercito;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGolpesXtiempo() {
        return golpesXtiempo;
    }

    public void setGolpesXtiempo(int golpesXtiempo) {
        this.golpesXtiempo = golpesXtiempo;
    }

    public int getCampos() {
        return campos;
    }

    public int getDaño() {
        return danno;
    }

    public void setDaño(int daño) {
        this.danno += daño;
    }

     public JButton getPnlEjercito() {
        return pnlEjercito;
    }
    
}

