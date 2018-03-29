/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author wquentel
 */
public class Representation {
    private int id;
    private String groupe;
    private String lieux;
    private String date;
    private String heureD;
    private String heureF;
    private int placesDispo;
    private int placesTotal;
    
        
    
    
    //constructeur
    public Representation(int id,String date,String Lieu,String Groupe,String heureDebut,String heureFin,int placesDispo, int placesTotal){
    
    this.id=id;
    this.date=date;
    this.lieux=Lieu;
    this.groupe=Groupe;
    this.heureD=heureDebut;
    this.heureF=heureFin;
    this.placesDispo=placesDispo;
    this.placesTotal=placesTotal;
    }

    //toString
    @Override
    public String toString() {
        return "<html>Groupe=" + groupe +"<br> date=" + date + "<br> Lieu=" + lieux + "<br> heureDebut=" + heureD + "<br> heureFin=" + heureF + "<br> placesDispo=" + placesDispo + "/"+placesTotal+"</html>";
    }

    public int getPlacesDispo() {
        return placesDispo;
    }

    public void setPlacesDispo(int placesDispo) {
        this.placesDispo = placesDispo;
    }
    
    //accesseur
    public int getId(){
        return id;
    }
    public String getDate() {
        return date;
    }

    public String getLieu() {
        return lieux;
    }

    public String getGroupe() {
        return groupe;
    }

    public String getHeureDebut() {
        return heureD;
    }

    public String getHeureFin() {
        return heureF;
    }
    
    
    
    
    
    //mutateur
 

    public void setDate(String date) {
        this.date = date;
    }

    public void setLieu(String lieu) {
        this.lieux = lieu;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureD= heureDebut;
    }

    public void setHeureFin(String heureFin) {
        this.heureF= heureFin;
    }
}
