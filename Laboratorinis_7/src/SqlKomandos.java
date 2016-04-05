
import Grafika.Atnaujinimas;
import ReikiamasDuomenuKlases.Grupe;
import ReikiamasDuomenuKlases.Studentas;
import ReikiamasDuomenuKlases.VaizdavimoDuomenys;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eimantas
 */
public class SqlKomandos {
        
        Connection conn;
        int dydis;
        DateFormat dateFormat;
        private  ArrayList<VaizdavimoDuomenys> ciaVisi=null;
        public SqlKomandos(Connection conn){
          this.conn=conn;
          dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
        }
       
        
        ArrayList<VaizdavimoDuomenys> getVaizdas() {
        ArrayList<VaizdavimoDuomenys> visi=new ArrayList<>();
          try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT Id, nrstud, data, pazimys, aprasymas FROM Ivertinimas";
            String sql2 = "SELECT vardas, pavarde, grupe FROM Studentas WHERE Id=?";
            ResultSet rs = stmt.executeQuery(sql);
            PreparedStatement kintamasis = conn.prepareStatement(sql2);
            ResultSet rs2 = null;
            while(rs.next()){
               int id=rs.getInt("Id");
               int nr=rs.getInt("nrstud");
               String data=rs.getString("data");
               int paz=rs.getInt("pazimys");
               String ap=rs.getString("aprasymas");
               kintamasis.setInt(1, nr);
               rs2=kintamasis.executeQuery();
               String studentas="";
               while(rs2.next()){
                   studentas=rs2.getString("vardas");
                   studentas+=" "+rs2.getString("pavarde");
                   studentas+=" "+rs2.getString("grupe");
               }
               visi.add(new VaizdavimoDuomenys(data, paz, studentas, ap,nr,id));
            }
            stmt.close();
            kintamasis.close();
            rs.close();
            rs2.close();
            dydis=visi.size();
            ciaVisi=visi;
            return visi;
        } catch (Exception ex) {
            System.out.println("klaida_6");
             }
        return null;
    }
        
       
     ArrayList<Grupe> gautiGrupes() {
        ArrayList<Grupe> visos=new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT Id,kodas FROM Grupe";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id=rs.getInt("Id");
                String kodas=rs.getString("kodas");
                visos.add(new Grupe(id,kodas));
            }
            stmt.close();
            rs.close();
            return visos;
        } catch (Exception ex) {
            System.out.println("klaida_2");
             }
        return null;
    }

     ArrayList<Studentas> getVisiStudentai() {
        ArrayList<Studentas> visi=new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT vardas, pavarde, grupe, Id FROM Studentas";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String vardas= rs.getString("vardas");
                String pavarde= rs.getString("pavarde");
                String grupe= rs.getString("grupe");
                int id=rs.getInt("Id");
                visi.add(new Studentas(vardas,pavarde,grupe,id));
            }
            stmt.close();
            rs.close();
            return visi;
        } catch (Exception ex) {
            System.out.println("klaida_4");
             }
        return null;
    }  
     
     
     void pridetiNaujaGrupe(String kodas, String studprog, int metai){
            try{
            String sql = "INSERT INTO Grupe VALUES(?,?,?)";
            PreparedStatement prideti = conn.prepareStatement(sql);
            prideti.setString(1, kodas);
            prideti.setString(2, studprog);
            prideti.setInt(3, metai);
            prideti.executeUpdate();
            prideti.close();
            }
            catch (Exception ex) {
            System.out.println("klaida_1");
            }
     }
     
     
     void pridetiStudenta(String grupe, int grupesNr, String vardas, String pavarde, int studNr){
            try{
            String sql = "INSERT INTO Studentas VALUES(?,?,?,?,?)";
            PreparedStatement prideti = conn.prepareStatement(sql);
            prideti.setString(1, grupe);
            prideti.setInt(2, grupesNr);
            prideti.setString(3, vardas);
            prideti.setString(4, pavarde);
            prideti.setInt(5, studNr);
            prideti.executeUpdate();
            prideti.close(); 
            }
            catch(Exception ex){
                System.out.println("Klaida_3");
            }
     }
     
     
     void pridetiIvertinima(int studNr, String data, int pazimys, String aprasas){
         try{
            String sql = "INSERT INTO Ivertinimas VALUES(?,?,?,?)";
            PreparedStatement prideti = conn.prepareStatement(sql);
            prideti.setInt(1, studNr);
            prideti.setString(2, data);
            prideti.setInt(3, pazimys);
            prideti.setString(4, aprasas);
            prideti.executeUpdate();
            prideti.close();   
         }
         catch (Exception ex){
             System.out.println("Klaida_6");
         }
     }

    int getKurisRadaguojamas(String one, String two, int three, String four) {
       int k=0;
       int i=0;
       for (VaizdavimoDuomenys a:ciaVisi){
           if(one.equals(a.getPavadinimas())&& two.trim().equals(a.getData()) && three==a.getPazimys() && four.equals(a.getAprasas())){
               k=i;
               break;
           }
           i++;
       }
       return k;
    }
    // senas yra naujas
    void keistiStudenta(int kuris, String senas, String one, String two){
        if (!ciaVisi.get(kuris).getPavadinimas().equals(senas)){
           // System.out.println(ciaVisi.get(kuris).getStudnr());
            String [] data = senas.split(" ");
          //  System.out.println(data[0]+" "+ data[1]+" "+ data[2]);
            if (data.length==3){
            Atnaujinimas at=new Atnaujinimas(null, true, one, two);
            at.setVisible(true);
            if (at.t==true){
                try{
                   String sql = "UPDATE Studentas SET grupe = ?, vardas=?, pavarde=? WHERE Id=?";
                   PreparedStatement prideti = conn.prepareStatement(sql);
                   prideti.setString(1, data[2]);
                   prideti.setString(2, data[0]);
                   prideti.setString(3, data[1]);
                   prideti.setInt(4, ciaVisi.get(kuris).getStudnr());
                   prideti.executeQuery();
                   prideti.close();
         
                }
                catch(Exception ex){
                    
                }
            }
        }
        }
    }
        // senas yra naujas
    void keistiData(int kuris, String senas, String one, String two){
        boolean tt=false;
       if (!ciaVisi.get(kuris).getData().equals(senas)){
           try{
            Date tew=dateFormat.parse(senas);
            tt=true;  
           }
        catch (Exception ex){
          /*  jButton1.setBackground(Color.red); */ }
          if (tt==true){ 
          Atnaujinimas at=new Atnaujinimas(null, true, one, two);
          at.setVisible(true); 
          if (at.t==true){
               try{
                   String sql = "UPDATE Ivertinimas SET data = ? WHERE Id=?";
                   PreparedStatement prideti = conn.prepareStatement(sql);
                   prideti.setString(1, senas);
                   prideti.setInt(2, ciaVisi.get(kuris).getId());
                   prideti.executeQuery();
                   prideti.close();
                }
                catch(Exception ex){
                    
                }  
          }
       } 
       }
    }
        // senas yra naujas
    void keistiIvertinima(int kuris, String senas, String one, String two){
        if(!ciaVisi.get(kuris).getAprasas().equals(senas)){
             Atnaujinimas at=new Atnaujinimas(null, true, one, two);
            at.setVisible(true);
            if (at.t==true){
                try{
                   String sql = "UPDATE Ivertinimas SET pazimys = ? WHERE Id=?";
                   PreparedStatement prideti = conn.prepareStatement(sql);
                   prideti.setInt(1, Integer.parseInt(senas));
                   prideti.setInt(2, ciaVisi.get(kuris).getId());
                   prideti.executeQuery();
                   prideti.close();
                }
                catch(Exception ex){
                    
                } 
            }
        }
    }
        // senas yra naujas
    void keistiAprasa(int kuris, String senas, String one, String two){
        if(!ciaVisi.get(kuris).getAprasas().equals(senas)){
            Atnaujinimas at=new Atnaujinimas(null, true, "Pasirinkite", "Ar tikrai norite atnaujinti duomeni?");
            at.setVisible(true);
            if (at.t==true){
                try{
                   String sql = "UPDATE Ivertinimas SET aprasymas = ? WHERE Id=?";
                   PreparedStatement prideti = conn.prepareStatement(sql);
                   prideti.setString(1, senas);
                   prideti.setInt(2, ciaVisi.get(kuris).getId());
                   prideti.executeQuery();
                   prideti.close();
                }
                catch(Exception ex){
                }
                
            }
        }
    }
        
}
