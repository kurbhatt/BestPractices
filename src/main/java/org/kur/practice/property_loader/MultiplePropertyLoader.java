package org.kur.practice.property_loader;

import java.util.Properties;

/**
 * Created by Keyur on 20-09-2016.
 * <p>
 * This class demonstrate to load multiple properties file in single property class instance.
 * Make sure each file will have a unique key value otherwise it will be a null.
 */
public class MultiplePropertyLoader {

	private static Properties properties;

	public static void main(String[] args) {

		try {
			properties = new Properties();
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("SecurityKey.properties"));
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("SecurityKey1.properties"));
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("SecurityKey2.properties"));

			System.out.println("::: Property File 1 Data :::");
			System.out.println(properties.getProperty("ENCRYPTION_KEY"));
			System.out.println(properties.getProperty("USERNAME"));
			System.out.println(properties.getProperty("PASSWORD"));

			System.out.println("::: Property File 2 Data :::");
			System.out.println(properties.getProperty("ENCRYPTION_KEY1"));
			System.out.println(properties.getProperty("USERNAME1"));
			System.out.println(properties.getProperty("PASSWORD1"));

			System.out.println("::: Property File 3 Data :::");
			System.out.println(properties.getProperty("ENCRYPTION_KEY2"));
			System.out.println(properties.getProperty("USERNAME2"));
			System.out.println(properties.getProperty("PASSWORD2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
