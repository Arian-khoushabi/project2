import java.util.Objects;
import java.util.Scanner;

public class Admin_menu_option {
    Scanner input = new Scanner(System.in);
    public int Show_Admin_menu() {
        for (int i = 1; i <= 60; i++) {
            System.out.print(":");
        }
        System.out.println();
        for (int i = 1; i <= 21; i++) {
            System.out.print(" ");
        }
        System.out.print("ADMIN MENU OPTIONS");
        System.out.println();
        for (int i = 1; i <= 60; i++) {
            System.out.print(":");
        }
        System.out.println();
        for (int i = 1; i <= 60; i++) {
            System.out.print(".");
        }
        System.out.println();
        System.out.println("<1> Add");
        System.out.println("<2> Update");
        System.out.println("<3> Remove");
        System.out.println("<4> Flight schedules");
        System.out.println("<0> Sign out");

        int digit=input.nextInt();
        return digit;
    }
    public void ADD_update(Flights[] flights, int row_number){
        System.out.println(" Flight_Id:");
        String FlightID=input.next();
        System.out.println(" Origin:");
        String Origin=input.next();
        System.out.println(" Destination:");
        String Destination = input.next();
        System.out.println(" Date:");
        String Date=input.next();
        System.out.println(" Time:");
        String Time = input.next();
        System.out.println(" Price:");
        int Price = input.nextInt();
        System.out.println(" Seats:");
        int Seats =input.nextInt();
        flights[row_number].setFlightId(FlightID);
        flights[row_number].setOrigin(Origin);
        flights[row_number].setDestination(Destination);
        flights[row_number].setDate(Date);
        flights[row_number].setTime(Time);
        flights[row_number].setPrice(Price);
        flights[row_number].setSeats(Seats);
        flights[row_number].setSeat();


    }
    public void Remove(Flights[] flights, int row_number,Admin[] passengers){
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 10; j++) {
                if (Objects.equals(passengers[i].getBookedTickets(j), flights[row_number].getFlightId())){
                    passengers[i].setBookedTickets("_",j);
                    passengers[i].setCharge(passengers[i].getCharge()+flights[row_number].getIntPrice());
                }
            }
        }
        flights[row_number].setFlightId("_");
        flights[row_number].setOrigin("_");
        flights[row_number].setDestination("_");
        flights[row_number].setDate("_");
        flights[row_number].setTime("_");
        flights[row_number].setPrice(0);
        flights[row_number].setSeats(0);
        flights[row_number].setSeat();

    }
}
