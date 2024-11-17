package Railway_Ticket_Booking;

import java.util.*;

public class TicketBooker {

    static int availableLowerBerths = 1;
    static int availableMiddleBerths = 1;
    static int availableUpperBerths = 1;
    static int availableRacTickets = 1;
    static int availableWaitingLists =1;

    static List<Integer> bookedTicketList = new ArrayList<>();
    static Queue<Integer> bookedRacList = new LinkedList<>();
    static Queue<Integer> bookedWaitingList = new LinkedList<>();

    static List<Integer> lowerBerthsPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> middleBerthsPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> upperBerthsPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> racPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> waitingListPositions = new ArrayList<>(Arrays.asList(1));

    static Map<Integer,Passenger> passengerMap  = new HashMap<>();


    public void bookTicket(Passenger p,int berthInfo,String allotedBerth){
        p.seatNumber = berthInfo;
        p.alloted = allotedBerth;

        passengerMap.put(p.passengerId,p);
        bookedTicketList.add(p.passengerId);
        System.out.println("----------------------------------------Booked Successfully----------------------------------------");
    }
    public void bookRAC(Passenger p ,int racInfo , String allotedRac){
        p.seatNumber = racInfo;
        p.alloted = allotedRac;

        bookedRacList.add(p.passengerId);
        racPositions.remove(0);

        passengerMap.put(p.passengerId,p);
        availableRacTickets--;
        System.out.println("----------------------------------------Successfully added to RAC----------------------------------------");

    }
    public void bookWaitingList(Passenger p, int wlInfo, String allotedWL){
        p.seatNumber = wlInfo;
        p.alloted = allotedWL;

        bookedWaitingList.add(p.passengerId);
        passengerMap.put(p.passengerId,p);

        availableWaitingLists--;
        waitingListPositions.remove(0);
        System.out.println("----------------------------------------Successfully added to WaitingList----------------------------------------");

    }

    public void cancelTicket(int passengerId){
        Passenger p = passengerMap.get(passengerId);
        bookedTicketList.remove(passengerId);
        passengerMap.remove(passengerId);
        int position = p.seatNumber;
        System.out.println("----------------------------------------Successfully Cancelled----------------------------------------");

        if(p.alloted.equals("L")){
            availableLowerBerths++;
            lowerBerthsPositions.add(position);
        }else if(p.alloted.equals("M")){
            availableMiddleBerths++;
            middleBerthsPositions.add(position);
        }else if(p.alloted.equals("U")){
            availableUpperBerths++;
            upperBerthsPositions.add(position);
        }

        if(!bookedRacList.isEmpty()){
            Passenger passengerFromRAC = passengerMap.get(bookedRacList.poll());
            int positionRAC = passengerFromRAC.seatNumber;

            racPositions.add(positionRAC);
            bookedRacList.remove(passengerFromRAC.passengerId);
            availableRacTickets++;

            if(!bookedWaitingList.isEmpty()){
                Passenger passengerFromWaitingList = passengerMap.get(bookedWaitingList.poll());
                int positionWL = passengerFromWaitingList.seatNumber;

                waitingListPositions.add(positionWL);
                bookedWaitingList.remove(passengerFromWaitingList.passengerId);

                passengerFromWaitingList.seatNumber = racPositions.get(0);
                racPositions.remove(0);
                passengerFromWaitingList.alloted = "RAC";
                passengerMap.put(passengerFromWaitingList.passengerId,passengerFromWaitingList);

                availableRacTickets--;
                availableWaitingLists++;
            }
            Main.bookTicket(passengerFromRAC);
        }


    }

    public void availableTickets(){
        System.out.println("Available Lower Berths: "+availableLowerBerths);
        System.out.println("Available Middle Berths: "+ availableMiddleBerths);
        System.out.println("Available Upper Berths: "+availableUpperBerths);
        System.out.println("Available RAC: "+availableRacTickets);
        System.out.println("Available WaitingList: "+availableWaitingLists);
        System.out.print("----------------------------------------");
    }
    public void bookedTickets(){
        for(Passenger p : passengerMap.values()){
            System.out.println("\nPassenger ID: "+p.passengerId);
            System.out.println("Passenger Age: "+p.age);
            System.out.println("Passenger Name: "+p.name);
            System.out.println("Ticket Status: "+p.seatNumber+p.alloted);
            System.out.print("----------------------------------------");
        }
    }
}
