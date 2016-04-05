
import Grafika.NaujaGrupe;
import Grafika.NaujasIvertinimas;
import Grafika.StudentoIvedimas;
import ReikiamasDuomenuKlases.Grupe;
import ReikiamasDuomenuKlases.Studentas;
import ReikiamasDuomenuKlases.VaizdavimoDuomenys;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eimantas
 */
public class Systema extends javax.swing.JFrame {

    /**
     * Creates new form Systema
     */
    Connection conn;
    DefaultTableModel dtm;
    SqlKomandos sqlKom;
    DateFormat dateFormat;
    private Locale enLocale ;
    private  ResourceBundle mess;
    int kuris=0;
    public Systema() {
        try {
            enLocale = new Locale("lt", "LT");
            mess = ResourceBundle.getBundle("Texts", enLocale);
            Properties pr = new Properties();
            InputStream input = new FileInputStream("config.properties");
            pr.load(input);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String conURL="jdbc:sqlserver://localhost:1433;databaseName="+pr.getProperty("databaseName");
            String USER = pr.getProperty("login");
            String PASS = pr.getProperty("pass");
            Connection conn=DriverManager.getConnection(conURL,USER,PASS);
            sqlKom=new SqlKomandos(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("klaida "+ ex.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Systema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Systema.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setTitle(mess.getString("1title"));
        initComponents();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
        jTextField2.setText(dateFormat.format(new Date()));
        incinizuotiComboBox(mess.getString("combox"));
        dtm = new DefaultTableModel(0, 0);
        incinizuotiTeksta();
        jTable1.setModel(dtm);
        braizytiLentele(null);         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("jLabel1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jMenu1.setText("File");

        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("jMenuItem3");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem4.setText("Lietuviu");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("English");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void incinizuotiTeksta(){
        this.jMenu1.setText(mess.getString("1meniu1"));
        this.jMenu2.setText(mess.getString("1meniu2"));
        this.jMenuItem1.setText(mess.getString("1meniuitem1"));
        this.jMenuItem2.setText(mess.getString("1meniuitem2"));
        this.jMenuItem3.setText(mess.getString("1meniuitem3"));    
        this.jLabel1.setText(mess.getString("1label1"));
        this.jButton1.setText(mess.getString("1button1"));
        this.jLabel2.setText(mess.getString("1label2"));
        this.jLabel3.setText(mess.getString("1label3"));
          String header[] = new String[] { mess.getString("1header1"), mess.getString("1header2"), mess.getString("1header3"), 
                mess.getString("1header4"), mess.getString("1header5")};
        dtm.setColumnIdentifiers(header);
    }    
//pridedama nauja grupe
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
            // TODO add your handling code here:
            NaujaGrupe naujas= new NaujaGrupe(this, true, mess.getString("2title"), mess.getString("2label1"), mess.getString("2label2"),
                    mess.getString("2label3"), mess.getString("2button1"));
            naujas.setVisible(true);
            String kodas=naujas.kodas;
            String studprog=naujas.studprog;
            int metai=naujas.metai;
            if (naujas.t==true){
              sqlKom.pridetiNaujaGrupe(kodas, studprog, metai);
            }
         
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // cia bus visu srautu uzdarymas (duomenu bazes)
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            // TODO add your handling code here:
            conn.close();
        } catch (Exception ex) {
            
        }
    }//GEN-LAST:event_formWindowClosing
    
    // prideti studenta
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
   
        ArrayList<Grupe> visosGrupes= sqlKom.gautiGrupes();
        if (visosGrupes!=null && !visosGrupes.isEmpty()){
            StudentoIvedimas iv= new StudentoIvedimas(this, true, visosGrupes,mess.getString("3title"),mess.getString("3label1"),mess.getString("3label2"),
                    mess.getString("3label3"), mess.getString("3label4"),mess.getString("3button1") );
            iv.setVisible(true);
            if (iv.t==true){
              sqlKom.pridetiStudenta(iv.grupe, iv.grupesNr, iv.vardas,  iv.pavarde, iv.studNr);
              incinizuotiComboBox(mess.getString("combox"));
            }
        }   
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    
    // prideti nauja ivertinima
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
       
        ArrayList<Studentas> visi=sqlKom.getVisiStudentai();
        if (visi!=null && !visi.isEmpty()){
            NaujasIvertinimas ni=new NaujasIvertinimas(this, true, visi, mess.getString("4title"), mess.getString("4label1"), mess.getString("4label2"), 
                    mess.getString("4label3"), mess.getString("4label4"), mess.getString("4button1"));
            ni.setVisible(true);
            if (ni.t==true){
                sqlKom.pridetiIvertinima(ni.studNr,  ni.data, ni.pazimys, ni.aprasas); 
                trintiLentele();
                braizytiLentele(null);
                jComboBox1.setSelectedIndex(0);
            }
           
        }
      
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String txt=(String) jComboBox1.getSelectedItem();
        String date1=jTextField1.getText().trim();
        String date2=jTextField2.getText();
        boolean v=false;// date1 tuscias
        boolean d=false;// npakeista data2
        boolean t=false;// ComboBox 0 indeksas
        boolean tt=false;Date one = null; Date two = null;
        if (!date1.isEmpty() && date1!=""  ){
            v=true;}
        if (jComboBox1.getSelectedIndex()!=0){
            t=true;}
        try {
            if (dateFormat.parse(date2).compareTo(dateFormat.parse(dateFormat.format(new Date())))!=0){
                d=true;}
        } catch (Exception ex) {
         /* jButton1.setBackground(Color.red) */}
        if (v==true){
        try{
            one=dateFormat.parse(date1);
            two=dateFormat.parse(date2);
            tt=true;  }
        catch (Exception ex){
          /*  jButton1.setBackground(Color.red); */ }
        }
        if (v==false && d==false && t==false){
            trintiLentele();
            braizytiLentele(null);
        }else if (v==false && d==false && t==true){
            trintiLentele();
            braizytiLentele(txt);
        } else  if (v==true && t==true && tt==true){
            trintiLentele();
            try {  
                braizytiLentele(txt,one,two);
            } catch (ParseException ex) {
                Logger.getLogger(Systema.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (v==true && t==false && tt==true){
            trintiLentele();
            try { 
                braizytiLentele(null,one,two);
            } catch (ParseException ex) {
                Logger.getLogger(Systema.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            trintiLentele(); 
            jComboBox1.setSelectedIndex(0);
            jTextField2.setText(dateFormat.format(new Date()));
            braizytiLentele(null);
        }
      
       
  
    }//GEN-LAST:event_jButton1ActionPerformed
   //koregavimas
    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        
        int kurisStulpelis=jTable1.getSelectedColumn();
        if (evt.getKeyCode()==10){
            if (kurisStulpelis==1){
               sqlKom.keistiStudenta(kuris,(String)dtm.getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn()),mess.getString("5title"),mess.getString("5label"));
            }else if (kurisStulpelis==2){
               sqlKom.keistiData(kuris,(String)dtm.getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn()),mess.getString("5title"),mess.getString("5label"));
            }else if (kurisStulpelis==3){
                sqlKom.keistiIvertinima(kuris,(String)dtm.getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn()),mess.getString("5title"),mess.getString("5label"));
            }else if (kurisStulpelis==4){
                sqlKom.keistiAprasa(kuris,(String)dtm.getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn()),mess.getString("5title"),mess.getString("5label"));
            }
            trintiLentele(); 
            braizytiLentele(null);
        }
    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
          int row = jTable1.rowAtPoint(evt.getPoint());
          int col = jTable1.columnAtPoint(evt.getPoint());
          kuris=sqlKom.getKurisRadaguojamas((String)dtm.getValueAt(row, 1), (String)dtm.getValueAt(row, 2), (Integer)dtm.getValueAt(row, 3), (String)dtm.getValueAt(row, 4));
    }//GEN-LAST:event_jTable1MouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
         enLocale = new Locale("lt", "LT");
          mess = ResourceBundle.getBundle("Texts", enLocale);
           incinizuotiTeksta();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
         enLocale = new Locale("en", "GB");
         mess = ResourceBundle.getBundle("Texts", enLocale);
          incinizuotiTeksta();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
            java.util.logging.Logger.getLogger(Systema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Systema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Systema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Systema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Systema().setVisible(true);
             
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
   
    private void incinizuotiComboBox(String txt){
        jComboBox1.removeAllItems();
        jComboBox1.addItem(txt);
        for(Studentas a: sqlKom.getVisiStudentai()){
            jComboBox1.addItem(a.getVardas()+" "+a.getPavarde()+" "+a.getGrupe());
        }
    }
    
    private void trintiLentele(){
     
        for (int i=sqlKom.dydis-1;i>-1; i--){
            dtm.removeRow(i);
        }
    }
    
    
    private void braizytiLentele(String txt){
        ArrayList<VaizdavimoDuomenys> vaiz= sqlKom.getVaizdas();
        int k=1;
        if (vaiz!=null && !vaiz.isEmpty()){
           for (int count = 0; count < vaiz.size(); count++) {
            if (txt==null){
                dtm.addRow(new Object[] { k, vaiz.get(count).getPavadinimas(),
                   vaiz.get(count).getData(), vaiz.get(count).getPazimys(), vaiz.get(count).getAprasas()
                });
                k++;
                }
               else {
                    if (txt.equals(vaiz.get(count).getPavadinimas())){
                         dtm.addRow(new Object[] { k, vaiz.get(count).getPavadinimas(),
                            vaiz.get(count).getData(), vaiz.get(count).getPazimys(), vaiz.get(count).getAprasas()
                         });
                         k++;
                    }
                }
           sqlKom.dydis=k-1;
        }
    }
    }

    private void braizytiLentele(String txt, Date one, Date two) throws ParseException {
        ArrayList<VaizdavimoDuomenys> vaiz= sqlKom.getVaizdas();
        int k=1;
        if (vaiz!=null && !vaiz.isEmpty()){
           if (txt!=null){
              for (int count = 0; count < vaiz.size(); count++) {
                if (txt.equals(vaiz.get(count).getPavadinimas()) && one.compareTo(dateFormat.parse(vaiz.get(count).getData()))==-1 && two.compareTo(dateFormat.parse(vaiz.get(count).getData()))==1){
                     dtm.addRow(new Object[] { k, vaiz.get(count).getPavadinimas(),
                            vaiz.get(count).getData(), vaiz.get(count).getPazimys(), vaiz.get(count).getAprasas()
                         });
                    k++;
                }
              }
            
           }else{
             for (int count = 0; count < vaiz.size(); count++) {
                if (one.compareTo(dateFormat.parse(vaiz.get(count).getData()))==-1 && two.compareTo(dateFormat.parse(vaiz.get(count).getData()))==1){
                     dtm.addRow(new Object[] { k, vaiz.get(count).getPavadinimas(),
                            vaiz.get(count).getData(), vaiz.get(count).getPazimys(), vaiz.get(count).getAprasas()
                         });
                    k++;
                }
              }  
               
           }
        }
        sqlKom.dydis=k-1; 
    }
 
}