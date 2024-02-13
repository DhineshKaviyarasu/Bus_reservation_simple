package Bus_reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Passenger {
    private String psgName;
    private int busNo;
    private Date date;

    Passenger() throws ParseException {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter passenger name:");
        psgName=input.next();
        System.out.println("Enter bus no:");
        busNo= input.nextInt();
        System.out.println("Enter date dd-mm-yyyy:");
        String dateInput=input.next();
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        date=dateFormat.parse(dateInput);
    }
    public boolean isAvaliable(ArrayList<Passenger> bookings,ArrayList<Bus> buses){
        int capacity=0;
        for (Bus bus:buses) {
            if (bus.getBusNo() == busNo) {
                capacity = bus.getCapacity();
            }
        }
            int booked=0;
            for (Passenger b:bookings){
                if(b.busNo==busNo && b.equals(date)){
                    booked++;
                }
            }


        return booked<capacity?true:false;
    }

}
