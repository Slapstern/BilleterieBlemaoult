/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Festival_Billeterie;

import controleur.CtrlPrincipal;
import controleur.CtrlRepresentation;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vue.VueRepresentation;
import modele.dao.Jdbc;

/**
 *
 * @author aroblin
 */
public class Festival_Billeterie {
    public static void main(String[] args) {
        Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql:", "//localhost/", "festival", "root", "joliverie");
        try {
            Jdbc.getInstance().connecter();
            CtrlPrincipal leControleurPrincipal = new CtrlPrincipal();
            VueRepresentation laVueLesRepresentation = new VueRepresentation();
            CtrlRepresentation leControleurLesRepresentation = new CtrlRepresentation(laVueLesRepresentation, leControleurPrincipal);
            leControleurPrincipal.setCtrlRepresentation(leControleurLesRepresentation);
            laVueLesRepresentation.setVisible(true);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Main - classe JDBC non trouvée");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Main - échec de connexion");
        }
        
    }
    
}
