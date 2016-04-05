/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Labirinto_dalys;

/**
 *
 * @author Eimantas
 */
public class Taskas {
    public Langelis vieta;
    String pavadinimas;
    public Taskas (String pav, Langelis l)
    {
        this.pavadinimas=pav;
        this.vieta=l;
    }
    public void eik(Kryptys k){
        if(vieta.galiEiti[k.ordinal()]){
            vieta = vieta.kaimynai[k.ordinal()];
        }
    }
    
    public void eik(int k){
        if(vieta.galiEiti[k]){
            vieta = vieta.kaimynai[k];
        }
    }
    
    public String getName()
    {
        return pavadinimas;
    }
    
    public void kurEsi(){
        System.out.println(pavadinimas+": "+vieta.eil+", "+vieta.st);
    }
}
