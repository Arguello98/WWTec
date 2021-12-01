
package Modelo;

/**
 *
 * @author tefad
 */
import Vista.Pantalla;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author tefad
 */
public class ModeloEjercito {
    int dinero;
    int randomIndex;
    int cantidadSoldados;
    int camposTotales=50;
    int nivelAparicion;
    int costo;
    Random random = new Random();
    private int[] listax;
    private int[] listay;
    private int[] listaPX;
    private int[] listaPY;
    int nivel=1;
    private int contador = 0; 
    private int soldadosTotales = 0;
    //int vida=1;
    private Ejercito matrizEjercito[][] = new Ejercito[21][21];
   
   
    public void placeEjercito(int [] arreglo, Pantalla vista, Estructuras[][] matrizPueblo, guardarArchivos informacion){
        

        Ejercito soldados[] = new SoldadoContacto[50];
        Ejercito medios[] = new MedioAlcance[50];
        Ejercito aereos[] = new Avion[50];
        Ejercito impactos[] = new Impacto[50];
        Ejercito choques[] = new DeChoque[50];

        for(int n=0; n<arreglo.length; n++){
            this.cantidadSoldados=arreglo[n];
            soldadosTotales+=cantidadSoldados;
            int x = 0;
            int y = 0;
            int px = 0;
            int py = 0;
            listax = new int[cantidadSoldados];
            listay = new int[cantidadSoldados];
            listaPX = new int[cantidadSoldados];
            listaPY = new int[cantidadSoldados];
            for (int i = 0; i < cantidadSoldados; i++) {
                boolean buscar = true;
                while(buscar){
                    x = random.nextInt(20)+1;
                    y = random.nextInt(20)+1;
                    px = x*35;
                    py = y*35;
              
                    boolean salir = true;
                    if ((x>17 || x<3) || (y>17 || y<3)) {
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
                            
                            switch (informacion.informacion.get(n).tipo) {
                                case 0:
                                    soldados[i] = new SoldadoContacto(px,py,this);
                                    matrizEjercito[x][y]= soldados[i];
                                    soldados[i].agregados(informacion.informacion.get(n).vida, informacion.informacion.get(n).golpesXTiempo, informacion.informacion.get(n).nombre, 
                                            informacion.informacion.get(n).nombreImagen, informacion.informacion.get(n).nombreImagen2);
                                     //esto se recibe de los archivos 
                                   //this.camposTotales+=soldados[i].getCampos();
                                    soldados[i].matrizPueblo=matrizPueblo;
                                    soldados[i].setMatrizEjercito(matrizEjercito);
                                    soldados[i].start();
                                    
                                    vista.getPnlCampo().add(soldados[i].getPnlEjercito());
                                    break;
                                case 1:
                                   
                                    medios[i] = new MedioAlcance(px,py,this);
                                    matrizEjercito[x][y]= medios[i];
                                    medios[i].agregados(informacion.informacion.get(n).vida, informacion.informacion.get(n).golpesXTiempo, informacion.informacion.get(n).nombre, 
                                            informacion.informacion.get(n).nombreImagen, informacion.informacion.get(n).nombreImagen2);
                                     //esto se recibe de los archivos 
                                    medios[i].matrizPueblo=matrizPueblo;
                                    medios[i].setMatrizEjercito(matrizEjercito); 
                                    medios[i].start();
                                    vista.getPnlCampo().add(medios[i].getPnlEjercito());
                                    break;
                                case 2:
                                   
                                    aereos[i] = new Avion(px,py,this);
                                    matrizEjercito[x][y]= aereos[i];
                                    //esto se recibe de los archivos 
                                    aereos[i].agregados(informacion.informacion.get(n).vida, informacion.informacion.get(n).golpesXTiempo, informacion.informacion.get(n).nombre, 
                                            informacion.informacion.get(n).nombreImagen, informacion.informacion.get(n).nombreImagen2);
                                    aereos[i].matrizPueblo=matrizPueblo;
                                    aereos[i].setMatrizEjercito(matrizEjercito);
                                    aereos[i].start();
                                    vista.getPnlCampo().add(aereos[i].getPnlEjercito());
                                    break;
                                case 3:
                                    impactos[i] = new Impacto(px,py,this);
                                    matrizEjercito[x][y]= impactos[i];
                                     //esto se recibe de los archivos 
                                    impactos[i].agregados(informacion.informacion.get(n).vida, informacion.informacion.get(n).golpesXTiempo, informacion.informacion.get(n).nombre, 
                                            informacion.informacion.get(n).nombreImagen, informacion.informacion.get(n).nombreImagen2);
                                    
                                    impactos[i].matrizPueblo=matrizPueblo;
                                    impactos[i].setMatrizEjercito(matrizEjercito);
                                    impactos[i].start();
                                    vista.getPnlCampo().add(impactos[i].getPnlEjercito());
                                    break;
                                case 4:
                                   
                                    choques[i] = new DeChoque(px,py,this);
                                    matrizEjercito[x][y]= choques[i];
                                     //esto se recibe de los archivos 
                                    choques[i].agregados(informacion.informacion.get(n).vida, informacion.informacion.get(n).golpesXTiempo, informacion.informacion.get(n).nombre, 
                                            informacion.informacion.get(n).nombreImagen, informacion.informacion.get(n).nombreImagen2);
                                    
                                    choques[i].matrizPueblo=matrizPueblo;
                                    choques[i].setMatrizEjercito(matrizEjercito);
                                    choques[i].start();
                                    vista.getPnlCampo().add(choques[i].getPnlEjercito());
                                    break;
                                default:
                                    break;
                            }
                            
                            buscar = false;//permite salir del for()
                        }
                    }    

                }

            }
        }
    
    }
    
    public int getDinero() {
        return dinero;
    }

    public void setDinero(int Dinero) {
        this.dinero = Dinero;
    }

    public Ejercito[][] getMatrizEjercito() {
        return matrizEjercito;
    }
    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public void sumarContador() {
        this.contador++;
    }

    public int getSoldadosTotales() {
        return soldadosTotales;
    }

    public void setSoldadosTotales(int soldadosTotales) {
        this.soldadosTotales = soldadosTotales;
    }
}