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

/**
 *
 * @author aroblin
 */
public class DaoGroupe {

    public static Groupe selectOne(int idGroupe) throws SQLException {
        Groupe unGroupe = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Groupe WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idGroupe);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("ID");
            String rue = rs.getString("RUE");
            String cdp = rs.getString("CDP");
            String ville = rs.getString("VILLE");
            unGroupe = new Groupe(id, rue, cdp, ville);
        }
        return unGroupe;
    }

    /**
     * Extraction de toutes les Groupes
     *
     * @return collection dGroupes
     * @throws SQLException
     */
    public static List<Groupe> selectAll() throws SQLException {
        List<Groupe> lesGroupes = new ArrayList<Groupe>();
        Groupe unGroupe;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Groupe";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("ID");
            String rue = rs.getString("RUE");
            String cdp = rs.getString("CDP");
            String ville = rs.getString("VILLE");
            unGroupe = new Groupe(id, rue, cdp, ville);
            lesGroupes.add(uneGroupe);
        }
        return lesGroupes;
    }

    /**
     * Extraction de toutes les Groupes dont le nom de ville contient la chaîne
     * recherchée
     *
     * @param extraitNomVille
     * @return collection d'Groupees
     * @throws SQLException
     */
    public static List<Groupe> selectAllByVille(String extraitNomVille) throws SQLException {
        List<Groupe> lesGroupes = new ArrayList<Groupe>();
        Groupe uneGroupe;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Groupe WHERE ville LIKE ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, "%" + extraitNomVille + "%");
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("ID");
            String rue = rs.getString("RUE");
            String cdp = rs.getString("CDP");
            String ville = rs.getString("VILLE");
            uneGroupe = new Groupe(id, rue, cdp, ville);
            lesGroupes.add(uneGroupe);
        }
        return lesGroupes;
    }

    /**
     * Extraction de toutes les Groupes, ordonnées
     *
     * @param cleTri 1=>ID ; 2=>VILLE
     * @param ordreTri 1=>ASC ; 2=>DESC
     * @return collection d'Groupes
     * @throws SQLException
     */
    public static List<Groupe> selectAll(int cleTri, int ordreTri) throws SQLException {
        List<Groupe> lesGroupes = new ArrayList<Groupe>();
        Groupe uneGroupe;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Groupe";
        switch (cleTri) {
            case 1: // Tri par Id
                requete += " ORDER BY ID";
                break;
            case 2: // Tri par ville
                requete += " ORDER BY VILLE";
                break;
        }
        if (cleTri == 1 || cleTri == 2) {
            switch (ordreTri) {
                case 1: // Tri croissant
                    requete += " ASC";
                    break;
                case 2: // Tri décroissant
                    requete += " DESC";
                    break;
            }
        }
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("ID");
            String rue = rs.getString("RUE");
            String cdp = rs.getString("CDP");
            String ville = rs.getString("VILLE");
            uneGroupe = new Groupe(id, rue, cdp, ville);
            lesGroupes.add(uneGroupe);
        }
        return lesGroupes;
    }

    public static int insert(int idGroupe, Groupe unGroupe) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "INSERT INTO Groupe (ID, RUE, CDP , VILLE) VALUES (?, ?, ?, ?)";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idGroupe);
        pstmt.setString(2, unGroupe.getRue());
        pstmt.setString(3, unGroupe.getCp());
        pstmt.setString(4, unGroupe.getVille());
        nb = pstmt.executeUpdate();
        return nb;
    }

    public static int update(int idGroupe, Groupe unGroupe) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "UPDATE Groupe SET RUE = ? , CDP = ? , VILLE = ? WHERE ID = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, unGroupe.getRue());
        pstmt.setString(2, unGroupe.getCp());
        pstmt.setString(3, unGroupe.getVille());
        pstmt.setInt(4, idGroupe);
        nb = pstmt.executeUpdate();
        return nb;
    }

    public static int delete(int idAdresse) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "DELETE  FROM Groupe WHERE ID = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idAdresse);
        nb = pstmt.executeUpdate();
        return nb;
    }
}
