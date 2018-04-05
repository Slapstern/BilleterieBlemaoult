/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

import controleur.CtrlConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wquentel
 */
public class Utilisateur {
    private String identifiant;
    private String mdp;
    
    public Utilisateur(String identifiant, String mdp){
        
        this.identifiant=identifiant;
        this.mdp=mdp;
    }
    

    @Override
    public String toString() {
        return "Utilisateur{" + "identifiant=" + identifiant + ", mdp=" + mdp + '}';
    }
    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public static String md5Converter(String ligne){
        String lConvertie="";
        try {
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(ligne.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        lConvertie=sb.toString();
        
        } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(CtrlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lConvertie;
    }
    
}
