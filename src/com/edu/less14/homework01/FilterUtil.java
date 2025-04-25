package com.edu.less14.homework01;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public final class FilterUtil {
	public static boolean checkDestination(Airline airline, String destination) {
		if (destination == null) {
			return true;
		}
		if (airline.getDestination().toLowerCase().contains(destination.toLowerCase())) {
			return true;
		}
		return false;
	}

	public static boolean checkAfterDepartureTime(Airline airline, int hour, int minute) {
		if (hour == -1) {
			return true;
		}
		LocalTime checkTime = LocalTime.of(hour, minute);
		if (airline.getDepartureTime().isAfter(checkTime)) {
			return true;
		}
		return false;
	}

	public static boolean checkBeforeDepartureTime(Airline airline, int hour, int minute) {
		if (hour == -1) {
			return true;
		}
		LocalTime checkTime = LocalTime.of(hour, minute);
		if (airline.getDepartureTime().isBefore(checkTime)) {
			return true;
		}
		return false;
	}

	public static boolean checkDayOfWeek(Airline airline, DayOfWeek day) {
		if (day == null) {
			return true;
		}
		if (airline.getDaysOfWeek().contains(day)) {
			return true;
		}
		return false;
	}
	
	public static List<Airline> generalFilter(Schedule schedule, String destination, int hour, int minute, boolean searchAfterTime,
			DayOfWeek day) {
		List<Airline> filtredAirlines = new ArrayList<Airline>();
		for (Airline airline : schedule.getAirlines()) {
			if (FilterUtil.checkDestination(airline, destination) && 
					(searchAfterTime ? FilterUtil.checkAfterDepartureTime(airline, hour, minute)	:
						FilterUtil.checkBeforeDepartureTime(airline, hour, minute)) && 
					FilterUtil.checkDayOfWeek(airline, day)) {
				filtredAirlines.add(airline);
			}
		}
		if (filtredAirlines.size() > 0) {
			return filtredAirlines;
		}
		return null;
	}
}
