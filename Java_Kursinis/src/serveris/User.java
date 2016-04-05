/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveris;

import Labirinto_dalys.Labirintas;
import Labirinto_dalys.Taskas;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Eimantas
 */
public class User extends Thread {

    //issisaugom soctek tipo objekta, nes per ji gausim duoenu srautus

    Socket clientSocket;
    //vartotojui priskiriam jo slapyvardi
    String nick;
    //srauta turim kaip klases kintamaji, kad galetumem is naujo nekurti, o ta pati naudoti
    PrintWriter out;
    //klientas zinos ir apie visus tuo metu prisijungusius klientus
    ArrayList<User> klientai;
    Labirintas l;
    public Taskas as;

    //per konstruktoriu paduodam visus butinus objektus

    public User(Socket s, ArrayList<User> k, String n, Taskas p, Labirintas l) {
        clientSocket = s;
        klientai = k;
        nick = n;
        as=p;
        this.l=l;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (Exception e) {
        }
    }

    //si gija nuolat skaitys duomenis is kleinto ir ziures kaip i tai reaguoti, t.y. ka jam atgal pasiusti ir pan.

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Klientas " + nick + " parase: " + inputLine);
                if (inputLine.equals("Bye.")) {
                    out.println("Bye.");
                    //jei Bye. tada baigiam klausymasi
                    trinti(this.nick);
                    l.getTaskai().remove(as);
                    klientai.remove(this);
                    break;
                } else if (inputLine.startsWith("v:")) {
                    //jei prasideda v: tada persiunciam visiems kleintams ta pati teksta
                    atsakytiVisiems(inputLine);
                } else if (inputLine.startsWith("pm:")) {
                    //jei prasideda pm: tada siunciam tik tam klientui, kurio nick toks pat, kaip tekstas po pirmo : iki antro :
                    String[] dalys = inputLine.split(":", 3);
                    siustiZinute(dalys[2], dalys[1]);
                } else if (inputLine.startsWith("eik:")){
                     int kr=Integer.parseInt(inputLine.split(":")[1]);
                     as.eik(kr);
                     eitiVisiems(kr);
                }
                else {
                    //atsakom jam tekstu, kuris nurodo koks yra zinutes ilgis
                    out.println("Ilgis: " + inputLine.length());
                }
            }
            //kada baigia klausyma (po Bye.) tada uzdarom visus srautus
            clientSocket.close();
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //metode einam per visa klientu sarasa ir visiems siunciam ta pati teksta
    public void atsakytiVisiems(String txt) throws Exception {
      
        int i = 1;
        for (User u : klientai) {
            if (!u.equals(this)) {
                u.out.println("[" + (LocalTime.now()) + "] " + nick + ": " + txt.substring(2));
                
            }
        }
    }
    //metode einam per visu kleintu sarasa ir tam, kurio nick toks koki nurode vartotojas, tam tik siunciam zinute
    public void siustiZinute(String txt, String n) {
        for (User u : klientai) {
            if (u.nick.equals(n)) {
                u.out.println("[" + (LocalTime.now()) + "] " + nick + ": " + txt);
              
                break;
            }
        }
    }
    //metodas siusnia zine kad reikia prideti taska (kliente), kitaip atsirado naujas vartotojas
    public void atvaizduotiNauja(Taskas t, String name){
        
       for (User u:klientai){
           u.out.println("dt:"+t.vieta.getEil()+"-"+t.vieta.getSt()+"-"+name);
       } 
    }
     // naujam taskui pridedam jau esanciu taskus (kliente)
     void vaizduoti() {
        int i=0; 
        for (User u:klientai){
           this.out.println("dt:"+u.as.vieta.getEil()+"-"+u.as.vieta.getSt()+"-"+u.nick);
       } 
    }
     // taskas pajudejo tai ir kliente jis turi pajudeti
    void eitiVisiems(int kr){
        for (User u : klientai) {
            if (!u.nick.equals(nick)) {
                u.out.println("eiti:"+this.nick+"-"+kr);
            }
        }
    } 
  // istrinam taska is kliento 
    void trinti(String nick) {
        for (User u : klientai) {
            if (!u.nick.equals(nick)) {
                u.out.println("tr:"+nick);
            }
        }
        
    }
    
 
    
}