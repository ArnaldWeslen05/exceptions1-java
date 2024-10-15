package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entites.Resevation;

public class Progam {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro in  Resevation : Check-out date must be after check-in date");
		} else {
			Resevation resevation = new Resevation(number, checkIn, checkOut);
			System.out.println("Resevation" + resevation);

			System.out.println();
			System.out.println("Enter data to update the resavation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in resavation: Resevation dates for updates must be future dates.");
			} else if (checkOut.after(checkIn)) {
				System.out.println("Erro in  Resevation : Check-out date must be after check-in date");
			} else {
				resevation.updateDate(checkIn, checkOut);

				System.out.println("Resevation" + resevation);
			}
		}

		sc.close();
	}

}
