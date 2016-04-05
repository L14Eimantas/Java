/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveris;

import Grafika.IvestiLabirinta;
import Labirinto_dalys.Kryptys;
import Labirinto_dalys.Labirintas;
import Labirinto_dalys.Taskas;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Eimantas
 */
public class Serveris {

    
    
    Labirintas l;
    
    public  Serveris(){
        
        IvestiLabirinta iv = new IvestiLabirinta(null, true);
        iv.setVisible(true);
        int la = iv.auks;
        int lp = iv.plot;
        //Kada zinomi matmenys - kuriamas labirintas
        if (iv.t==false){
            System.exit(1);  
        }
       l= new Labirintas(la, lp); 
       try{
       File file= new File("PradinesLabirintoSienos.txt");
       Scanner sc = new Scanner(file);
       while(sc.hasNext())
       {
          String [] data=sc.nextLine().split(" ");
          int eil=Integer.parseInt(data[0]);
          int st=Integer.parseInt(data[1]);
          int k=Integer.parseInt(data[2]);
          l.keistiSiena(eil, st, k);
       }
       sc.close();  
       }
       catch(Exception ex){}
       RedaguotiSienas rd= new RedaguotiSienas(null, true, l);
       rd.setVisible(true);
    }
    
    public static void main(String[] a) {
        
        Serveris s = new Serveris();
      
        ServerSocket serverSocket = null;
        //Turesim sarasa, kuriame saugosim informacija apie visus prisijungusius klientus
        ArrayList<User> klientai = new ArrayList();
        //skaitliukas vien tam, kad kiekvienas vartotojas turetu univalu varda
        int counter = 1;
        try {
            //susikuriam ServerSocket tipo objekta, nurodydami kuriuo prievadu klausysimes infromacijos
            serverSocket = new ServerSocket(1234);
            boolean testi = true;
            //turim amzina cikla
            while (testi) {
                //laukiama naujo prisijungusio kliento
                Socket clientSocket = serverSocket.accept();
                //System.out.println(clientSocket.getPort());//cia galim suzinoti koki prievada jam skyre
                System.out.println("Sulauke naujo kliento " + clientSocket.getInetAddress().getHostAddress());//galim gauti ir koks jo ip adresas
                //sukuriam kliento objekta, kad veliau butu galima i ji kreiptis
                Taskas dabartinis= s.l.pridetiTaska("A"+counter, (int)(Math.random()*s.l.getAukstis()), (int)(Math.random()*s.l.getPlotis()));
                User klientas = new User(clientSocket, klientai, "Klientas_" + counter++, dabartinis,s.l);
                
                
                klientas.out.println("Mat:"+s.l.getAukstis()+"-"+s.l.getPlotis());
                String sienos="";
               for (int i =0; i< s.l.getAukstis(); i++) // susiiekom reikiamas sienas
                {
                    for (int j=0; j<s.l.getPlotis(); j++)
                    {
                        sienos+=":"+s.l.getLangeliai()[i][j].galiEiti[(Kryptys.DESINE).ordinal()]+"-"+
                               s.l.getLangeliai()[i][j].galiEiti[(Kryptys.APACIA).ordinal()];
                        
                    }
                    
                }
               
                klientas.out.println(sienos);
               // System.out.println(dabartinis.vieta.getEil()+"-"+dabartinis.vieta.getSt()+"-"+"Klientas"+(counter-1));
                
                // pridedamas naujam klientui jo taskas
                klientas.out.println("dt:"+dabartinis.vieta.getEil()+"-"+dabartinis.vieta.getSt()+"-"+"Klientas_"+(counter-1));
                
                klientas.atvaizduotiNauja(dabartinis, "Klientas_"+(counter-1));
                klientas.vaizduoti();// vaizduoja naujam esamus taskus
                //idedam klienta i sarasa
                klientai.add(klientas);
                //paleidziam gija, kad klientas pradetu klausytis komandu is serverio
                klientas.start();
              
            }
        } catch (Exception e) {
            try {
                //jei buvo klaidu uzdarom serveri
                serverSocket.close();
            } catch (Exception ex) {
            }
            //baigiam rpogramos darba
            System.exit(1);
        }
    }
    
}

