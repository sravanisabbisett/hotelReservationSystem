package hotelReservationsystem;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class ReadWrite {
    public  void Write(String Filename,ArrayList<HotelInfo> hotelInfo) throws Throwable {
        String path="C:\\Users\\PC\\IdeaProjects\\hotelManagementSystem\\src\\main\\java\\"+Filename;
        FileWriter writer=new FileWriter(path);
        String line1[]= {"HotelName","RatesForRegularCustomers"};
        writer.write(String.valueOf(line1));
        for(int a=0;a<hotelInfo.size();a++) {
            HotelInfo index=hotelInfo.get(a);
            String line2[]= {index.getHotelName(), String.valueOf(index.getWeekDayRate())};
            writer.write(String.valueOf(line2));
        }
        writer.flush();
    }
}
