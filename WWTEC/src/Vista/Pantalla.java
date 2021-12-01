
package Vista;

import javax.swing.JPanel;

public class Pantalla extends javax.swing.JFrame {

    public Pantalla() {
        initComponents();
        this.setBounds(WIDTH, WIDTH, 770, 770);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCampo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 735, 735));

        pnlCampo.setBackground(new java.awt.Color(102, 153, 0));

        javax.swing.GroupLayout pnlCampoLayout = new javax.swing.GroupLayout(pnlCampo);
        pnlCampo.setLayout(pnlCampoLayout);
        pnlCampoLayout.setHorizontalGroup(
            pnlCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 711, Short.MAX_VALUE)
        );
        pnlCampoLayout.setVerticalGroup(
            pnlCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCampo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCampo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlCampo;
    // End of variables declaration//GEN-END:variables


    public JPanel getPnlCampo() {
        return pnlCampo;
    }
    
}
