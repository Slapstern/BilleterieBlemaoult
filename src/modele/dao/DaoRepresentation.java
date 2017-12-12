/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.metier.Representation;

/**
 *
 * @author wquentel
 */
public class DaoRepresentation {
     

    /**
     * Extraction de toutes les adresses
     * @return collection d'adresses
     * @throws SQLException 
     */
    public static List<Representation> selectAll() throws SQLException {
        List<Representation> lesRepresentation = new ArrayList<Representation>();
        Representation uneRepresentation;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT R.id_rep AS id, date_rep, Lieu.nom AS Lieu, Groupe.nom AS Groupe, heure_deb,heure_fin, Lieu.capacite AS places_dispo "
                + "FROM Representation R "
                + "INNER JOIN Groupe ON R.id_groupe=Groupe.id "
                + "INNER JOIN Lieu ON id_lieu= Lieu.id";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String date = rs.getString("date_rep");
            String Lieu = rs.getString("Lieu");
            String Groupe = rs.getString("Groupe");
            String heureDebut = rs.getString("heure_deb");
            String heureFin = rs.getString("heure_fin");
            int placesDispo = rs.getInt("places_dispo");
            uneRepresentation = new Representation(id, date, Lieu,Groupe,heureDebut,heureFin,placesDispo);
            lesRepresentation.add(uneRepresentation);
        }
        return lesRepresentation;
    }
    
    public static Representation selectRepresentationParGroupe(String groupeChoix) throws SQLException {
        Representation uneRepresentation = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête  heure_deb 	heure_fin
        String requete = "SELECT R.id_rep AS id, date_rep, Lieu.nom AS Lieu, Groupe.nom AS Groupe,heure_deb,heure_fin, Lieu.capacite AS places_dispo FROM Representation R INNER JOIN Groupe ON R.id_groupe=Groupe.id INNER JOIN Lieu ON id_lieu= Lieu.id WHERE Groupe.nom LIKE '"+groupeChoix+"'";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("id");
            String date = rs.getString("date_rep");
            String Lieu = rs.getString("Lieu");
            String Groupe = rs.getString("Groupe");
            String heureDebut = rs.getString("heure_deb");
            String heureFin = rs.getString("heure_fin");
            int placesDispo = rs.getInt("places_dispo");
            uneRepresentation = new Representation(id, date, Lieu,Groupe,heureDebut,heureFin,placesDispo);
        }
        return uneRepresentation;
    }
      
    
}
