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
    private ThreadDestruccion threadDestruccion;
    private double porcentaje;
    //pone el ayuntamiento en vista
    public void colocarAyuntamiento(Pantalla vista){
        Estructuras ayuntamiento = new Estructuras(this);
        //pixeles del ayuntamiento
        ayuntamiento.ayuntamiento(725, 350);
        ayuntamiento.setPosx(10);
        ayuntamiento.setPosy(10);
        //posiciones del ayuntamiento
        matrizPueblo[10][10] = ayuntamiento;
        matrizPueblo[11][10] = ayuntamiento;
        //agrega la estructura a vista
        vista.getPnlCampo().add(ayuntamiento.getPnlEstructura());
    }
    //pone los muros en vista
    public void colocarMuros(Pantalla vista){
        //total de muros
        Estructuras muros[] = new Estructuras[56];
        //pixeles del muro de la esquina superior izquierda
        int x = 325;
        int y = 100;
        int pos = 0;
        for (int i = 0; i < muros.length; i++) {//i es igual al muro por el que va
            muros[i] = new Estructuras(this);
            //pixeles de los muros
            muros[i].muro(x, y);
            if (i <= 13) {
                x += 60;
                //posiciones de los muros
                matrizPueblo[i+3][3] = muros[i];
                muros[i].setPosx(i+3);
                muros[i].setPosy(3);
            }else if(i>13 && i<=27){
                //orientacion el muro vertical
                muros[i].getPnlEstructura().setBounds(x, y, 29, 39);
                //imagen del muro vertical
                ImageIcon imagen = new ImageIcon("MurosV.jpg");
                muros[i].getPnlEstructura().setIcon(imagen);
                y += 40;
                //posiciones de los muros
                matrizPueblo[17][i-11] = muros[i];
                muros[i].setPosx(17);
                muros[i].setPosy(i-11);
            }else if(i>27 && i<=41){
                //evita que la esquina salga mal
                if (i == 28) {
                    x-=30;
                }
                //orientacion el muro horizontal
                muros[i].getPnlEstructura().setBounds(x, y, 59, 29);
                x -= 60;
                //posiciones de los muros
                matrizPueblo[i-11-pos][17] = muros[i];
                muros[i].setPosx(i-11-pos);
                muros[i].setPosy(17);
                pos++;
                pos++;
            }else if(i>41){
                //evita que la esquina salga mal
                if (i == 42) {
                    x+=30;
                    y-=10;
                }
                //orientacion el muro vertical
                muros[i].getPnlEstructura().setBounds(x, y, 29, 39);
                //imagen del muro vertical
                ImageIcon imagen = new ImageIcon("MurosV.jpg");
                muros[i].getPnlEstructura().setIcon(imagen);
                y -= 40;
                //posiciones de los muros
                matrizPueblo[3][i-10-pos] = muros[i];
                muros[i].setPosx(3);
                muros[i].setPosy(i-10-pos);
            }
            //agrega la estructura a vista
            vista.getPnlCampo().add(muros[i].getPnlEstructura());
        }
        //muros que rodean el ayuntamiento
        Estructuras muros2[] = new Estructuras[8];
        //pixeles del muro esquina superior izquierda que rodea el ayuntamiento
        x = 665;
        y = 320;
        for (int i = 0; i < muros2.length; i++) {
            muros2[i] = new Estructuras(this);
            //pixeles de los muro
            muros2[i].muro(x, y);
            if (i<=1) {
                x += 60;
                //posiciones de los muros
                matrizPueblo[9+i][9] = muros2[i];
                muros2[i].setPosx(9+i);
                muros2[i].setPosy(9);
            }else if(i>1 && i<=3){
                //evita que la esquina salga mal
                if (i == 2) {
                    x+=30;
                }
                //orientacion el muro vertical
                muros2[i].getPnlEstructura().setBounds(x, y, 29, 39);
                //imagen del muro vertical
                ImageIcon imagen = new ImageIcon("MurosV.jpg");
                muros2[i].getPnlEstructura().setIcon(imagen);
                y += 40;
                //posiciones de los muros
                matrizPueblo[12][7+i] = muros2[i];
                muros2[i].setPosx(12);
                muros2[i].setPosy(7+i);
            }else if(i>3 && i<=5){
                //evita que la esquina salga mal
                if (i == 4) {
                    x-=30;
                }
                //orientacion el muro horizontal
                muros2[i].getPnlEstructura().setBounds(x, y, 59, 29);
                x -= 60;
                //posiciones de los muros
                matrizPueblo[16-i][11] = muros2[i];
                muros2[i].setPosx(16-i);
                muros2[i].setPosy(11);
            }else if(i>5){
                //evita que la esquina salga mal
                if (i == 6) {
                    y-=10;
                }
                //orientacion el muro vertical
                muros2[i].getPnlEstructura().setBounds(x, y, 29, 39);
                //imagen del muro vertical
                ImageIcon imagen = new ImageIcon("MurosV.jpg");
                muros2[i].getPnlEstructura().setIcon(imagen);
                y -= 40;
                //posiciones de los muros
                matrizPueblo[9][17-i] = muros2[i];
                muros2[i].setPosx(9);
                muros2[i].setPosy(17-i);
            }
            //agrega la estructura a vista
            vista.getPnlCampo().add(muros2[i].getPnlEstructura());
        }
    }
    //pone las defensas en vista
    public void colocarDefensas(Pantalla vista){
        
        guardarArchivos archivo = OperacionesGuardado.leer("hola");
        if(archivo == null){
            cantidadDefensas += (nivel-1);//total de defensas le agrega una defensa adicional cuando pasa de nivel
        Estructuras defensas[] = new Estructuras[cantidadDefensas];
        int x = 1;
        int y = 1;
        int x2 = 1;
        int y2 = 1;
        //listas para evitar que se repitan posiciones
        listax = new int[cantidadDefensas];
        listay = new int[cantidadDefensas];
        listax2 = new int[cantidadDefensas];
        listay2 = new int[cantidadDefensas];
        int [] tipos = new int[cantidadDefensas];
        for (int i = 0; i < cantidadDefensas; i++) {
            boolean buscar = true;//true mientras busca una posicion no repetida
            int tipo = random.nextInt(5);//selecciona que defensa va a crear
            tipos[i] = tipo;
            defensas[i] = new Estructuras(this);
            while(buscar){
                //pixeles maximos del pueblo y pixeles donde se encuentra la estructura
                x = random.nextInt(1105);
                y = random.nextInt(600);
                //posiciones de la estructura
                x2 = x/100;
                y2 = y/100;
                boolean salir = true;//true mientras busca una posicion no repetida
                //limites de pixeles del pueblo(evita que caiga en el ayuntamiento los 2 primeros y los otros 2 evitan que salgan del muro)
                if ((x<605 || x>845) && (y<230 || y>470) && x<1105 && x>385 && y<600 && y>160) {
                    if (i!=0) {//entre solo si no es la primera vez
                        for (int j = 0; j < listax2.length; j++) {
                            if (listax2[j]==x2 && listay2[j]==y2) {// si existe en la lista de posiciones vuelve a buscar
                                salir = false;
                            // si existe en la lista de pixeles+50 o -50 vuelve a buscar
                            }else if ((listax[j]<=x+50 && listax[j]>=x-50) && (listay[j]<=y+50 && listay[j]>=y-50)) {
                                salir = false;
                            }
                        }
                    }
                    if (salir) {// si sale
                        //agrega los datos a las listas para evitar repeticiones
                        listax[i] = x;
                        listay[i] = y;
                        listax2[i] = x2;
                        listay2[i] = y2;
                        //posiciones de la estructura
                        matrizPueblo[x2][y2] = defensas[i];
                        defensas[i].setPosx(x2);
                        defensas[i].setPosy(y2);
                        buscar = false;//permite salir del for()
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
            archivo = new guardarArchivos(nivel,listax,listax2,listay,listay2,tipos);
            OperacionesGuardado.guardar("hola", archivo);
        }
        else{
            cantidadDefensas += (archivo.nivel-1);
            Estructuras defensas[] = new Estructuras[cantidadDefensas];
            int []tipos = archivo.tipos;
            listax = archivo.listax;
            listay = archivo.listay;
            listax2 = archivo.listax2;
            listay2 = archivo.listay2;
            for (int i = 0; i < cantidadDefensas; i++) {
                defensas[i] = new Estructuras(this);
                matrizPueblo[listax2[i]][listay2[i]] = defensas[i];
                defensas[i].setPosx(listax2[i]);
                defensas[i].setPosy(listay2[i]);
                switch (tipos[i]) {
                    case 0:
                        defensas[i].cannon(listax[i], listay[i]);
                        break;
                    case 1:
                        defensas[i].aereos(listax[i], listay[i]);
                        break;
                    case 2:
                        defensas[i].bombas(listax[i], listay[i]);
                        break;
                    case 3:
                        defensas[i].mortero(listax[i], listay[i]);
                        break;
                    case 4:
                        defensas[i].torre(listax[i], listay[i]);
                        break;
                    default:
                        break;
                }

                vista.getPnlCampo().add(defensas[i].getPnlEstructura());
            }
        }
    }
    //imprime si hay algo en la posicion de la matriz sino imprime Null
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
    //inicia el threadDestruccion
    public void iniciarDestruccion(Pantalla vista){
        threadDestruccion = new ThreadDestruccion(this, vista);
        threadDestruccion.start();
    }
    //pone el porcentaje de destruccion del pueblo
    public void porcentajeDestruccion(Pantalla vista){
        //crear espacio en pantalla para ver destruccion
    }
    //getter and setter
    public Estructuras[][] getMatrizPueblo() {
        return matrizPueblo;
    }

    public ThreadDestruccion getThreadDestruccion() {
        return threadDestruccion;
    }

    public int getCantidadDefensas() {
        return cantidadDefensas;
    }

    public int getNivel() {
        return nivel;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
    
}
