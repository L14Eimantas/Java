/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Labirinto_dalys;

import java.util.ArrayList;

/**
 *
 * @author Eimantas
 */
public class Labirintas {
   int aukstis;
   int plotis;
   Langelis[][] langeliai;
   ArrayList<Taskas> taskai = new ArrayList();
   
   public Labirintas(int aukstis, int plotis)
   {
       this.aukstis=aukstis;
       this.plotis=plotis;
       langeliai=new Langelis[aukstis][plotis];
       for (int i = 0; i < aukstis; i++) {
            for (int j = 0; j < plotis; j++) {
                langeliai[i][j] = new Langelis(i, j);
                if (i > 0) {
                    langeliai[i][j].kaimynai[Kryptys.VIRSUS.ordinal()] = langeliai[i - 1][j];
                    langeliai[i][j].galiEiti[Kryptys.VIRSUS.ordinal()] = true;
                    langeliai[i - 1][j].kaimynai[Kryptys.APACIA.ordinal()] = langeliai[i][j];
                    langeliai[i - 1][j].galiEiti[Kryptys.APACIA.ordinal()] = true;
                }
                if (j > 0) {
                    langeliai[i][j].kaimynai[Kryptys.KAIRE.ordinal()]=langeliai[i][j-1];
                    langeliai[i][j].galiEiti[Kryptys.KAIRE.ordinal()]=true;
                    langeliai[i][j-1].kaimynai[Kryptys.DESINE.ordinal()]=langeliai[i][j];
                    langeliai[i][j-1].galiEiti[Kryptys.DESINE.ordinal()]=true;
                }
            }
        }
   }
   
   public void keistiSiena(int e, int st, Kryptys k) // e -eilute, st-stulpelis
   {
       if (e>=0 && e<aukstis && st>=0 && st<plotis)
       {
           Langelis l = langeliai[e][st];
           if (l.kaimynai[k.ordinal()]!=null)
           {
               l.galiEiti[k.ordinal()]= !l.galiEiti[k.ordinal()];
               l.kaimynai[k.ordinal()].galiEiti[(k.ordinal()+2)%4]= l.galiEiti[k.ordinal()]; //+2 del krypciu
           }
       }
   }
   
   public void keistiSiena(int e, int st, int k) // e -eilute, st-stulpelis
   {
       if (e>=0 && e<aukstis && st>=0 && st<plotis)
       {
           Langelis l = langeliai[e][st];
           if (l.kaimynai[k]!=null)
           {
               l.galiEiti[k]= !l.galiEiti[k];
               l.kaimynai[k].galiEiti[(k+2)%4]= l.galiEiti[k]; //+2 del krypciu
           }
       }
   }
   
    public Taskas pridetiTaska(String p, int e, int s)//p -pavadinimas, e-eilute, s-stulpelis
    {
        if(e>=0 && e<aukstis && s>=0 && s<plotis) {
           Taskas t = new Taskas(p, langeliai[e][s]);
           taskai.add(t);
           return t;
        }
        return null;
    }
    
  
    public Taskas pridetiTaskaKaipPirma(String p, int e, int s) {
        if (e >= 0 && e < aukstis && s >= 0 && s < plotis) {
            Taskas t = new Taskas(p, langeliai[e][s]);
            taskai.add(0,t);
            return t;
        }
        return null;
    }
   public void spausdinti()
   {
     for (int i=0;i<aukstis;i++)
     {
         for (int j=0;j<plotis;j++)
         {
             Langelis l = langeliai[i][j];
             System.out.println(l.galiEiti[Kryptys.VIRSUS.ordinal()]+" "+
                     l.galiEiti[Kryptys.DESINE.ordinal()]+" "+
                     l.galiEiti[Kryptys.APACIA.ordinal()]+" "+
                     l.galiEiti[Kryptys.KAIRE.ordinal()]+"  " + i +" "+ j);
         }
     }
    }

    public int getAukstis() {
        return aukstis;
    }

    public int getPlotis() {
        return plotis;
    }

    public Langelis[][] getLangeliai() {
        return langeliai;
    }

    public ArrayList<Taskas> getTaskai() {
        return taskai;
    }
   
 
}

