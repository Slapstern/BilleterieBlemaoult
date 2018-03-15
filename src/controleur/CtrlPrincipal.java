/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import javax.swing.JOptionPane;

/**
 *
 * @author wquentel
 */
public class CtrlPrincipal {
    private CtrlRepresentation ctrlLesRepresentations;
    private CtrlLeMenu ctrlLeMenu;
    private CtrlLaBilleterie ctrlLaBilleterie;
    
    public void afficherLeMenu(){
        this.ctrlLeMenu.getMenu().setVisible(true);
        this.ctrlLesRepresentations.getReserv().setVisible(false);
        this.ctrlLaBilleterie.getBilleterie().setVisible(false);
    }
    public void afficherLesRepresentations() {
        this.ctrlLeMenu.getMenu().setVisible(false);
        this.ctrlLesRepresentations.getReserv().setVisible(true);
        this.ctrlLaBilleterie.getBilleterie().setVisible(false);
    }
    
    public void afficherLaBilleterie() {
        this.ctrlLeMenu.getMenu().setVisible(false);
        this.ctrlLesRepresentations.getReserv().setVisible(true);
        this.ctrlLaBilleterie.getBilleterie().setVisible(false);
    }
    
     public void quitterApplication(){       
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(null, "Quitter l'application\nEtes-vous sûr(e) ?", "Representation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            System.exit(0);
        }
        if(rep == JOptionPane.NO_OPTION){
        
        }
    }
    public CtrlLeMenu getCtrlMenu(){
        return ctrlLeMenu;
    }
    public void setCtrlMenu(CtrlLeMenu ctrlLeMenu){
        this.ctrlLeMenu= ctrlLeMenu;
    }
    
    public CtrlLaBilleterie getCtrlLaBilleterie(){
        return ctrlLaBilleterie;
    }
    public void setCtrlLaBilleterie(CtrlLaBilleterie ctrlLaBilleterie){
        this.ctrlLaBilleterie= ctrlLaBilleterie;
    }
    
    public CtrlRepresentation getCtrlRepresentation() {
        return ctrlLesRepresentations;
    }
    
    public void setCtrlRepresentation(CtrlRepresentation ctrlLesRepresentations) {
        this.ctrlLesRepresentations = ctrlLesRepresentations;
    }
    
}

