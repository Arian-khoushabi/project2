import java.util.Scanner;

public class project_function {
    Scanner input=new Scanner(System.in);
    Flights flights = new Flights();
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
    public void FlightTable(String Flight_table[][]){
        Flight_table[0][0]="FLIGHT_ID";
        Flight_table[0][1]="ORIGIN";
        Flight_table[0][2]="DESTINATION";
        Flight_table[0][3]="DATE";
        Flight_table[0][4]="TIME";
        Flight_table[0][5]="PRICE";
        Flight_table[0][6]="SEATS";
        for(int i = 0; i<11; i++){
            for(int j = 0; j<7; j++){
                System.out.print(Flight_table[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void setFlight(String Flight_table[][],Flights[] flights,int i){
        Flight_table[i][0]= flights[i].getFlightId();
        Flight_table[i][1]= flights[i].getOrigin();
        Flight_table[i][2]= flights[i].getDestination();
        Flight_table[i][3]= flights[i].getDate();
        Flight_table[i][4]= flights[i].getTime();
        Flight_table[i][5]= flights[i].getStringPrice();
        Flight_table[i][6]= flights[i].getSeat();
    }
    public void setFlights1(String Flight_table[][],Flights flights[]){
        Flight_table[1][0]="mo_15";
        Flight_table[1][1]= "Tehran";
        Flight_table[1][2]= "Tabriz";
        Flight_table[1][3]= "05_02_1402";
        Flight_table[1][4]= "21:30";
        Flight_table[1][5]= "145000";
        Flight_table[1][6]= "55";
        Flight_table[2][0]="my_15";
        Flight_table[2][1]= "Tehran";
        Flight_table[2][2]= "Yazd";
        Flight_table[2][3]= "27_02_1402";
        Flight_table[2][4]= "23:10";
        Flight_table[2][5]= "187000";
        Flight_table[2][6]= "85";
        Flight_table[3][0]="xy_15";
        Flight_table[3][1]= "Tehran";
        Flight_table[3][2]= "Mashhad";
        Flight_table[3][3]= "31_01_1402";
        Flight_table[3][4]= "17:45";
        Flight_table[3][5]= "150000";
        Flight_table[3][6]= "65";
        flights[0].setFlightId("mo_15");
        flights[0].setOrigin("Tehran");
        flights[0].setDestination("Tabriz");
        flights[0].setDate("05_02_1402");
        flights[0].setTime("21:30");
        flights[0].setPrice(145000);
        flights[0].setSeats(55);
        flights[0].setSeat();
        flights[1].setFlightId("my_15");
        flights[1].setOrigin("Tehran");
        flights[1].setDestination("Yazd");
        flights[1].setDate("27_02_1402");
        flights[1].setTime("23:10");
        flights[1].setPrice(187000);
        flights[1].setSeats(85);
        flights[1].setSeat();
        flights[2].setFlightId("xy_15");
        flights[2].setOrigin("Tehran");
        flights[2].setDestination("Mashhad");
        flights[2].setDate("05_02_1402");
        flights[2].setTime("17:45");
        flights[2].setPrice(150000);
        flights[2].setSeats(65);
        flights[2].setSeat();
    }
}
