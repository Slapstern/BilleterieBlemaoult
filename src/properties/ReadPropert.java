package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropert {
	public static void main(final String[] args) {

		final Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("src/properties/config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			System.out.println(prop.getProperty("db.url"));
			System.out.println(prop.getProperty("db.login"));
			System.out.println(prop.getProperty("db.password"));
			

		} catch (final IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}