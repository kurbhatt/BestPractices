package org.java8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * Created by Keyur on 19-10-2016.
 * This Class Demonstrates java.time API package and it's Functionality with Basic Utilities.
 */
public class TimeAPI {

	public static void main(String[] args) {

		Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
		// List of Available Time Zones
		System.out.println(":: Available Time Zones ::");
		availableZoneIds.forEach(System.out::println);

		// LocalDate Class
		LocalDate date = LocalDate.now();
		System.out.println("Current Date: " + date);

		// LocalTime Class
		LocalTime time = LocalTime.now();
		System.out.println("Current Time: " + time);
		System.out.println("Current Time in Monaco: " + LocalTime.now(ZoneId.of("Europe/Monaco")));

		// LocalDateTime Class
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("Current Date Time: " + dateTime);

		// Instant Class - Stores date in unix timestamp
		Instant instant = Instant.now();
		System.out.println("Instant: " + instant);

		// Duration Class
		Duration duration = Duration.ofDays(2); // This will Calculate Duration in Hours from Given Days in Argument
		System.out.println("Duration: " + duration);

		// java.time Utilities
		System.out.println(date.getYear() + " is Leap Year? " + date.isLeapYear());

		// Last Day of Year
		LocalDate lastDayOfYear = date.with(TemporalAdjusters.lastDayOfYear());
		System.out.println("Last Day of Year: " + lastDayOfYear);

		// Period Class
		Period period = date.until(lastDayOfYear);
		System.out.println("Period of Today to Last Day of Year: " + period);
	}
}
