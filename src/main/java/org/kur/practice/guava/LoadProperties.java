package org.kur.practice.guava;

import com.google.common.io.ByteSource;
import com.google.common.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * This Class Demonstrate the use of google.guava library to load properties file.
 * Created by Keyur on 3/2/17.
 */
public class LoadProperties {

    public static void main(String[] args) {
        URL url = Resources.getResource("csvfile.properties");
        ByteSource byteSource = Resources.asByteSource(url);
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = byteSource.openBufferedStream();
            properties.load(inputStream);
            properties.list(System.out); // This will print whole file content.
            System.out.println(properties.get("ids")); // This will specific property by key.
        } catch (final IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (final IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}
