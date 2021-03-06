/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafika;

import Labirinto_dalys.Kryptys;
import Labirinto_dalys.Labirintas;
import Labirinto_dalys.Langelis;
import Labirinto_dalys.Taskas;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Eimantas
 */
public class Piesinys extends javax.swing.JPanel {

    /**
     * Creates new form Piesinys
     */
    //cia mastelis, kad paskui galetumem didinti ar mazinti langelio ploti/auksti

    public int m;
    //cia labirintas ka piesim
    Labirintas l;
    public Kryptys  kk;
    public Langelis ll;
    //cia spalvos, kurias reiketu tinkamai naudoti vaizduojant
    public Color s1, s2, s3;

    public void setL(Labirintas l) {
        this.l = l;
    }
    
    public Piesinys() {
        initComponents();
        s1 = Color.GRAY;
        s2 = Color.black;
        s3 = Color.red;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>                        
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    
    @Override
    public void paintComponent(Graphics g) {
          m = 50;
        super.paintComponent(g);
        setBackground(s1);
        float dash1[] = {5.0f, 1.0f};
        BasicStroke solid = new BasicStroke(3.0f);
        BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash1, 0.0f);
        if (l != null) {
            //piesti labirinta 
            int a = l.getAukstis();
            int p = l.getPlotis();
            int m1 = this.getWidth() / p;
            int m2 = this.getHeight() / a;
            if (m1>m2)
                m = m2;
            else
                m = m1;
            Langelis[][] n = l.getLangeliai();
            g.setColor(s2);
            g.drawLine(0, 0, m * p, 0);
            g.drawLine(0, 0, 0, m * a);
            
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < p; j++) {
                    Langelis s = n[i][j];
                    if (!s.galiEiti[Kryptys.DESINE.ordinal()]) {
                        g.setColor(s2);
                        ((Graphics2D) g).setStroke(solid);
                    }else {
                        g.setColor(Color.lightGray);
                        ((Graphics2D) g).setStroke(dashed);
                    }
                    g.drawLine(m * (j + 1), m * (i), m * (j + 1), m * (i + 1));
                    if (!s.galiEiti[Kryptys.APACIA.ordinal()]) {
                        g.setColor(s2);
                        ((Graphics2D) g).setStroke(solid);
                    }else {
                        g.setColor(Color.lightGray);
                        ((Graphics2D) g).setStroke(dashed);
                    }
                    g.drawLine(m * (j), m * (i + 1), m * (j + 1), m * (i + 1));
                }
            }
            //cia papildomai pridetumet koda, kuris atvaizduotu visus taskus labirinte
            boolean pirmas =true;
            for (Taskas t:l.getTaskai()){
                Langelis lan=t.vieta;
                if (pirmas==true){
                    g.setColor(s3);
                    pirmas=false;
                }else{
                    g.setColor(Color.blue);
                }
                g.fillOval(lan.getSt()*m, lan.getEil()*m, m, m);
                g.setColor(Color.black);
                g.drawString(t.getName().split("_")[1], lan.getSt()*m+(m/2), lan.getEil()*m+(m/2));
                
                
            } //jei bus mouseover, tada pridesite koda, kuris vaizduos ties kuria siena dabar esame  
        } else {
            
            g.drawString("Jus neturite susikure labirinto", 10, 10);
        }
        ll=null;// kad pasinaikintu paskutine regavavimui pavuosta vieta (mousemoved) 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
