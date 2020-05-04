package solucaoMuitoRuim.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import solucaoMuitoRuim.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);

		System.out.print("Room number: ");
		Integer roomNumber = sc.nextInt();

		System.out.print("check-in date (dd/MM/yyyy):");
		sc.nextLine();
		Date checkin = sdf.parse(sc.nextLine());

		System.out.print("check-out date (dd/MMM/yyyy):");
		Date checkout = sdf.parse(sc.nextLine());

		Reservation reservation = new Reservation(roomNumber, checkin, checkout);
		
		if(!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date!");
		}

		System.out.println("Reservation: " + reservation);
//------------------------------------------------------------- Atualizacao de Reserva
		System.out.println();
		System.out.println("Enter data to update the reservation:");

		System.out.print("check-in date (dd/MM/yyyy):");
		checkin = sdf.parse(sc.nextLine());

		System.out.print("check-out date (dd/MMM/yyyy):");
		checkout = sdf.parse(sc.nextLine());

		Date now = new Date();
		if (checkin.before(now) || checkout.before(now)) {
			System.out.println("Error in reservation: dates for update must be futures!");

		} else if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date!");

		} else {
			reservation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);
		}

	}

}
