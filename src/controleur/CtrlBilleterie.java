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
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import vue.VueBilleterie;

/**
 *
 * @author wquentel
 */
public class CtrlBilleterie implements WindowListener,ActionListener{
    private VueBilleterie vue; // LA VUE

    public CtrlBilleterie(VueBilleterie vue) {
        this.vue = vue;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        // préparer l'état iniitial de la vue
       // getVueA().getjButtonRechercher().addActionListener(this);
        //getVueA().getjTextFieldVille().addActionListener(this);
       // List<Billeterie> lesBillets = null;
        //try {
         //   lesAdresses = DaoAdresse.selectAll();
        //} catch (SQLException ex) {
        //    JOptionPane.showMessageDialog(getVueA(), "CtrlLesAdresses - échec de sélection des adresses");
        //}
       // afficherLesAdresses(lesAdresses);
    }

     // ACCESSEURS et MUTATEURS
    public VueBilleterie getVueA() {
        return vue;
    }
    
    public void setVue(VueBilleterie vue) {
        this.vue = vue;
    }
    
    @Override
    public void windowOpened(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
