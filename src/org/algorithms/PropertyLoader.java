package org.algorithms;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Keyur on 14-09-2016.
 * This class is a utility class to load data from properties file.
 */
public class PropertyLoader {

	private static Properties securityProperties;

	public static Properties getSecurityKeyProperty() {
		InputStream inputStream = null;
		try {
			if (securityProperties != null) {
				return securityProperties;
			}
			inputStream = PropertyLoader.class.getClassLoader().getResourceAsStream("resources/SecurityKey.properties");
			securityProperties = new Properties();
			securityProperties.load(inputStream);
			return securityProperties;
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return securityProperties;
	}
}
