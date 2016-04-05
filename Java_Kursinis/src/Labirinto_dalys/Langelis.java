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
public class Langelis {
    int st; //stulpelis
    int eil;//eilute
    Langelis[] kaimynai;
    public boolean galiEiti[]; 
    
    public Langelis(int eil, int st)
    {
        this.eil=eil;
        this.st=st;
        this.kaimynai = new Langelis[4];
        this.galiEiti = new boolean[4];
    }

    public int getSt() {
        return st;
    }

    public int getEil() {
        return eil;
    }
    
    public boolean galimaKryptis(Kryptys k){
        return kaimynai[k.ordinal()]!=null;
    }
}
   