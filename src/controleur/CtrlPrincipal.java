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
    
    public void afficherLesRepresentations() {
        this.ctrlLesRepresentations.getReserv().setVisible(true);
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
    
    public CtrlRepresentation getCtrlRepresentation() {
        return ctrlLesRepresentations;
    }
    
    public void setCtrlRepresentation(CtrlRepresentation ctrlLesRepresentations) {
        this.ctrlLesRepresentations = ctrlLesRepresentations;
    }
    
}

