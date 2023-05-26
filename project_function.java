import java.util.Scanner;

public class project_function {
    Scanner input=new Scanner(System.in);
    public int Show_menu_options() {
        for (int i = 1; i <= 60; i++) {
            System.out.print(":");
        }
        System.out.println();
        for (int i = 1; i <= 11; i++) {
            System.out.print(" ");
        }
        System.out.print("WELCOME TO AIRLINE RESERVATION SYSTEM");
        System.out.println();
        for (int i = 1; i <= 60; i++) {
            System.out.print(":");
        }
        System.out.println();
        for (int i = 1; i <= 24; i++) {
            System.out.print(".");
        }
        System.out.print("MENU OPTIONS");
        for (int i = 1; i <= 24; i++) {
            System.out.print(".");
        }
        System.out.println();
        System.out.println("<1> Sign in");
        System.out.println("<2> Sign up");

        int digit = input.nextInt();
        return digit;
    }
    public void FlightTable(int index,Flights[] flights){
        String[] Flight_table=new String[7];
        Flight_table[0]="FLIGHT_ID";
        Flight_table[1]="ORIGIN";
        Flight_table[2]="DESTINATION";
        Flight_table[3]="DATE";
        Flight_table[4]="TIME";
        Flight_table[5]="PRICE";
        Flight_table[6]="SEATS";
            for(int i = 0; i<7; i++){
                System.out.print(Flight_table[i] + "    ");
            }
        System.out.println();
            for (int i=0;i<=index;i++){
                System.out.println(flights[i].getFlightId()+"        "+flights[i].getOrigin()+"       "+flights[i].getDestination()+"     "+flights[i].getDate()+"    "+flights[i].getTime()+"    "+flights[i].getIntPrice()+"    "+flights[i].getSeats());
            }
        }
    public void setFlights(Flights[] flights){
        flights[0]=new Flights("mo_15","Tehran","Tabriz","15_3_1402","23:30",145000,35);
        flights[1]=new Flights("my_15","Esfahaan","Shiraz","11_3_1402","00:30",120000,30);
        flights[2]=new Flights("xy_15","Gorgan","Yazd","10_3_1401","01:35",285000,55);
    }
}
