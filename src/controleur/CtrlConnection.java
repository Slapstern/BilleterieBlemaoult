/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele.dao.DaoUtilisateur;
import modele.metier.Utilisateur;
import vue.VueConnection;

/**
 *
 * @author tberthome
 */
public class CtrlConnection implements WindowListener,ActionListener{
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    private vue.VueConnection connection;
    private CtrlPrincipal ctrlPrincipal;
    
    
    public CtrlConnection (vue.VueConnection vue, CtrlPrincipal ctrl){
        this.connection=vue;
        this.connection.addWindowListener((WindowListener) this);
        this.connection.getJButtonConnection().addActionListener((ActionListener) this);
        this.ctrlPrincipal = ctrl;
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        ctrlPrincipal.quitterApplication();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    public VueConnection getConnection() {
        return connection;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.connection.getJButtonConnection())){
            
            Properties prop = new Properties();
            InputStream input = null;

            try {

                    input = new FileInputStream("src/properties/config.properties");

                    // load a properties file
                    prop.load(input);

            } catch (IOException ex) {
                    ex.printStackTrace();
            } finally {
                    if (input != null) {
                            try {
                                    input.close();
                            } catch (IOException e1) {
                                    e1.printStackTrace();
                            }
                    }
            }
            
            
            try {
                String identifiant = this.connection.getJTextFieldUtil().getText();
                String mdp = this.connection.getJTextFieldMdp().getText();
                identifiant=Utilisateur.md5Converter(identifiant);
                mdp= Utilisateur.md5Converter(mdp);
                Utilisateur unUtilisateur= new Utilisateur(identifiant,mdp);
                System.out.println("id: "+unUtilisateur.getIdentifiant()+" mdp: "+unUtilisateur.getMdp());
                if(DaoUtilisateur.verifConnection(unUtilisateur)){
                    ctrlPrincipal.afficherLeMenu();
                }else {
                    JOptionPane.showMessageDialog(null, "Mauvais identifiants !");
                }                
            } catch (SQLException ex) {
                Logger.getLogger(CtrlConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}