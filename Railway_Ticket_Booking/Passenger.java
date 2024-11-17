package Railway_Ticket_Booking;

public class Passenger {
    static int id=1;
     String name;
     int age;
     String berthPreference;
     int passengerId;
     String alloted;
     int seatNumber;

     Passenger(String name, int age, String berthPreference){
        this.name = name;
        this.age = age;
        this.berthPreference = berthPreference;
        this.passengerId = id++;
        alloted = "";
        seatNumber = -1;
     }

}
