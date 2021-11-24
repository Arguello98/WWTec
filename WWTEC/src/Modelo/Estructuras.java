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
        //0
        imagen = new ImageIcon("Cannon.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 10;
        ataque = 1;
        nombre = "Cañón";
        tipo = 1;
        btnEstructura.setBounds(x, y, 50, 50);
        btnEstructura.setBackground(Color.red);
        ThreadEstructuras threadCannon = new ThreadEstructuras(this, vida, ataque, danno, posx, posy, pueblo, 0);
        threadCannon.start();
    }
    
    public void aereos(int x, int y){
        //1
        imagen = new ImageIcon("Aereo.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 10;
        ataque = 3;
        nombre = "Aéreos";
        tipo = 1;
        btnEstructura.setBounds(x, y, 50, 50);
        btnEstructura.setBackground(Color.blue);
        ThreadEstructuras threadAereos = new ThreadEstructuras(this, vida, ataque, danno, posx, posy, pueblo, 1);
        threadAereos.start();
    }
    
    public void bombas(int x, int y){
        //2
        imagen = new ImageIcon("Mina.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 1;
        ataque = 5;
        nombre = "Bombas";
        tipo = 1;
        btnEstructura.setBounds(x, y, 50, 50);
        btnEstructura.setBackground(Color.green);
        ThreadEstructuras threadBombas = new ThreadEstructuras(this, vida, ataque, danno, posx, posy, pueblo, 2);
        threadBombas.start();
    }
    
    public void mortero(int x, int y){
        //3
        imagen = new ImageIcon("Mortero.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 20;
        ataque = 2;
        nombre = "Mortero";
        tipo = 1;
        btnEstructura.setBounds(x, y, 50, 50);
        btnEstructura.setBackground(Color.orange);
        ThreadEstructuras threadMortero = new ThreadEstructuras(this, vida, ataque, danno, posx, posy, pueblo, 3);
        threadMortero.start();
    }
    
    public void torre(int x, int y){
        //4
        imagen = new ImageIcon("Torre.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 10;
        ataque = 1;
        nombre = "Torre";
        tipo = 1;
        btnEstructura.setBounds(x, y, 50, 50);
        btnEstructura.setBackground(Color.magenta);
        ThreadEstructuras threadTorre = new ThreadEstructuras(this, vida, ataque, danno, posx, posy, pueblo, 4);
        threadTorre.start();
    }
    
    public void muro(int x, int y){
        //5
        imagen = new ImageIcon("MurosH.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 30;
        ataque = 0;
        nombre = "Muro";
        tipo = 2;
        btnEstructura.setBounds(x, y, 59, 29);
        btnEstructura.setBackground(Color.black);
        ThreadEstructuras threadMuro = new ThreadEstructuras(this, vida, ataque, danno, posx, posy, pueblo, 5);
        threadMuro.start();
    }
    
    public void ayuntamiento(int x, int y){
        //6
        imagen = new ImageIcon("Ayuntamiento.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 35;
        ataque = 0;
        nombre = "Ayuntamiento";
        tipo = 0;
        btnEstructura.setBounds(x, y, 50, 50);
        btnEstructura.setBackground(Color.cyan);
        ThreadEstructuras threadAyuntamiento = new ThreadEstructuras(this, vida, ataque, danno, posx, posy, pueblo, 6);
        threadAyuntamiento.start();
    }

    public void cambiarImagenRecompensa(int tipo){
        btnEstructura.setEnabled(false);
        if (tipo == 1) {
            pueblo.getThreadDestruccion().setTotal(1000);
        }else{
            pueblo.getThreadDestruccion().setTotal(pueblo.getThreadDestruccion().getTotal()+1);
        }
    }
    
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
