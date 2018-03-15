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
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import vue.VueMenu;


/**
 *
 * @author wquentel
 */
public class CtrlLeMenu implements ActionListener,WindowListener {
    private vue.VueMenu leMenu;
    private CtrlPrincipal ctrlPrincipal;
    public CtrlLeMenu(vue.VueMenu vue, CtrlPrincipal ctrl){
        this.leMenu=vue;
        this.ctrlPrincipal = ctrl;
        leMenu.getjBoutonBilleterie().addActionListener(this);
        leMenu.getjBoutonRepresentation().addActionListener(this);
    }
     public void actionPerformed(ActionEvent e) {
        if (e.getSource() == leMenu.getjBoutonBilleterie()) {
             ctrlPrincipal.afficherLaBilleterie();
        }
        if (e.getSource() == leMenu.getjBoutonRepresentation()) {
             ctrlPrincipal.afficherLesRepresentations() ;
        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent we) {
        leMenu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        ctrlPrincipal.quitterApplication();
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

    public VueMenu getMenu() {
        return leMenu;
    }
    
}
