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
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
                
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(identifiant.getBytes());
                byte[] digest = md.digest();
                StringBuffer sb = new StringBuffer();
                for (byte b : digest) {
                    sb.append(String.format("%02x", b & 0xff));
                }
                
                MessageDigest md2 = MessageDigest.getInstance("MD5");
                md2.update(mdp.getBytes());
                byte[] digest2 = md2.digest();
                StringBuffer sb2 = new StringBuffer();
                for (byte b : digest2) {
                    sb2.append(String.format("%02x", b & 0xff));
                }
                
                if(prop.getProperty("identifiant").equals(sb.toString()) && prop.getProperty("mdp").equals(sb2.toString())){
                    ctrlPrincipal.afficherLeMenu();
                }else {
                    JOptionPane.showMessageDialog(null, "Mauvais identifiants !");
                }                
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(CtrlConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}