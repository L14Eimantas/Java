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
public class VaizdavimoDuomenys {
    private String data;
    private int pazimys;
    private String pavadinimas;
    private String aprasas;
    private int studnr;//studentu lenteles
    private int id;//ivertinimu lenteles
    public VaizdavimoDuomenys(String d, int p, String pav, String ap, int nr, int id){
      data=d;
      pazimys=p;
      pavadinimas=pav;
      aprasas=ap;
      studnr=nr;
      this.id=id;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public int getPazimys() {
        return pazimys;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public String getAprasas() {
        return aprasas;
    }

    public int getStudnr() {
        return studnr;
    }
    
}
