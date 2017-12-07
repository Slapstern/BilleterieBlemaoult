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
        List<Representation> lesRepresentations = new ArrayList<Representation>();
        Representation uneRepresentation;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT Groupe.nom,Lieu.nom as lnom, date_rep, heure_deb, heure_fin "
                + "FROM Representation R "
                + "INNER JOIN GROUPE ON R.id_groupe=Groupe.id "
                + "INNER JOIN Lieu ON id_lieu= Lieu.id";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String nom = rs.getString("nom");
            String lieux = rs.getString("lnom");
            String date = rs.getString("date_rep");
            String heureD = rs.getString("heure_deb");
            String heureF = rs.getString("heure_fin");
            uneRepresentation = new Representation(nom,lieux, date, heureD, heureF);
            lesRepresentations.add(uneRepresentation);
        }
        return lesRepresentations;
    }
}
