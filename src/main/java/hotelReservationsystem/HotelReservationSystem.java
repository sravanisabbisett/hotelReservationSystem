package hotelReservationsystem;

import java.util.ArrayList;

public class HotelReservationSystem  {

    public String hotelName;
    public int ratesForRegularCustomer;

   public  void addHotelNameAndRatesForRegularCustomer() throws Throwable {
       ArrayList<HotelInfo> hotelInfo=new ArrayList<HotelInfo>();
       hotelInfo.add(new HotelInfo("LakeWood",110));
       hotelInfo.add(new HotelInfo("BridgeWood",160));
       hotelInfo.add(new HotelInfo("RidgeWood",220));
       hotelInfo.stream().forEach(System.out::println);
   }
}
