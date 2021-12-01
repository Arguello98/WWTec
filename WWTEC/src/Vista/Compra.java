/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.guardarArchivos;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import wwtec.WWTEC;

/**
 *
 * @author tefad
 */
public class Compra extends javax.swing.JFrame {
    guardarArchivos informacion;
    int cantidadGastada;
    int cantidadOcupada;
    JButton [] botones;
    int [] ejercito;
    /**
     * Creates new form Compra
     */
    public Compra(guardarArchivos informacion) {
        this.informacion = informacion;
        initComponents();
        generarBotones();
        setLabels();
    }
    private void generarBotones(){
        botones = new JButton[informacion.informacion.size()];
        ejercito = new int[informacion.informacion.size()];
        int x=0;
        int y=0;
        for (int i = 0; i < botones.length; i++) {
            if(informacion.informacion.get(i).nivelAparicion <= informacion.nivel){
                botones[i] = new JButton();
                panelOpciones.add(botones[i]);
                botones[i].setBounds(x,y,200,100);
                botones[i].setText(informacion.informacion.get(i).nombre);
                botones[i].setActionCommand(String.valueOf(i));
                botones[i].addMouseListener(new MouseAdapter() {
                    public final void mouseClicked(java.awt.event.MouseEvent evt) {

                        clickSobreTablero(evt);

                    }
                });
                y+=100;
                if(y >500){
                    x+=200;
                    y=0;
                }
            }
        }
    }
    
    private void clickSobreTablero(java.awt.event.MouseEvent evt){
        JButton botonPresionado = (JButton)evt.getComponent();
        int espacio = Integer.parseInt(botonPresionado.getActionCommand());
        if(informacion.informacion.get(espacio).espacioOcupado<(20 + informacion.nivel *5 - cantidadOcupada)){
            ejercito[espacio] +=1;
            cantidadOcupada += informacion.informacion.get(espacio).espacioOcupado;
        }
        setLabels();
    }
    
    private void setLabels(){
        this.Nivel.setText("Nivel: " + informacion.nivel);
        this.Dinero.setText("Dinero:" + String.valueOf(informacion.dinero - cantidadGastada));
        this.Espacio.setText("Espacio: " + String.valueOf(20+ informacion.nivel*5  - cantidadOcupada));
    }
    
    public void abrirTienda(){
        this.cantidadGastada = 0;
        this.cantidadOcupada = 0;
        generarBotones();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nivel = new javax.swing.JLabel();
        Espacio = new javax.swing.JLabel();
        Dinero = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        panelOpciones = new javax.swing.JPanel();
        Reiniciar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Nivel.setText("Nivel");

        Espacio.setText("Espacio");

        Dinero.setText("Dinero");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        panelOpciones.setBackground(new java.awt.Color(255, 102, 51));
        panelOpciones.setForeground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Reiniciar.setText("Reiniciar");
        Reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReiniciarActionPerformed(evt);
            }
        });

        jButton1.setText("Empezar Nivel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(Reiniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Dinero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Espacio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Nivel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Espacio, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Dinero, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Reiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReiniciarActionPerformed
       cantidadOcupada = 0;
       cantidadGastada = 0;
        for (int i = 0; i < ejercito.length; i++) {
            ejercito[i] =0;
        }
    }//GEN-LAST:event_ReiniciarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        WWTEC.iniciarPartida(ejercito);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dinero;
    private javax.swing.JLabel Espacio;
    private javax.swing.JLabel Nivel;
    private javax.swing.JButton Reiniciar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel panelOpciones;
    // End of variables declaration//GEN-END:variables
}
