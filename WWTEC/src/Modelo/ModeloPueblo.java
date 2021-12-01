/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controlador;
import Vista.Pantalla;
import java.util.Random;
import javax.swing.JLabel;

public final class ModeloPueblo {
    
    private Estructuras matrizPueblo[][] = new Estructuras[21][21];
    private int cantidadDefensas = 13;
    private int nivel = 1;
    private Random random = new Random();
    private int[] listax;
    private int[] listay;
    private int[] listaPX;
    private int[] listaPY;
    private ThreadDestruccion threadDestruccion;
    private double porcentaje = 0.0;
    private javax.swing.JLabel lblPorcentage;
    //pone el ayuntamiento en vista
    public void colocarAyuntamiento(Pantalla vista){
        Estructuras ayuntamiento = new Estructuras(this);
        //pixeles del ayuntamiento
        ayuntamiento.ayuntamiento(10*35, 10*35);
        ayuntamiento.setPosx(10);
        ayuntamiento.setPosy(10);
        //posiciones del ayuntamiento
        matrizPueblo[10][10] = ayuntamiento;
        //agrega la estructura a vista
        vista.getPnlCampo().add(ayuntamiento.getPnlEstructura());
    }
    //pone los muros en vista
    public void colocarMuros(Pantalla vista){
        //total de muros
        Estructuras muros[] = new Estructuras[56];
        //pixeles del muro de la esquina superior izquierda
        int x = 3;
        int y = 3;
        int px;
        int py;
        for (int i = 0; i < muros.length; i++) {//i es igual al muro por el que va
            muros[i] = new Estructuras(this);
            //pixeles de los muros
            px = x*35;
            py = y*35;
            muros[i].muro(px, py);
            //posiciones de los muros
            matrizPueblo[x][y] = muros[i];
            muros[i].setPosx(x);
            muros[i].setPosy(y);
            if (i <= 13) {
                x += 1;
            }else if(i>13 && i<=27){
                y += 1;
                //System.out.println(x+"--"+y);
            }else if(i>27 && i<=41){
                x -= 1;
            }else if(i>41){
                y -= 1;
            }
            //agrega la estructura a vista
            vista.getPnlCampo().add(muros[i].getPnlEstructura());
        }
        
        //muros que rodean el ayuntamiento
        Estructuras muros2[] = new Estructuras[10];
        //pixeles del muro esquina superior izquierda que rodea el ayuntamiento
        x = 9;
        y = 9;
        for (int i = 0; i < muros2.length; i++) {
            muros2[i] = new Estructuras(this);
            //pixeles de los muro
            px = x*35;
            py = y*35;
            muros2[i].muro(px, py);
            //posiciones de los muros
            matrizPueblo[x][y] = muros2[i];
            muros2[i].setPosx(x);
            muros2[i].setPosy(y);
            if (i<=1) {
                x += 1;
            }else if(i>1 && i<=3){
                //evita que la esquina salga mal
                if (i == 2) {
                    x+=2;
                }
                y += 1;
                //System.out.println(x+"--"+y);
            }else if(i>3 && i<=6){
                x -= 1;
                //posiciones de los muros
            }else if(i>6){
                //evita que la esquina salga mal
                if (i == 7) {
                    x-=2;
                }
                y -= 1;
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
            int x = 0;
            int y = 0;
            int px = 0;
            int py = 0;
            //listas para evitar que se repitan posiciones
            listax = new int[cantidadDefensas];
            listay = new int[cantidadDefensas];
            listaPX = new int[cantidadDefensas];
            listaPY = new int[cantidadDefensas];
            int [] tipos = new int[cantidadDefensas];
            for (int i = 0; i < cantidadDefensas; i++) {
                boolean buscar = true;//true mientras busca una posicion no repetida
                int tipo = random.nextInt(5);//selecciona que defensa va a crear
                tipos[i] = tipo;
                defensas[i] = new Estructuras(this);
                while(buscar){
                    //pixeles maximos del pueblo y pixeles donde se encuentra la estructura
                    x = random.nextInt(17);
                    y = random.nextInt(17);
                    //posiciones de la estructura
                    px = x*35;
                    py = y*35;
                    boolean salir = true;//true mientras busca una posicion no repetida
                    //limites de pixeles del pueblo(evita que caiga en el ayuntamiento los 2 primeros y los otros 2 evitan que salgan del muro)
                    //System.out.println(x+"---"+y);
                    if ((x<9 || x>13) && (y<9 || y>11) && x>3 && y>3) {
                        if (i!=0) {//entre solo si no es la primera vez
                            for (int j = 0; j < listaPX.length; j++) {
                                if (listax[j]==x && listay[j]==y) {// si existe en la lista de posiciones vuelve a buscar
                                    salir = false;
                                // si existe en la lista de pixeles+50 o -50 vuelve a buscar
                                }else if ((listaPX[j]<=px+35 && listaPX[j]>=px-35) && (listaPY[j]<=py+35 && listaPY[j]>=py-35)) {
                                    salir = false;
                                }
                            }
                        }
                        if (salir) {// si sale
                            //agrega los datos a las listas para evitar repeticiones
                            listax[i] = x;
                            listay[i] = y;
                            listaPX[i] = px;
                            listaPY[i] = py;
                            //posiciones de la estructura
                            matrizPueblo[x][y] = defensas[i];
                            defensas[i].setPosx(x);
                            defensas[i].setPosy(y);
                            buscar = false;//permite salir del for()
                            }
                        }
                    }
                    //System.out.println(px+"--"+py);
                    switch (tipo) {
                        case 0:
                            defensas[i].cannon(px, py);
                            break;
                        case 1:
                            defensas[i].aereos(px, py);
                            break;
                        case 2:
                            defensas[i].bombas(px, py);
                            break;
                        case 3:
                            defensas[i].mortero(px, py);
                            break;
                        case 4:
                            defensas[i].torre(px, py);
                            break;
                        default:
                            break;
                    }

                    vista.getPnlCampo().add(defensas[i].getPnlEstructura());
                }
            archivo = new guardarArchivos(nivel,listax,listaPX,listay,listaPY,tipos);
            OperacionesGuardado.guardar("hola", archivo);
            
        }
        else{
            cantidadDefensas += (archivo.nivel-1);
            Estructuras defensas[] = new Estructuras[cantidadDefensas];
            int []tipos = archivo.tipos;
            listax = archivo.listax;
            listay = archivo.listay;
            listaPX = archivo.listax2;
            listaPY = archivo.listay2;
            for (int i = 0; i < cantidadDefensas; i++) {
                defensas[i] = new Estructuras(this);
                matrizPueblo[listax[i]][listay[i]] = defensas[i];
                defensas[i].setPosx(listax[i]);
                defensas[i].setPosy(listay[i]);
                switch (tipos[i]) {
                    case 0:
                        defensas[i].cannon(listaPX[i], listaPY[i]);
                        break;
                    case 1:
                        defensas[i].aereos(listaPX[i], listaPY[i]);
                        break;
                    case 2:
                        defensas[i].bombas(listaPX[i], listaPY[i]);
                        break;
                    case 3:
                        defensas[i].mortero(listaPX[i], listaPY[i]);
                        break;
                    case 4:
                        defensas[i].torre(listaPX[i], listaPY[i]);
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
                try {
                    System.out.println(matrizPueblo[i][j].getNombre());
                    System.out.println(i+"--"+j);
                } catch (Exception e) {
                    //System.out.println("Null");
                }
            }
        }
    }
    //inicia el threadDestruccion
    public void iniciarDestruccion(Pantalla vista, Controlador jugador, ModeloEjercito ejercito){
        threadDestruccion = new ThreadDestruccion(this, vista, jugador, ejercito);
        threadDestruccion.start();
    }
    //pone el porcentaje de destruccion del pueblo sd
    public void porcentajeDestruccion(Pantalla vista){
        //espacio en pantalla para ver destruccion
        javax.swing.JPanel pnlDestruccion = new javax.swing.JPanel();
        pnlDestruccion.setBounds(525, 5, 200, 50);
        lblPorcentage = new javax.swing.JLabel();
        lblPorcentage.setText("Destrucción total: " + porcentaje);
        pnlDestruccion.add(lblPorcentage);
        vista.getPnlCampo().add(pnlDestruccion);
    }
    //inicia los threads
    public void inciarEstructuras(ModeloEjercito ejercito){
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                try {
                    matrizPueblo[i][j].getThreadEstructuras().setEjercito(ejercito);
                    matrizPueblo[i][j].getThreadEstructuras().start();
                } catch (Exception e) {}
            }
        }
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

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public JLabel getLblPorcentage() {
        return lblPorcentage;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
    
}
