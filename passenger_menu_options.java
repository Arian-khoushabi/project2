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
    public void BookTickets(Flights[] flights,Admin admin,int index){
        int flag=0;
        System.out.println("The available tickets are:");
        for (int i=0;i<=index;i++){
            System.out.println(flights[i].getFlightId());
        }
        System.out.println("Enter your Flight_Id:");
        String flightID=input.next();
        for(int i=0;i<10;i++){
            if(Objects.equals(flights[i].getFlightId(), flightID)){
                if (flights[i].getIntPrice()<=admin.getCharge()) {
                    for (int j = 0; j < 10; j++) {
                        if (Objects.equals(admin.getBookedTickets(j), "_")) {
                            flights[i].setSeats((flights[i].getSeats())-1);
                            flights[i].setSeat();
                            admin.setBookedTickets(flightID, j);
                            admin.setCharge(admin.getCharge()-(flights[i].getIntPrice()));
                            flag++;
                            break;
                        }
                    }
                }
                else {
                    System.err.println("NOT ENOUGH CHARGE!");
                    flag++;
                    break;
                }
            }
        }
        if (flag==0){
            System.err.println("NOT FOUND!");
        }
    }

    public void CancelTickets(Flights[] flights,Admin admin){
        int flag=0;
        System.out.println("Enter your Flight_Id:");
        String flightID=input.next();
        for(int i=0;i<10;i++){
            if(Objects.equals(flightID, admin.getBookedTickets(i))){
                for(int j=0;j<10;j++){
                    if(Objects.equals(flights[j].getFlightId(), flightID)){
                        flights[j].setSeats((flights[j].getSeats())+1);
                        flights[j].setSeat();
                        admin.setBookedTickets("_",i);
                        admin.setCharge(admin.getCharge()+flights[j].getIntPrice());
                        Shift(admin,i);
                        flag++;
                        break;
                    }
                }
            }
        }
        if (flag==0){
            System.err.println("NOT FOUND!");
        }
    }

    public void ShowMyTickets(Admin admin,Flights[] flights){
        int flag=0;
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
                        flag++;
                    }
                }
                System.out.println();
            }
        }
        if (flag==0){
            System.err.println("YOU DONT HAVE ANY TICKETS!");
        }
    }

    public void AddCharge(Admin admin){
        System.out.println("your charge is:");
        System.out.println(admin.getCharge());
        System.out.println("Enter the amount of money you wanna add to your charge:");
        int addition=input.nextInt();
        admin.setCharge(admin.getCharge()+addition);
    }
    private void Shift(Admin passengers,int index){
        for (int i = index ; i <9 ; i++) {
            passengers.setBookedTickets(passengers.getBookedTickets(i+1),i);
        }
    }

}
