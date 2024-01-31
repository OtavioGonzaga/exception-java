import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class App {
	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Room number: ");
		int roomNum = scanner.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkinDate = Reservation.DATE_FORMAT.parse(scanner.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkoutDate = Reservation.DATE_FORMAT.parse(scanner.next());

		Date dateNow = new Date();
		if (!checkoutDate.after(checkinDate)) {
			System.out.println("Error in reservation: The check-out date must be after the check-in date");
		} else if(checkinDate.before(dateNow)) {
			System.out.println("Error in reservation: The check-in date must be a future date");
		} else {
			Reservation reservation = new Reservation(roomNum, checkinDate, checkoutDate);
			System.out.println(reservation.toString());

			System.out.printf("%nEnter data to upload the reservation: %n");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkinDate = Reservation.DATE_FORMAT.parse(scanner.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkoutDate = Reservation.DATE_FORMAT.parse(scanner.next());
			
			if (!checkoutDate.after(checkinDate)) {
				System.out.println("Error in reservation: The check-out date must be after the check-in date");
			} else if(checkinDate.before(dateNow)) {
				System.out.println("Error in reservation: The check-in date must be a future date.");
			} else {
				reservation.updateDates(checkinDate, checkoutDate);
				System.out.println(reservation.toString());
			}
		}

		scanner.close();
	}
}