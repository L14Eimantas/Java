/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafika;

import Labirinto_dalys.Kryptys;
import Labirinto_dalys.Labirintas;
import Labirinto_dalys.Langelis;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Eimantas
 */
public class LabirintoRedagavimas extends javax.swing.JPanel {

    /**
     * Creates new form LabirintoRedagavimas
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
    public LabirintoRedagavimas() {
        initComponents();
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
    }// </editor-fold>//GEN-END:initComponents


    public void paintComponent(Graphics g) {
        m = 50;
        super.paintComponent(g);
        setBackground(s1);
        float dash1[] = {5.0f, 1.0f};
        BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash1, 0.0f);
        BasicStroke solid = new BasicStroke(3.0f);
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
     
                    } else {
                        g.setColor(Color.lightGray);
                        ((Graphics2D) g).setStroke(dashed);
                    }
                    g.drawLine(m * (j + 1), m * (i), m * (j + 1), m * (i + 1));
                    if (!s.galiEiti[Kryptys.APACIA.ordinal()]) {
                        g.setColor(s2);
                        ((Graphics2D) g).setStroke(solid);
                         g.drawLine(m * (j), m * (i + 1), m * (j + 1), m * (i + 1));
                    } else {
                        g.setColor(Color.lightGray);
                        ((Graphics2D) g).setStroke(dashed);
                    }
                    g.drawLine(m * (j), m * (i + 1), m * (j + 1), m * (i + 1));
                }
            }            
            try{  
                if (ll.galiEiti[kk.ordinal()]){
                    g.setColor(s2);
                    ((Graphics2D) g).setStroke(solid);
                }
                else{
                    g.setColor(Color.white);
                    ((Graphics2D) g).setStroke(dashed);    
                } 
                switch(kk.ordinal())   
                {
                    case 0:
                        g.drawLine(ll.getSt()*m,ll.getEil()*m,(ll.getSt()+1)*m,ll.getEil()*m); //virsus 
                        break;
                    case 1:
                        g.drawLine(m*(ll.getSt()+1), m*ll.getEil(), m*(ll.getSt()+1), (1+ll.getEil())*m);//desine
                        break;
                     case 2:    
                        g.drawLine(m*ll.getSt(), m*(ll.getEil()+1), m*(ll.getSt()+1), m*(ll.getEil()+1)); //apcia
                        break;
                    case 3:
                        g.drawLine(ll.getSt()*m, ll.getEil()*m, m*ll.getSt(), m*(ll.getEil()+1));//kaire
                        break;
                    default:
                        break;
                }
            }
            catch(Exception e)
            {}
            
            
        } 
        ll=null;// kad pasinaikintu paskutine regavavimui pavuosta vieta (mousemoved) 
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
