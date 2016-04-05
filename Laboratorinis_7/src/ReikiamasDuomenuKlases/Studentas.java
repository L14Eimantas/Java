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

public class Studentas {
   private String vardas;
   private String pavarde;
   private String grupe;
   private int studNr; //FK
   public Studentas(String vardas, String pavarde, String grupe, int studNr){
       this.vardas=vardas;
       this.pavarde=pavarde;
       this.grupe=grupe;
       this.studNr=studNr;
   }

    public int getStudNr() {
        return studNr;
    }

    public String getVardas() {
        return vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public String getGrupe() {
        return grupe;
    }
}
