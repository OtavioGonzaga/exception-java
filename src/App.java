import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.print("Room number: ");
			int roomNum = scanner.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkinDate = Reservation.DATE_FORMAT.parse(scanner.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkoutDate = Reservation.DATE_FORMAT.parse(scanner.next());

			Reservation reservation = new Reservation(roomNum, checkinDate, checkoutDate);
			System.out.println(reservation.toString());

			System.out.printf("%nEnter data to upload the reservation: %n");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkinDate = Reservation.DATE_FORMAT.parse(scanner.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkoutDate = Reservation.DATE_FORMAT.parse(scanner.next());

			reservation.updateDates(checkinDate, checkoutDate);
			System.out.println(reservation.toString());
		} catch (ParseException e) {
			System.out.println("Invalid date format");
		} catch (DomainException e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Invalid type of input");
		} catch (RuntimeException e) {
			System.out.println("Unxpected exception");
	 	} finally {
			scanner.close();
		}
	}
}