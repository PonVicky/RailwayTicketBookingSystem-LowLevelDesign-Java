package Railway_Ticket_Booking;

import java.util.Scanner;

public class Main {

    public static void bookTicket(Passenger p){
        TicketBooker booker = new TicketBooker();
        if(TicketBooker.availableWaitingLists == 0){
            System.out.println("No Tickets available\n");
        }
        if(p.berthPreference.equals("L") && TicketBooker.availableLowerBerths >0 ||
            p.berthPreference.equals("M") && TicketBooker.availableMiddleBerths >0 ||
            p.berthPreference.equals("U") && TicketBooker.availableUpperBerths>0){
            System.out.println("Preferred Berth available");
            if(p.berthPreference.equals("L")){
                System.out.println("Lower Berth alloted");
                booker.bookTicket(p,TicketBooker.lowerBerthsPositions.get(0),"L");

                TicketBooker.lowerBerthsPositions.remove(0);
                TicketBooker.availableLowerBerths--;
            }else if(p.berthPreference.equals("M")){
                System.out.println("Middle Berth Alloted");
                booker.bookTicket(p,TicketBooker.middleBerthsPositions.get(0),"M");

                TicketBooker.middleBerthsPositions.remove(0);
                TicketBooker.availableMiddleBerths--;

            }else if(p.berthPreference.equals("U")){
                System.out.println("Upper Berth Alloted");
                booker.bookTicket(p,TicketBooker.upperBerthsPositions.get(0),"U");

                TicketBooker.upperBerthsPositions.remove(0);
                TicketBooker.availableUpperBerths--;
            }
        }else if(TicketBooker.availableLowerBerths>0){
            System.out.println("Preferred Berth NOT-AVAILABLE\n");
            System.out.println("Lower Berth Alloted");
            booker.bookTicket(p,TicketBooker.lowerBerthsPositions.get(0),"L");

            TicketBooker.lowerBerthsPositions.remove(0);
            TicketBooker.availableLowerBerths--;
        }else if(TicketBooker.availableMiddleBerths>0){
            System.out.println("Preferred Berth NOT-AVAILABLE\n");
            System.out.println("Middle Berth Alloted");
            booker.bookTicket(p,TicketBooker.middleBerthsPositions.get(0),"M");

            TicketBooker.middleBerthsPositions.remove(0);
            TicketBooker.availableMiddleBerths--;
        }else if(TicketBooker.availableUpperBerths>0){
            System.out.println("Preferred Berth NOT-AVAILABLE\n");
            System.out.println("Upper Berth Alloted");
            booker.bookTicket(p,TicketBooker.upperBerthsPositions.get(0),"U");

            TicketBooker.upperBerthsPositions.remove(0);
            TicketBooker.availableUpperBerths--;
        }else if(TicketBooker.availableRacTickets>0){
            System.out.println("RAC alloted");
            booker.bookRAC(p,TicketBooker.racPositions.get(0),"RAC");
        }else if(TicketBooker.availableWaitingLists>0){
            System.out.println("Alloted to WaitingList");
            booker.bookWaitingList(p,TicketBooker.waitingListPositions.get(0),"WL");
        }

    }

    public static void cancelTicket(int id){
        TicketBooker booker = new TicketBooker();
        if(!booker.passengerMap.containsKey(id)){
            System.out.println("Passenger Doesn't exist!\n");
        }else{
            booker.cancelTicket(id);
        }
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int out;
        System.out.print("---------------------------------------- Railway Ticket Reservation System ----------------------------------------");
        do{
            System.out.println("\n 1.Book Ticket\n 2.Cancel Ticket\n 3.Print Available ticket\n 4.Print Booked ticket\n 5.Exit");
            System.out.print("Enter your choice: ");
            out = in.nextInt();

            switch (out){
                case 1:{
                    System.out.println("Enter your name and age: ");
                    String name = in.next();
                    int age = in.nextInt();
                    System.out.print("Enter your Preferred Berth(L,M or U): ");
                    String preferredBerth = in.next();
                    Passenger p =  new Passenger(name,age,preferredBerth);

                    bookTicket(p);
                }break;
                case 2:{
                    System.out.print("Enter the Passenger ID: ");
                    int id  = in.nextInt();
                    cancelTicket(id);
                }break;
                case 3:{
                    TicketBooker booker = new TicketBooker();
                    booker.availableTickets();
                }break;
                case 4:{
                    TicketBooker booker = new TicketBooker();
                    if(TicketBooker.bookedTicketList.isEmpty()){
                        System.out.println("There are no passengers!");
                        System.out.print("----------------------------------------");
                        break;
                    }else{
                        booker.bookedTickets();
                    }
                }break;
                case 5:{
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("     Thank you for using this Train Ticket Reservation System");
                    System.out.println("-------------------------------------------------------------------");
                }break;
            }
        }while(out!=5);

    }
}
