/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Color;
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
    private javax.swing.JButton btnEstructura = new javax.swing.JButton();
    private ModeloPueblo pueblo;

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
        btnEstructura.setBounds(x, y, 50, 50);
        btnEstructura.setBackground(Color.red);
        //crea el thread
        ThreadEstructuras threadCannon = new ThreadEstructuras(this, vida, ataque, danno, posx, posy, pueblo, 0);
        threadCannon.start();
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
        btnEstructura.setBounds(x, y, 50, 50);
        btnEstructura.setBackground(Color.blue);
        //crea e inicia el thread
        ThreadEstructuras threadAereos = new ThreadEstructuras(this, vida, ataque, danno, posx, posy, pueblo, 1);
        threadAereos.start();
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
        btnEstructura.setBounds(x, y, 50, 50);
        btnEstructura.setBackground(Color.green);
        //crea e inicia el thread
        ThreadEstructuras threadBombas = new ThreadEstructuras(this, vida, ataque, danno, posx, posy, pueblo, 2);
        threadBombas.start();
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
        btnEstructura.setBounds(x, y, 50, 50);
        btnEstructura.setBackground(Color.orange);
        //crea e inicia el thread
        ThreadEstructuras threadMortero = new ThreadEstructuras(this, vida, ataque, danno, posx, posy, pueblo, 3);
        threadMortero.start();
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
        btnEstructura.setBounds(x, y, 50, 50);
        btnEstructura.setBackground(Color.magenta);
        //crea e inicia el thread
        ThreadEstructuras threadTorre = new ThreadEstructuras(this, vida, ataque, danno, posx, posy, pueblo, 4);
        threadTorre.start();
    }
    
    public void muro(int x, int y){
        //Cambia los datos de la estructura para que sea un muro=5
        imagen = new ImageIcon("MurosH.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 30;
        ataque = 0;
        nombre = "Muro";
        tipo = 2;
        btnEstructura.setBounds(x, y, 59, 29);
        btnEstructura.setBackground(Color.black);
        //crea e inicia el thread
        ThreadEstructuras threadMuro = new ThreadEstructuras(this, vida, ataque, danno, posx, posy, pueblo, 5);
        threadMuro.start();
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
        btnEstructura.setBounds(x, y, 50, 50);
        btnEstructura.setBackground(Color.cyan);
        //crea e inicia el thread
        ThreadEstructuras threadAyuntamiento = new ThreadEstructuras(this, vida, ataque, danno, posx, posy, pueblo, 6);
        threadAyuntamiento.start();
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
    
}
