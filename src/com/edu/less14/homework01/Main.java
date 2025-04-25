package com.edu.less14.homework01;
/*
 * Создать класс Airline, спецификация которого приведена ниже.
 * Определить конструкторы, set- и get- методы и метод toString().
 * Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и методами.
 * Задать критерии выбора данных и вывести эти данные на консоль.
 * Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
 * Найти и вывести:
 * a) список рейсов для заданного пункта назначения;
 * b) список рейсов для заданного дня недели;
 * c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 */
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// Создаем и заполняем данными список рейсов
		List<Airline> SomeAirlinesList = new ArrayList<Airline>();
		fillList(SomeAirlinesList);
		
		//создаем объект Schedule, содержащий список рейсов
		Schedule schedule = new Schedule(SomeAirlinesList);
		schedule.printAirlines();
		
		//удаляем один из рейсов
		schedule.removeAirline(schedule.getAirlines().get(1));
		PrinterUtil.printListAirlines("Расписание рейсов после удаления рейса на Нью-Йорк",schedule.getAirlines());
		
		//изменяем в последнем рейсе время вылета
		schedule.changeAirline(schedule.getAirlines().get(2), null, null, null, 8, 37, null);
		PrinterUtil.printListAirlines("Расписание рейсов после изменения времени третьего рейса на 8-37",schedule.getAirlines());
		
		//проверяем работу фильтра
		schedule.filter("Москва", 10, 10, true, DayOfWeek.TUESDAY);

	}
	
	public static void fillList(List<Airline> list) {
		list.add(new Airline("Москва (SVO)", "SU-144", "Airbus A320", 18, 37,
				new DayOfWeek[] { DayOfWeek.FRIDAY, DayOfWeek.TUESDAY, DayOfWeek.SUNDAY }));
		list.add(new Airline("Нью-Йорк (JFK)", "DL-761", "Boeing 747", 14, 20,
				new DayOfWeek[] { DayOfWeek.THURSDAY, DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY }));
		list.add(new Airline("Дубай (DXB)", "EK-182", "Boeing 777", 22, 15,
				new DayOfWeek[] { DayOfWeek.MONDAY, DayOfWeek.THURSDAY, DayOfWeek.TUESDAY }));
		list.add(new Airline("Москва (SVO)", "SU-141", "Airbus A300", 17, 44,
				new DayOfWeek[] { DayOfWeek.FRIDAY, DayOfWeek.TUESDAY, DayOfWeek.MONDAY }));
		list.add(new Airline("Гомель (HML)", "LW-422", "Airbus A300", 13, 8,
				new DayOfWeek[] { DayOfWeek.WEDNESDAY, DayOfWeek.SUNDAY}));
	}

}
