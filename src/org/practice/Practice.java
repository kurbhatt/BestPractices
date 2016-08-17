package org.practice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Created by Keyur on 20-07-2016.
 */
public class Practice {

	public static void main(String[] args) {
		String stringDate = "06-05-2016";
		try {
			DateFormat format = new SimpleDateFormat("dd-M-yyyy");
			Date dt = format.parse(stringDate);
			System.out.println("DATE :: " + dt);

			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(dt);
			XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
			System.out.println("XGC :: " + xgc);

		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
	}
}
