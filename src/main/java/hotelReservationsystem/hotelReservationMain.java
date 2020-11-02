package hotelReservationsystem;

public class hotelReservationMain extends HotelReservationSystem{

    public static void main(String[] args) throws Throwable {
        hotelReservationMain hotelReservationMain=new hotelReservationMain();
        System.out.println("Welcome to Hotel Reservation System");
        hotelReservationMain.addHotelNameAndRatesForRegularCustomer();
    }
}
