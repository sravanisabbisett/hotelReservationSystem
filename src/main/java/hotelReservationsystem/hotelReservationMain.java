package hotelReservationsystem;

import java.util.Scanner;

public class hotelReservationMain extends HotelReservationSystem{


    public static void main(String[] args) throws Throwable {
        Scanner scanner = new Scanner(System.in);
        hotelReservationMain hotelReservationMain=new hotelReservationMain();
        HotelReservationSystem hotelReservationSystem=new HotelReservationSystem();
        System.out.println("Welcome to Hotel Reservation System");
        System.out.println("Enter arrival date: ");
        String arrivalDate = scanner.nextLine();
        System.out.println("Enter the checkout date: ");
        String checkoutDate =scanner.nextLine();
        hotelReservationSystem.addHotel();
        hotelReservationSystem.CheapestHotelAndRate(arrivalDate,checkoutDate);

    }
}
