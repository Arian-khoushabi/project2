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
        String FlightID=input.next();
        String Origin=input.next();
        String Destination = input.next();
        String Date=input.next();
        String Time = input.next();
        int Price = input.nextInt();
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
    public void Remove(Flights[] flights, int row_number){
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