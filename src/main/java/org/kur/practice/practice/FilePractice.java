package org.kur.practice.practice;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Keyur on 21-07-2016.
 */
public class FilePractice {

	public static void main(String[] args) {
		BufferedOutputStream bs = null;

		try {
			FileOutputStream fs = new FileOutputStream(new File(System.getProperty("user.home")+"/test.txt"));
			bs = new BufferedOutputStream(fs);
			bs.write(0);
			bs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
