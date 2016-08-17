package org.practice;

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
			FileOutputStream fs = new FileOutputStream(new File("/Attachment/test.txt"));
			bs = new BufferedOutputStream(fs);
			bs.write(111);
			bs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
