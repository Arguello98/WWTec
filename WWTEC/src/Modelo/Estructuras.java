/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Color;
import javax.swing.ImageIcon;
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
    private javax.swing.JPanel pnlEstructura = new javax.swing.JPanel();
    private ModeloPueblo pueblo;

    public Estructuras(ModeloPueblo pueblo) {
        this.pueblo = pueblo;
    }
    
    public void cannon(int x, int y){
        //agregar imagen
        /*imagen = new ImageIcon("estrellaMario.jpg");
        javax.swing.JLabel lblImagen = new javax.swing.JLabel(imagen);
        pnlEstructura.add(lblImagen);
        //*/
        vida = 10;
        ataque = 1;
        nombre = "Cañón";
        tipo = 1;
        pnlEstructura.setBounds(x, y, 50, 50);
        pnlEstructura.setBackground(Color.red);
        ThreadCannon threadCannon = new ThreadCannon(this, vida, ataque, danno, posx, posy, pueblo);
        threadCannon.start();
    }
    
    public void aereos(int x, int y){
        //imagen =1;
        vida = 10;
        ataque = 3;
        nombre = "Aéreos";
        tipo = 1;
        pnlEstructura.setBounds(x, y, 50, 50);
        pnlEstructura.setBackground(Color.blue);
        ThreadAereos threadAereos = new ThreadAereos(this, vida, ataque, danno, posx, posy, pueblo);
        threadAereos.start();
    }
    
    public void bombas(int x, int y){
        //imagen =1;
        vida = 1;
        ataque = 5;
        nombre = "Bombas";
        tipo = 1;
        pnlEstructura.setBounds(x, y, 50, 50);
        pnlEstructura.setBackground(Color.green);
        ThreadBombas threadBombas = new ThreadBombas(this, vida, ataque, danno, posx, posy, pueblo);
        threadBombas.start();
    }
    
    public void mortero(int x, int y){
        //imagen =1;
        vida = 20;
        ataque = 2;
        nombre = "Mortero";
        tipo = 1;
        pnlEstructura.setBounds(x, y, 50, 50);
        pnlEstructura.setBackground(Color.orange);
        ThreadMortero threadMortero = new ThreadMortero(this, vida, ataque, danno, posx, posy, pueblo);
        threadMortero.start();
    }
    
    public void torre(int x, int y){
        //imagen =1;
        vida = 10;
        ataque = 1;
        nombre = "Torre";
        tipo = 1;
        pnlEstructura.setBounds(x, y, 50, 50);
        pnlEstructura.setBackground(Color.magenta);
        ThreadTorre threadTorre = new ThreadTorre(this, vida, ataque, danno, posx, posy, pueblo);
        threadTorre.start();
    }
    
    public void muro(int x, int y){
        //imagen =1;
        vida = 30;
        nombre = "Muro";
        tipo = 2;
        pnlEstructura.setBounds(x, y, 59, 29);
        pnlEstructura.setBackground(Color.black);
        ThreadMuro threadMuro = new ThreadMuro(this, vida, danno);
        threadMuro.start();
    }
    
    public void ayuntamiento(int x, int y){
        //imagen =1;
        vida = 35;
        nombre = "Ayuntamiento";
        tipo = 0;
        pnlEstructura.setBounds(x, y, 50, 50);
        pnlEstructura.setBackground(Color.cyan);
        ThreadAyuntamiento threadAyuntamiento = new ThreadAyuntamiento(this, vida, danno);
        threadAyuntamiento.start();
    }

    public void cambiarImagenRecompensa(int tipo){
        switch (tipo) {
            case 0:
                //cannon
                break;
            case 1:
                //aereos
                break;
            case 2:
                //bombas
                break;
            case 3:
                //mortero
                break;
            case 4:
                //torre
                break;
            case 5:
                //muro
                break;
            case 6:
                //ayuntamiento
                break;
            default:
                break;
        }
    }
    
    public JPanel getPnlEstructura() {
        return pnlEstructura;
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
