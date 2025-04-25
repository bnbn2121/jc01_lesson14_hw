package com.edu.less14.homework01;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public final class PrinterUtil {
	public static void printListAirlines(String message, List<Airline> list) {
		if (list == null) {
			return;
		}
		System.out.println(message);
		int count = 0;
		for (Airline airline : list) {
			System.out.printf("%4d. ", ++count);
			printAirline(airline);
		}
		System.out.println("*".repeat(135));
	}

	public static void printAirline(Airline airline) {
		System.out.printf("Рейс номер %6s | %14s | Тип самолета: %12s | Время вылета: %6s | ",
				airline.getFlightNumber(), airline.getDestination(), airline.getPlaneType(),
				airline.getDepartureTime());
		System.out.print("Дни недели: ");
		for (DayOfWeek day : airline.getDaysOfWeek()) {
			System.out.printf("%s ", day.name());
		}
		System.out.println();
	}

	public static void printFilterCriteria(String destination, int hour, int minute, boolean searchAfterTime,
			DayOfWeek day) {
		System.out.println("Критерии выбора:");
		if (destination != null) {
			System.out.println("Направление: " + destination);
		}
		if (hour != 0) {
			LocalTime filterTime = LocalTime.of(hour, minute);
			if (searchAfterTime) {
				System.out.println("Время вылета после: " + filterTime);
			} else {
				System.out.println("Время вылета до: " + filterTime);
			}

		}
		if (day != null) {
			System.out.println("День недели: " + day);
		}
		System.out.println();
	}
}
