/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Festival_Billeterie;

import controleur.CtrlConnection;
import controleur.CtrlPrincipal;
import controleur.CtrlRepresentation;
import controleur.CtrlLeMenu;
import controleur.CtrlLaBilleterie;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import vue.VueRepresentation;
import vue.VueMenu;
import vue.VueBilleterie;
import vue.VueConnection;
import modele.dao.Jdbc;


/**
 *
 * @author aroblin
 */
public class Festival_Billeterie {
    public static void main(String[] args) {
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
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
        Jdbc.creer(prop.getProperty("jdbcDriver"), prop.getProperty("typeBdd"), prop.getProperty("localisation"), prop.getProperty("database"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
        try {
            Jdbc.getInstance().connecter();
            CtrlPrincipal leControleurPrincipal = new CtrlPrincipal();
            
            VueConnection laVueLaConnection= new VueConnection();
            CtrlConnection leControleurLaConnection= new CtrlConnection(laVueLaConnection, leControleurPrincipal);
            
            VueMenu laVueLeMenu = new VueMenu();
            CtrlLeMenu leControleurLeMenu = new CtrlLeMenu(laVueLeMenu, leControleurPrincipal);
            
            VueRepresentation laVueLesRepresentation = new VueRepresentation();            
            CtrlRepresentation leControleurLesRepresentation = new CtrlRepresentation(laVueLesRepresentation, leControleurPrincipal);
            
            VueBilleterie laVueLaBilleterie= new VueBilleterie();
            CtrlLaBilleterie leControleurLaBilleterie = new CtrlLaBilleterie(laVueLaBilleterie, leControleurPrincipal);
            
            leControleurPrincipal.setCtrlLaConnection(leControleurLaConnection);
            leControleurPrincipal.setCtrlLaBilleterie(leControleurLaBilleterie);
            leControleurPrincipal.setCtrlRepresentation(leControleurLesRepresentation);            
            leControleurPrincipal.setCtrlMenu(leControleurLeMenu);
            leControleurPrincipal.setCtrlLaBilleterie(leControleurLaBilleterie);
            
            laVueLaConnection.setVisible(true);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Main - classe JDBC non trouvée");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Main - échec de connexion");
        }
        
    }
    
}
