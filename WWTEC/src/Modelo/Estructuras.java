/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Estructuras {
    private ImageIcon imagen;
    private int vida;
    private int ataque;
    private int danno = 0;
    private String nombre;
    private int posx;
    private int posy;
    int tipo;
    private int px;
    private int py;
    private javax.swing.JButton btnEstructura = new javax.swing.JButton();
    private ModeloPueblo pueblo;
    private ThreadEstructuras threadEstructuras;

    public Estructuras(ModeloPueblo pueblo) {
        this.pueblo = pueblo;
    }
    
    public void cannon(int x, int y){
        //Cambia los datos de la estructura para que sea un cañon=0
        imagen = new ImageIcon("Cannon.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 10;
        ataque = 1;
        nombre = "Cañón";
        tipo = 1;
        btnEstructura.setBounds(x, y, 35, 35);
        btnEstructura.setBackground(Color.red);
        px = x;
        py = y;
        //crea el thread
        threadEstructuras = new ThreadEstructuras(this, vida, ataque, danno, posx, posy, pueblo, 0);
    }
    
    public void aereos(int x, int y){
        //Cambia los datos de la estructura para que sea un aereo=1
        imagen = new ImageIcon("Aereo.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 10;
        ataque = 3;
        nombre = "Aéreos";
        tipo = 1;
        btnEstructura.setBounds(x, y, 35, 35);
        btnEstructura.setBackground(Color.blue);
        px = x;
        py = y;
        //crea e inicia el thread
        threadEstructuras = new ThreadEstructuras(this, vida, ataque, danno, posx, posy, pueblo, 1);
    }
    
    public void bombas(int x, int y){
        //Cambia los datos de la estructura para que sea una bomba=2
        imagen = new ImageIcon("Mina.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 1;
        ataque = 5;
        nombre = "Bombas";
        tipo = 1;
        btnEstructura.setBounds(x, y, 35, 35);
        btnEstructura.setBackground(Color.green);
        px = x;
        py = y;
        //crea e inicia el thread
        threadEstructuras = new ThreadEstructuras(this, vida, ataque, danno, posx, posy, pueblo, 2);
    }
    
    public void mortero(int x, int y){
        //Cambia los datos de la estructura para que sea un mortero=3
        imagen = new ImageIcon("Mortero.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 20;
        ataque = 2;
        nombre = "Mortero";
        tipo = 1;
        btnEstructura.setBounds(x, y, 35, 35);
        btnEstructura.setBackground(Color.orange);
        px = x;
        py = y;
        //crea e inicia el thread
        threadEstructuras = new ThreadEstructuras(this, vida, ataque, danno, posx, posy, pueblo, 3);
    }
    
    public void torre(int x, int y){
        //Cambia los datos de la estructura para que sea una torre=4
        imagen = new ImageIcon("Torre.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 10;
        ataque = 1;
        nombre = "Torre";
        tipo = 1;
        btnEstructura.setBounds(x, y, 35, 35);
        btnEstructura.setBackground(Color.magenta);
        px = x;
        py = y;
        //crea e inicia el thread
        threadEstructuras = new ThreadEstructuras(this, vida, ataque, danno, posx, posy, pueblo, 4);
    }
    
    public void muro(int x, int y){
        //Cambia los datos de la estructura para que sea un muro=5
        imagen = new ImageIcon("Muros.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 30;
        ataque = 0;
        nombre = "Muro";
        tipo = 2;
        btnEstructura.setBounds(x, y, 35, 35);
        btnEstructura.setBackground(Color.black);
        px = x;
        py = y;
        //crea e inicia el thread
        threadEstructuras = new ThreadEstructuras(this, vida, ataque, danno, posx, posy, pueblo, 5);
    }
    
    public void ayuntamiento(int x, int y){
        //Cambia los datos de la estructura para que sea un ayuntamiento=6
        imagen = new ImageIcon("Ayuntamiento.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 35;
        ataque = 0;
        nombre = "Ayuntamiento";
        tipo = 0;
        btnEstructura.setBounds(x, y, 35, 35);
        btnEstructura.setBackground(Color.cyan);
        px = x;
        py = y;
        //crea e inicia el thread
        threadEstructuras = new ThreadEstructuras(this, vida, ataque, danno, posx, posy, pueblo, 6);
    }
    //manda informacion al threadDestruccion y cambia la imagen de la estructura
    public void cambiarImagenRecompensa(int tipo){
        btnEstructura.setEnabled(false);
        if (tipo == 1) {//destruyeron al ayuntamiento
            pueblo.getThreadDestruccion().setTotal(1000);
        }else{
            pueblo.getThreadDestruccion().setTotal(pueblo.getThreadDestruccion().getTotal()+1);
        }
    }
    //getter and setter
    public JButton getPnlEstructura() {
        return btnEstructura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPx() {
        return px;
    }

    public int getPy() {
        return py;
    }

    public int getTipo() {
        return tipo;
    }
    
    public ThreadEstructuras getThreadEstructuras() {
        return threadEstructuras;
    }

    
    
    
}
