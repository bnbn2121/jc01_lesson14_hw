package com.edu.less14.homework01;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Airline {
	private String destination;
	private String flightNumber;
	private String planeType;
	private LocalTime departureTime;
	private List<DayOfWeek> daysOfWeek = new ArrayList<DayOfWeek>();

	public Airline() {
	}

	public Airline(String destination, String flightNumber, String planeType, int departureHour, int departureMinute,
			DayOfWeek[] daysOfWeek) {
		this.destination = destination;
		this.flightNumber = flightNumber;
		this.planeType = planeType;
		this.departureTime = LocalTime.of(departureHour, departureMinute);
		for (DayOfWeek day : daysOfWeek) {
			this.daysOfWeek.add(day);
		}
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getPlaneType() {
		return planeType;
	}

	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(int departureHour, int departureMinute) {
		this.departureTime = LocalTime.of(departureHour, departureMinute);
	}

	public List<DayOfWeek> getDaysOfWeek() {
		return daysOfWeek;
	}

	public void setDaysOfWeek(DayOfWeek[] daysOfWeek) {
		this.daysOfWeek.clear();
		for (DayOfWeek day : daysOfWeek) {
			this.daysOfWeek.add(day);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(daysOfWeek, departureTime, destination, flightNumber, planeType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airline other = (Airline) obj;
		return Objects.equals(daysOfWeek, other.daysOfWeek) && Objects.equals(departureTime, other.departureTime)
				&& Objects.equals(destination, other.destination) && Objects.equals(flightNumber, other.flightNumber)
				&& Objects.equals(planeType, other.planeType);
	}

	@Override
	public String toString() {
		return "Airline [" + (destination != null ? "destination=" + destination + ", " : "")
				+ (flightNumber != null ? "flightNumber=" + flightNumber + ", " : "")
				+ (planeType != null ? "planeType=" + planeType + ", " : "")
				+ (departureTime != null ? "departureTime=" + departureTime + ", " : "")
				+ (daysOfWeek != null ? "daysOfWeek=" + daysOfWeek : "") + "]";
	}

}
