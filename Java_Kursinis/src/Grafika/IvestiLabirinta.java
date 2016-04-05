/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafika;

import java.awt.Color;

/**
 *
 * @author Eimantas
 */
public class IvestiLabirinta extends javax.swing.JDialog {

    /**
     * Creates new form IvestiLabirinta
     */
    public int auks=6;
    public int plot=8;
    public boolean t=false;
    public IvestiLabirinta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    private boolean tryParse(String text)
    {
        if (!text.isEmpty())
        {
        try{
            Integer.parseInt(text);
            return true;
        }
        catch(Exception e){
            return false;
        }
        }
        else
        {
            return true;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        aukstis = new javax.swing.JTextField();
        plotis = new javax.swing.JTextField();
        nustatyti = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nurodykite");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText(" Labirinto Matmenys");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Aukstis:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Plotis:");

        aukstis.setText("6");
        aukstis.setInheritsPopupMenu(true);
        aukstis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aukstisKeyReleased(evt);
            }
        });

        plotis.setText("8");
        plotis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                plotisKeyReleased(evt);
            }
        });

        nustatyti.setText("Nustatyti");
        nustatyti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nustatytiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(nustatyti, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aukstis)
                            .addComponent(plotis))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(aukstis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(plotis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nustatyti)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nustatytiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nustatytiActionPerformed
        // TODO add your handling code here:
        try{
            auks=Integer.parseInt(aukstis.getText());
            plot=Integer.parseInt(plotis.getText());
            t=true;
            this.setVisible(false);
        }
        catch (Exception e)
        {
            nustatyti.setBackground(Color.red);
        }
    }//GEN-LAST:event_nustatytiActionPerformed

    private void aukstisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aukstisKeyReleased
        // TODO add your handling code here ivedimo kontrole
        if (!tryParse(aukstis.getText()))
        {
            while(tryParse(aukstis.getText())==false){
            String laikinas=aukstis.getText();
            laikinas=laikinas.substring(0,laikinas.length()-1);
            aukstis.setText(laikinas);
            }
        }
        if (aukstis.getText().isEmpty())
        {
            nustatyti.setEnabled(false);
        }
        else
            nustatyti.setEnabled(true);
        
        
    }//GEN-LAST:event_aukstisKeyReleased

    private void plotisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_plotisKeyReleased
        // TODO add your handling code here:
        if (!tryParse(plotis.getText()))
        {
            while(tryParse(plotis.getText())==false){
            String laikinas=plotis.getText();
            laikinas=laikinas.substring(0,laikinas.length()-1);
            plotis.setText(laikinas);
            }
        }
        if (plotis.getText().isEmpty())
        {
            nustatyti.setEnabled(false);
        }
        else
            nustatyti.setEnabled(true);
       
    }//GEN-LAST:event_plotisKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IvestiLabirinta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IvestiLabirinta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IvestiLabirinta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IvestiLabirinta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IvestiLabirinta dialog = new IvestiLabirinta(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aukstis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton nustatyti;
    private javax.swing.JTextField plotis;
    // End of variables declaration//GEN-END:variables
}
