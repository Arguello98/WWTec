/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static java.lang.Thread.sleep;

/**
 *
 * @author tefad
 */
public class Avion extends Ejercito {
    private boolean isRunning = true;
    
    @Override
    public void Moverse(){
        
    }
    
    @Override
    public void Atacar(){
        
    }
    
    public void run(){
        while(isRunning){
            try {
                sleep(1000);
                
            } 
            catch (InterruptedException ex) {
                
            } 
        }
    }
}
