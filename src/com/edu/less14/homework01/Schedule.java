package com.edu.less14.homework01;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Schedule {
	private List<Airline> airlines = new ArrayList<Airline>();

	public Schedule(List<Airline> airlines) {
		this.airlines = airlines;
		sortAirlinesByTime();
	}

	public List<Airline> getAirlines() {
		return airlines;
	}

	public void setAirlines(List<Airline> airlines) {
		this.airlines = airlines;
		sortAirlinesByTime();
	}
	
	public void printAirlines() {
		PrinterUtil.printListAirlines("Расписание рейсов:", airlines);
	}

	public boolean addAirline(Airline airline) {
		if (airlines.contains(airline)) {
			return false;
		}
		airlines.add(airline);
		sortAirlinesByTime();
		return true;
	}

	public boolean removeAirline(Airline airline) {
		if (airlines.contains(airline)) {
			airlines.remove(airline);
			return true;
		}
		return false;
	}

	public boolean changeAirline(Airline airline, String destination, String flightNumber, String planeType,
			int departureHour, int departureMinute, DayOfWeek[] daysOfWeek) {
		if (airlines.contains(airline)) {
			if (destination != null) {
				airline.setDestination(destination);
			}
			if (flightNumber != null) {
				airline.setFlightNumber(flightNumber);
			}
			if (planeType != null) {
				airline.setPlaneType(planeType);
			}
			if (departureHour != -1 && departureMinute != -1) {
				airline.setDepartureTime(departureHour, departureMinute);
			}
			if (daysOfWeek != null && daysOfWeek.length > 0) {
				airline.setDaysOfWeek(daysOfWeek);
			}
			sortAirlinesByTime();
			return true;
		}
		return false;
	}
	
	public void filter(String destination, int hour, int minute, boolean searchAfterTime, DayOfWeek day) {
		List<Airline> filtredAirlines = FilterUtil.generalFilter(this, destination, hour, minute, searchAfterTime, day);
		if (filtredAirlines == null) {
			System.out.println("По данным параметрам нет подходящих рейсов");
		} else {
			PrinterUtil.printFilterCriteria(destination, hour, minute, searchAfterTime, day);
			PrinterUtil.printListAirlines("Рейсы по выбранным параметрам:", filtredAirlines);
		}
	}
	
	private void sortAirlinesByTime() {
		if (airlines == null) {
			return;
		}
		int countChanges;
		do {
			countChanges = 0;
			for (int i = 1; i < airlines.size(); i++) {
				if (airlines.get(i - 1).getDepartureTime().isAfter(airlines.get(i).getDepartureTime())) {
					Airline tmp = airlines.get(i);
					airlines.set(i, airlines.get(i - 1));
					airlines.set(i - 1, tmp);
					countChanges++;
				}
			}
		} while (countChanges > 0);
	}

	@Override
	public int hashCode() {
		return Objects.hash(airlines);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		return Objects.equals(airlines, other.airlines);
	}

	@Override
	public String toString() {
		return "Schedule [" + (airlines != null ? "airlines=" + airlines : "") + "]";
	}

}
