/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Lieu {
    
    private int id; 
    private String nom;
    private String adr;
    private String capacite;


    public Lieu(int id, String nom, String adr, String capacite) {
        this.id = id;
        this.nom = nom;
        this.adr = adr;
        this.capacite = capacite;
    }
   
    @Override
    public String toString() {
        return ("Lieu{nom: " + this.getNom() + "\tid: " + this.getId() + "\tadr: " + this.getAdr() + "\tcapacite: " + this.getCapacite()) + "}";
    }
     public int getId() {
        return id;
    }
     public void setId(int id) {
        this.id = id;
    }
     public String getNom() {
        return nom;
    }
     public void setNom(String Nom) {
        this.nom = nom;
    }
     public String getAdr() {
        return adr;
    }
     public void setAdr(String Adr) {
        this.adr = adr;
    }
     public String getCapacite() {
        return capacite;
    }
     public void setCapacite(String Capacite) {
        this.capacite = capacite;
    }
    
     
    
}