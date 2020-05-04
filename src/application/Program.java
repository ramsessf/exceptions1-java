package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;
import exceptions.DomainException;

public class Program {

	public static void main(String[] args){

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);
        
		try {
			System.out.print("Room number: ");
			Integer roomNumber = sc.nextInt();

			System.out.print("check-in date (dd/MM/yyyy):");
			sc.nextLine();
			Date checkin = sdf.parse(sc.nextLine());

			System.out.print("check-out date (dd/MMM/yyyy):");
			Date checkout = sdf.parse(sc.nextLine());

			Reservation reservation = new Reservation(roomNumber, checkin, checkout);

			System.out.println("Reservation: " + reservation);
	//------------------------------------------------------------- Atualizacao de Reserva
			System.out.println();
			System.out.println("Enter data to update the reservation:");

			System.out.print("check-in date (dd/MM/yyyy):");
			checkin = sdf.parse(sc.nextLine());

			System.out.print("check-out date (dd/MMM/yyyy):");
			checkout = sdf.parse(sc.nextLine());

			reservation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);

			
		} catch (ParseException e) {
			System.out.println("Invalid date format");
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		 
		sc.close();
	}

}
