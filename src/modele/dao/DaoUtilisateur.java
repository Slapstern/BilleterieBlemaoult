/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;
import controleur.CtrlConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.metier.Utilisateur;
/**
 *
 * @author wquentel
 */

public class DaoUtilisateur {
    public static boolean verifConnection(Utilisateur lUtilisateur) throws SQLException{
        boolean trouve=false;
        String identifiant= lUtilisateur.getIdentifiant();
        String mdp=lUtilisateur.getMdp();
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        String requete = "SELECT * FROM Utilisateur WHERE identifiant LIKE '"+identifiant+"' AND mdp='"+mdp+"';";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        System.out.println(requete);
        if (rs.next()) {
            trouve=true;
        }            
        return trouve;
    }
    
}
