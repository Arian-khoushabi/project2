import java.util.Objects;
import java.util.Scanner;

public class passenger_menu_options {
    Scanner input= new Scanner(System.in);
    public int Show_passenger_menu() {
        for (int i = 1; i <= 60; i++) {
            System.out.print(":");
        }
        System.out.println();
        for (int i = 1; i <= 19; i++) {
            System.out.print(" ");
        }
        System.out.print("PASSENGER MENU OPTIONS");
        System.out.println();
        for (int i = 1; i <= 60; i++) {
            System.out.print(":");
        }
        System.out.println();
        for (int i = 1; i <= 60; i++) {
            System.out.print(".");
        }
        System.out.println();
        System.out.println("<1> Change password");
        System.out.println("<2> Search flight tickets");
        System.out.println("<3> Booking tickets");
        System.out.println("<4> Ticket cancellation");
        System.out.println("<5> Booked tickets");
        System.out.println("<6> Add charge");
        System.out.println("<0> Sign out");

        int digit=input.nextInt();
        return digit;
    }

    public void password_change(Admin admin){
        int password=input.nextInt();
        admin.setPassword(password);
    }

    public void FindTickets(String FlightTable[][],String Fields[],Admin admin){
        int a=0;
        int b=0;
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                if(Objects.equals(Fields[i], FlightTable[0][j])){
                    String searchField=input.next();
                    for (int k=0;k<7;k++){
                        if(Objects.equals(searchField, FlightTable[k][j])){
                          admin.setSearchTickets(searchField,a);
                          admin.setSearchTickets(String.valueOf(j),a+1);
                          b=j;
                          a=a+2;
                          break;
                        }
                    }
                }
            }
        }
        for(int i=1;i<=11;i=i+2){
            if(!Objects.equals(admin.getSearchTickets(i), admin.getSearchTickets(i + 2))){
                System.err.println("NOT FOUND!");
            }
            else {
                for(int j=0;j<7;j++){
                    System.out.print(FlightTable[b][j]+"   ");
                }
            }
        }
    }

    public void BookTickets(Flights[] flights,Admin admin){
        String flightID=input.next();
        for(int i=0;i<10;i++){
            if(Objects.equals(flights[i].getFlightId(), flightID)){
                if (flights[i].getIntPrice()>=admin.getCharge()) {
                    for (int j = 0; j < 10; j++) {
                        if (Objects.equals(admin.getBookedTickets(j), "_")) {
                            flights[i].seatReserve();
                            flights[i].setSeat();
                            admin.setBookedTickets(flightID, j);
                            admin.setCharge(admin.getCharge()-flights[i].getIntPrice());
                            break;
                        }
                    }
                }
                else {
                    System.out.println("NOT ENOUGH CHARGE!");
                }
            }
        }
    }

    public void CancelTickets(Flights[] flights,Admin admin){
        String flightID=input.next();
        for(int i=0;i<10;i++){
            if(Objects.equals(flightID, admin.getBookedTickets(i))){
                for(int j=0;j<10;j++){
                    if(Objects.equals(flights[j].getFlightId(), flightID)){
                        flights[j].seatUnreserved();
                        flights[j].setSeat();
                        admin.setBookedTickets("_",i);
                        admin.setCharge(admin.getCharge()+flights[j].getIntPrice());
                    }
                }
            }
        }
    }

    public void ShowMyTickets(Admin admin,Flights[] flights){
        for(int i = 0 ; i<10 ; i++) {
            if (!Objects.equals(admin.getBookedTickets(i), "_")) {
                for (int j = 0; j < 10; j++) {
                    if (Objects.equals(admin.getBookedTickets(i), flights[j].getFlightId())) {
                        System.out.print(flights[j].getFlightId()+"  ");
                        System.out.print(flights[j].getOrigin()+"  ");
                        System.out.print(flights[j].getDestination()+"  ");
                        System.out.print(flights[j].getDate()+"  ");
                        System.out.print(flights[j].getTime()+"  ");
                        System.out.print(flights[j].getStringPrice()+"  ");
                        System.out.print(flights[j].getSeat()+"  ");
                    }
                }
                System.out.println();
            }
        }
    }

    public void AddCharge(Admin admin){
        int addition=input.nextInt();
        admin.setCharge(admin.getCharge()+addition);
    }


}
