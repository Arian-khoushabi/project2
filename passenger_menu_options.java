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

    public void FindTickets(String[][] FlightTable) {
        System.out.println("please enter the number of fields you wanna search:");
        int n = input.nextInt();
        int[] Fields = new int[n];
        String[] search_Field_Array=new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("according to your search fields, enter one of this fallowing numbers:");
            System.out.println("0 for Flight_id");
            System.out.println("1 for origin");
            System.out.println("2 for Destination");
            System.out.println("3 for date");
            System.out.println("4 for Time");
            System.out.println("5 for price");
            System.out.println("6 for seats");
            int fieldNumber=input.nextInt();
            Fields[i] = fieldNumber;
        }
        for (int k = 0; k < n; k++) {
            int flag=0;
            System.out.println("Enter your phrase:");
                    String searchField=input.next();
                    for (int j = 0; j < 10; j++) {
                        if (Objects.equals(FlightTable[j][Fields[k]], searchField)){
                            search_Field_Array[k]=searchField;
                            flag++;
                            break;
                        }
                    }
                    if (flag==0){
                        System.out.println("NOT FOUND");
                        break;
                    }
                }
        for (int k = 0; k < n; k++) {
            for (int i = 1; i <10 ; i++) {
                    if (Objects.equals(FlightTable[i][Fields[k]], search_Field_Array[k])) {
                        Fields[k] = i;
                        break;
                }
            }
        }
        int flag1=0;
        for (int i = 0; i < n-1; i++) {
            if (!Objects.equals(Fields[i], Fields[i + 1])){
                System.out.println("NOT FOUND");
                break;
            }
            else {
                flag1++;
            }
        }
        if (flag1==(n-1)){
            for (int i = 0; i < 7; i++) {
                System.out.print(FlightTable[Fields[0]][i]+"  ");
            }
        }
        else {
            System.out.println("NOT FOUND");
        }
        for (int i = 0; i < n; i++) {
            Fields[i]=7;
            search_Field_Array[i]="_";
        }

    }

    public void BookTickets(Flights[] flights,Admin admin){
        System.out.println("Enter your Flight_Id:");
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
        System.out.println("Enter your Flight_Id:");
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
        System.out.println("Enter the amount of money you wanna add to your charge:");
        int addition=input.nextInt();
        admin.setCharge(admin.getCharge()+addition);
    }


}
