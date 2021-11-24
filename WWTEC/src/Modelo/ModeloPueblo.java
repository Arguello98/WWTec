/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Pantalla;
import java.util.Random;
import javax.swing.ImageIcon;

public final class ModeloPueblo {
    
    private Estructuras matrizPueblo[][] = new Estructuras[21][21];
    private int cantidadDefensas = 13;
    private int nivel = 1;
    private Random random = new Random();
    private int[] listax;
    private int[] listay;
    private int[] listax2;
    private int[] listay2;
    
    public void colocarAyuntamiento(Pantalla vista){
        Estructuras ayuntamiento = new Estructuras(this);
        ayuntamiento.ayuntamiento(725, 350);
        ayuntamiento.setPosx(10);
        ayuntamiento.setPosy(10);
        matrizPueblo[10][10] = ayuntamiento;
        matrizPueblo[11][10] = ayuntamiento;
        vista.getPnlCampo().add(ayuntamiento.getPnlEstructura());
    }
    
    public void colocarMuros(Pantalla vista){
        Estructuras muros[] = new Estructuras[56];
        int x = 325;
        int y = 100;
        int pos = 0;
        for (int i = 0; i < muros.length; i++) {
            muros[i] = new Estructuras(this);
            muros[i].muro(x, y);
            if (i <= 13) {
                x += 60;
                matrizPueblo[i+3][3] = muros[i];
                muros[i].setPosx(i+3);
                muros[i].setPosy(3);
            }else if(i>13 && i<=27){
                muros[i].getPnlEstructura().setBounds(x, y, 29, 39);
                ImageIcon imagen = new ImageIcon("MurosV.jpg");
                muros[i].getPnlEstructura().setIcon(imagen);
                y += 40;
                matrizPueblo[17][i-11] = muros[i];
                muros[i].setPosx(17);
                muros[i].setPosy(i-11);
            }else if(i>27 && i<=41){
                if (i == 28) {
                    x-=30;
                }
                muros[i].getPnlEstructura().setBounds(x, y, 59, 29);
                x -= 60;
                matrizPueblo[i-11-pos][17] = muros[i];
                muros[i].setPosx(i-11-pos);
                muros[i].setPosy(17);
                pos++;
                pos++;
            }else if(i>41){
                if (i == 42) {
                    x+=30;
                    y-=10;
                }
                muros[i].getPnlEstructura().setBounds(x, y, 29, 39);
                ImageIcon imagen = new ImageIcon("MurosV.jpg");
                muros[i].getPnlEstructura().setIcon(imagen);
                y -= 40;
                matrizPueblo[3][i-10-pos] = muros[i];
                muros[i].setPosx(3);
                muros[i].setPosy(i-10-pos);
            }
            
            vista.getPnlCampo().add(muros[i].getPnlEstructura());
        }
        Estructuras muros2[] = new Estructuras[8];
        x = 665;
        y = 320;
        for (int i = 0; i < muros2.length; i++) {
            muros2[i] = new Estructuras(this);
            muros2[i].muro(x, y);
            if (i<=1) {
                x += 60;
                matrizPueblo[9+i][9] = muros2[i];
                muros2[i].setPosx(9+i);
                muros2[i].setPosy(9);
            }else if(i>1 && i<=3){
                if (i == 2) {
                    x+=30;
                }
                muros2[i].getPnlEstructura().setBounds(x, y, 29, 39);
                ImageIcon imagen = new ImageIcon("MurosV.jpg");
                muros2[i].getPnlEstructura().setIcon(imagen);
                y += 40;
                matrizPueblo[12][7+i] = muros2[i];
                muros2[i].setPosx(12);
                muros2[i].setPosy(7+i);
            }else if(i>3 && i<=5){
                if (i == 4) {
                    x-=30;
                }
                muros2[i].getPnlEstructura().setBounds(x, y, 59, 29);
                x -= 60;
                matrizPueblo[16-i][11] = muros2[i];
                muros2[i].setPosx(16-i);
                muros2[i].setPosy(11);
            }else if(i>5){
                if (i == 6) {
                    y-=10;
                }
                muros2[i].getPnlEstructura().setBounds(x, y, 29, 39);
                ImageIcon imagen = new ImageIcon("MurosV.jpg");
                muros2[i].getPnlEstructura().setIcon(imagen);
                y -= 40;
                matrizPueblo[9][17-i] = muros2[i];
                muros2[i].setPosx(9);
                muros2[i].setPosy(17-i);
            }
            vista.getPnlCampo().add(muros2[i].getPnlEstructura());
        }
    }
    
    public void colocarDefensas(Pantalla vista){
        cantidadDefensas += (nivel-1);
        Estructuras defensas[] = new Estructuras[cantidadDefensas];
        int x = 1;
        int y = 1;
        int x2 = 1;
        int y2 = 1;
        listax = new int[cantidadDefensas];
        listay = new int[cantidadDefensas];
        listax2 = new int[cantidadDefensas];
        listay2 = new int[cantidadDefensas];
        for (int i = 0; i < cantidadDefensas; i++) {
            boolean buscar = true;
            int tipo = random.nextInt(5);
            defensas[i] = new Estructuras(this);
            while(buscar){
                x = random.nextInt(1105);
                y = random.nextInt(600);
                x2 = x/100;
                y2 = y/100;
                boolean salir = true;
                if ((x<605 || x>845) && (y<230 || y>470) && x<1105 && x>385 && y<600 && y>160) {
                    if (i!=0) {
                        for (int j = 0; j < listax2.length; j++) {
                            if (listax2[j]==x2 && listay2[j]==y2) {
                                salir = false;
                            }else if ((listax[j]<=x+50 && listax[j]>=x-50) && (listay[j]<=y+50 && listay[j]>=y-50)) {
                                salir = false;
                            }
                        }
                    }
                    if (salir) {
                        listax[i] = x;
                        listay[i] = y;
                        listax2[i] = x2;
                        listay2[i] = y2;
                        //System.out.println(x+"--"+y);
                        //System.out.println(x2+"--"+y2);
                        matrizPueblo[x2][y2] = defensas[i];
                        defensas[i].setPosx(x2);
                        defensas[i].setPosy(y2);
                        buscar = false;
                    }
                }
            }
            switch (tipo) {
                case 0:
                    defensas[i].cannon(x, y);
                    break;
                case 1:
                    defensas[i].aereos(x, y);
                    break;
                case 2:
                    defensas[i].bombas(x, y);
                    break;
                case 3:
                    defensas[i].mortero(x, y);
                    break;
                case 4:
                    defensas[i].torre(x, y);
                    break;
                default:
                    break;
            }
            
            vista.getPnlCampo().add(defensas[i].getPnlEstructura());
        }
    }
    
    public void matriz(){
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                System.out.println(i+"--"+j);
                try {
                    System.out.println(matrizPueblo[i][j].getNombre());
                } catch (Exception e) {
                    System.out.println("Null");
                }
            }
        }
    }

    public Estructuras[][] getMatrizPueblo() {
        return matrizPueblo;
    }
    
}
