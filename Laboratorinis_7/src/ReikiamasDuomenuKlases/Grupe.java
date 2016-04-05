/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReikiamasDuomenuKlases;

/**
 *
 * @author Eimantas
 */
public class Grupe {
    String kodas;
    int nr;
    public Grupe(int id, String kodas){
        this.nr=id;
        this.kodas=kodas;
    }
    
    public int getId(){
        return nr;
    }
    public String getKodas(){
       return kodas;
    }
}
