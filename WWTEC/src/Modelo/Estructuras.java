/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

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
        imagen = new ImageIcon("Cannon.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 10;
        ataque = 1;
        nombre = "Cañón";
        tipo = 1;
        btnEstructura.setBounds(x, y, 50, 50);
        btnEstructura.setBackground(Color.red);
        ThreadCannon threadCannon = new ThreadCannon(this, vida, ataque, danno, posx, posy, pueblo);
        threadCannon.start();
    }
    
    public void aereos(int x, int y){
        imagen = new ImageIcon("Aereo.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 10;
        ataque = 3;
        nombre = "Aéreos";
        tipo = 1;
        btnEstructura.setBounds(x, y, 50, 50);
        btnEstructura.setBackground(Color.blue);
        ThreadAereos threadAereos = new ThreadAereos(this, vida, ataque, danno, posx, posy, pueblo);
        threadAereos.start();
    }
    
    public void bombas(int x, int y){
        imagen = new ImageIcon("Mina.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 1;
        ataque = 5;
        nombre = "Bombas";
        tipo = 1;
        btnEstructura.setBounds(x, y, 50, 50);
        btnEstructura.setBackground(Color.green);
        ThreadBombas threadBombas = new ThreadBombas(this, vida, ataque, danno, posx, posy, pueblo);
        threadBombas.start();
    }
    
    public void mortero(int x, int y){
        imagen = new ImageIcon("Mortero.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 20;
        ataque = 2;
        nombre = "Mortero";
        tipo = 1;
        btnEstructura.setBounds(x, y, 50, 50);
        btnEstructura.setBackground(Color.orange);
        ThreadMortero threadMortero = new ThreadMortero(this, vida, ataque, danno, posx, posy, pueblo);
        threadMortero.start();
    }
    
    public void torre(int x, int y){
        imagen = new ImageIcon("Torre.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 10;
        ataque = 1;
        nombre = "Torre";
        tipo = 1;
        btnEstructura.setBounds(x, y, 50, 50);
        btnEstructura.setBackground(Color.magenta);
        ThreadTorre threadTorre = new ThreadTorre(this, vida, ataque, danno, posx, posy, pueblo);
        threadTorre.start();
    }
    
    public void muro(int x, int y){
        imagen = new ImageIcon("MurosH.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 30;
        nombre = "Muro";
        tipo = 2;
        btnEstructura.setBounds(x, y, 59, 29);
        btnEstructura.setBackground(Color.black);
        ThreadMuro threadMuro = new ThreadMuro(this, vida, danno);
        threadMuro.start();
    }
    
    public void ayuntamiento(int x, int y){
        imagen = new ImageIcon("Ayuntamiento.jpg");
        btnEstructura.setIcon(imagen);
        btnEstructura.enableInputMethods(false);
        vida = 35;
        nombre = "Ayuntamiento";
        tipo = 0;
        btnEstructura.setBounds(x, y, 50, 50);
        btnEstructura.setBackground(Color.cyan);
        ThreadAyuntamiento threadAyuntamiento = new ThreadAyuntamiento(this, vida, danno);
        threadAyuntamiento.start();
    }

    public void cambiarImagenRecompensa(int tipo){
        btnEstructura.setEnabled(false);
        if (tipo == 1) {
            
        }else{
            
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
