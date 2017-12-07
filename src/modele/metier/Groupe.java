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
public class Groupe {
    
    private int id; 
    private String nom;
    private String identiteResp;
    private String adr;
    private String nbPers;
    private String pays;
    private String hebergement;

    public Groupe(int id, String nom, String identiteResp, String adr, String nbPers, String pays, String hebergement) {
        this.id = id;
        this.nom = nom;
        this.identiteResp = identiteResp;
        this.adr = adr;
        this.nbPers = nbPers;
        this.pays = pays;
        this.hebergement = hebergement;
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdentiteResp() {
        return identiteResp;
    }

    public void setIdentiteResp(String identiteResp) {
        this.identiteResp = identiteResp;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getNbPers() {
        return nbPers;
    }

    public void setNbPers(String nbPers) {
        this.nbPers = nbPers;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getHebergement() {
        return hebergement;
    }

    public void setHebergement(String hebergement) {
        this.hebergement = hebergement;
    }


   
    }
   
  
