package hotelReservationsystem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class HotelReservationSystem  {

    ArrayList<HotelInfo> hotelInfo = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    HotelInfo hotelReservation;
    public void addHotel() {
        hotelInfo.add(new HotelInfo("LakeWood", 110,3,90));
        hotelInfo.add(new HotelInfo("BridgeWood", 160,4,50));
        hotelInfo.add(new HotelInfo("RidgeWood", 220,5,150));
        hotelInfo.stream().forEach(System.out::println);
    }

    public boolean toCheckDate(String dateToReserved, String dateFromat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(dateToReserved);
            Calendar currentDateAfter3Months = Calendar.getInstance();
            currentDateAfter3Months.add(Calendar.MONTH, 3);

            Calendar currentDateBefore3Months = Calendar.getInstance();
            currentDateBefore3Months.add(Calendar.MONTH, -3);

            if (date.before(currentDateAfter3Months.getTime()) && date.after(currentDateBefore3Months.getTime())) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

    }
    public String CheapestHotelAndRate(String arrivalDate, String checkoutDate) throws ParseException {
        String dateRegex = "^(([0-9])|([0-2][0-9])|([3][0-1]))(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\d{4}$";
        if(!arrivalDate.matches(dateRegex) && !checkoutDate.matches(dateRegex)) {
            System.out.println("Invalid date");
            System.exit(0);
        }
        Date StartDate = convertStringToDate(arrivalDate);
        Date EndDate = convertStringToDate(checkoutDate);
        long Duration = EndDate.getTime()-StartDate.getTime();
        int Days = (int) TimeUnit.DAYS.convert(Duration,TimeUnit.MILLISECONDS);

        for (int hotel = 0; hotel < hotelInfo.size(); hotel++) {
            int newRate = hotelInfo.get(hotel).getWeekDayRate() * (Days+1);
            hotelInfo.get(hotel).setWeekDayRate(newRate);
        }
        int regularRate = hotelInfo.stream().min(Comparator.comparing(HotelInfo::getWeekDayRate)).get().getWeekDayRate();
        String hotelName = hotelInfo.stream().min(Comparator.comparing(HotelInfo::getWeekDayRate)).get().getHotelName();

        System.out.println(hotelName + ", Total Rates: $" + regularRate);

        return hotelName + ", $" + regularRate;

    }
    public Date convertStringToDate(String dateString) throws ParseException {
        Date date;
        DateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
        date = dateFormat.parse(dateString);
        return date;
    }
}
