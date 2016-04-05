/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klientas;

import Labirinto_dalys.Taskas;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Eimantas
 */
public class Klientas {
    
    private Socket soketas;
    private PrintWriter out;
    private BufferedReader in;
    private boolean t=true;
    public static void main(String[] args) {
        try {
            Klientas sis = new Klientas();
            //sukuriam socket tipo obejkta, nurodydami kokiu ip adresu ir kokiu prievadu kreiptis i serveri
            sis.soketas = new Socket("127.0.0.1", 1234);
            //pagal socket tipo objekta gaunas ivesties ir isvesties srautus
            sis.out = new PrintWriter(sis.soketas.getOutputStream(), true);
            sis.in = new BufferedReader(new InputStreamReader(sis.soketas.getInputStream()));
            //dar salia susikuriam skaitymo is klaviaturos srauta gyvam komandu perdavimui
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            GUI gvs = new GUI(sis);
            gvs.setVisible(true);
            
            
            String userInput;
            //susikuriam atskira gija, kuri skaitys is serverio gaunamus atsakymus ir juos atspausdins komandineje eiluteje
            Thread a = new Thread() {
                public void run() {
                    try {
                        //skaitys amzinai
                        while (true) {
                           String ats= sis.in.readLine();
                           if (ats.startsWith("Mat:")) // duotam matmenis kad labirintas susikurtu
                           {
                               String split=ats.split(":")[1];
                               int a=Integer.parseInt(split.split("-")[0]);
                               int b=Integer.parseInt(split.split("-")[1]);
                               gvs.setLabirintas(a,b);
                               
                           }else if (ats.startsWith(":")){ //uzdeda sienoas
                               // uzdedam sienas
                                String [] split = ats.split(":");
                                int k=1;
                                for (int i=0; i<gvs.l.getAukstis(); i++)
                                {
                                    for (int j=0; j<gvs.l.getPlotis(); j++)
                                    {
                                        String []puse= split[k].split("-");
                                        boolean des = Boolean.parseBoolean(puse[0]);
                                        boolean apa = Boolean.parseBoolean(puse[1]);
                                        if (des==false)
                                        {
                                            gvs.l.keistiSiena(i, j, 1);
                                        }
                                        if (apa==false){
                                            gvs.l.keistiSiena(i, j, 2);
                                        }
                                        k++;
                                    }
                                }

                            }else if (ats.startsWith("dt:")){ // dabartinio ir kitu tasko pridejimas
                                
                                String[] data=ats.split(":")[1].split("-");
                                int eil= Integer.parseInt(data[0]);
                                int stul= Integer.parseInt(data[1]);
                                if (sis.t==true){
                                    sis.t=false;
                                    gvs.pridetiKlienta("Visi");
                                }else{
                                    gvs.pridetiKlienta(data[2]);
                                }
                                gvs.l.pridetiTaska(data[2], eil, stul);
                                gvs.repaint();
                            }else if (ats.startsWith("tr:")){  // saliname taska
                                String name= ats.split(":")[1];
                                for (Taskas tt:gvs.l.getTaskai()){
                                    if (tt.getName().equals(name)){
                                        gvs.l.getTaskai().remove(tt);
                                        gvs.pasalintiKlienta(name);
                                        break;
                                    }
                                }
                                gvs.repaint();
                            }else if (ats.startsWith("eiti:")){ //keiciame tasko padeti
                                String data= ats.split(":")[1];
                                String name=data.split("-")[0];
                                int kr = Integer.parseInt(data.split("-")[1]);
                                for (Taskas a:gvs.l.getTaskai()){
                                    if (a.getName().equals(name)){
                                        a.eik(kr);
                                        break;
                                    }
                                }
                                gvs.repaint();
                            }
                               else
                                gvs.isvestiAtsaka(ats);
                        }
                    } catch (Exception e) {
                    }
                }
            };
            a.start();
            //cia skaitom duomenis is klaviaturos
            while ((userInput = stdIn.readLine()) != null) {
                sis.out.println(userInput);
                if (userInput.equals("Bye.")) {
                    break;
                }
            }
            //jei baige ivedineti komandas, t.y. parase Bye. tada uzdarom visus srautus ir socket tipo objekta  
            stdIn.close();
            sis.uzdarytiSrautus();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
    
    public void uzdarytiSrautus() throws Exception{
        out.close();
        in.close();
        soketas.close();
    }
    
    public void siustiZinute(String txt){
        
        if (out!=null){
            out.println(txt);
        }
    }

  
}
