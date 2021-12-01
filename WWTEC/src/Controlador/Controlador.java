
package Controlador;
import Modelo.ModeloEjercito;
import Modelo.ModeloPueblo;
import Modelo.guardarArchivos;
import Vista.Pantalla;
import java.util.ArrayList;


/**
 *
 * @author tefad
 */
public class Controlador{
    private Pantalla vista;
    private ModeloPueblo modeloP;
    private ModeloEjercito modeloE;
    private guardarArchivos informacion;
    
    public Controlador(Pantalla vista, ModeloPueblo modeloP, ModeloEjercito modeloE, guardarArchivos informacion) {
        this.informacion = informacion;
        this.vista = vista;
        this.modeloP = modeloP;
        this.modeloE = modeloE;  
    }
    
    public void iniciar(int [] arreglo){
        modeloP.colocarAyuntamiento(vista);
        modeloP.colocarMuros(vista);
        modeloP.colocarDefensas(vista);
        modeloE.placeEjercito(arreglo, vista, modeloP.getMatrizPueblo(), informacion);
        modeloP.inciarEstructuras(modeloE);
        modeloP.iniciarDestruccion(vista, this, modeloE);
        modeloP.porcentajeDestruccion(vista);
    }
    
}
