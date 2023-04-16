import java.util.Objects;
import java.util.Scanner;

public class airport_account {
    public static void main(String[] args) {
        String[] admin=new String[2];
        admin[0]="Admin";
        admin[1]="12345";
        Admin[] passengers= new Admin[100];
        for(int i=0;i<100;i++){
            passengers[i]=new Admin();
        }
        int indexOfPassengers=0;
        project_function menu1 = new project_function();
        Admin_menu_option menu2 = new Admin_menu_option();
        passenger_menu_options menu3 = new passenger_menu_options();
        searchTest search=new searchTest();
        Flights[] flights = new Flights[10];
        for(int i=0;i<10;i++){
            flights[i]=new Flights();
        }
        Scanner input = new Scanner(System.in);
        String[][] Flight_table = new String[11][7];
        for(int i = 1;i<11;i++) {
            for (int j = 0; j < 7; j++) {
                Flight_table[i][j] = "_";
            }
        }
        menu1.setFlights1(Flight_table,flights);
        while (true) {
            int command0 = menu1.Show_menu_options();
            switch (command0) {
                case 1:
                    System.out.println("PLEASE ENTER YOUR USERNAME");
                    String name = input.next();
                    System.out.println("PLEASE ENTER YOUR PASSWORD");
                    int pass = input.nextInt();
                    if (String.valueOf(pass).equals(admin[1]) && Objects.equals(name,admin[0])) {
                        int command1 = menu2.Show_Admin_menu();
                        while (command1 != 0) {
                            switch (command1) {
                                case 1:
                                    int row_number = input.nextInt();
                                    if (row_number == 0) {
                                        break;
                                    }
                                    while (!Objects.equals(Flight_table[row_number][0], "_") && (row_number != 0)) {
                                        System.err.println("THIS ROW IS ALREADY FULL, PLEASE INPUT AGAIN");
                                        System.out.println("PRESS '0' TO RETURN TO MENU OR INPUT ANOTHER NUMBER");
                                        row_number = input.nextInt();
                                    }
                                    if (row_number == 0) {
                                        command1 = menu2.Show_Admin_menu();
                                        break;
                                    } else {
                                        menu2.ADD_update(flights, row_number);
                                        menu1.setFlight(Flight_table, flights, row_number);
                                        command1 = menu2.Show_Admin_menu();
                                    }
                                    break;
                                case 2:
                                    String flightID = input.next();
                                    int flag = 0;
                                    for (int i = 0; i < 10; i++) {
                                        if (Objects.equals(flightID, flights[i].getFlightId())) {
                                            menu2.ADD_update(flights, i);
                                            menu1.setFlight(Flight_table, flights, i);
                                            flag++;
                                        }
                                    }
                                    if (flag == 0) {
                                        System.err.println("FLIGHT_ID COULD NOT FOUND");
                                    }
                                    command1 = menu2.Show_Admin_menu();
                                    break;
                                case 3:
                                    row_number = input.nextInt();
                                    menu2.Remove(flights, row_number,passengers);
                                    menu1.setFlight(Flight_table, flights, row_number);
                                    command1 = menu2.Show_Admin_menu();
                                    break;

                                case 4:
                                    menu1.FlightTable(Flight_table);
                                    command1 = menu2.Show_Admin_menu();
                                    break;
                            }
                        }
                        break;
                    }
                    for (int i = 0; i < 100; i++) {
                        if (Objects.equals(passengers[i].getPassword(), pass) && Objects.equals(passengers[i].getUserName(), name)) {
                            System.out.println("WELCOME "+ passengers[i].getUserName());
                            int command2 = menu3.Show_passenger_menu();
                            while (command2 != 0) {
                                switch (command2) {
                                    case 1:
                                        int password=input.nextInt();
                                        passengers[i].setPassword(password);
                                        command2 = menu3.Show_passenger_menu();
                                        break;
                                    case 2:
                                        search.Find(flights);
                                        System.out.println();
                                        command2 = menu3.Show_passenger_menu();
                                        break;
                                    case 3:
                                        menu3.BookTickets(flights, passengers[i]);
                                        command2 = menu3.Show_passenger_menu();
                                        break;
                                    case 4:
                                        menu3.CancelTickets(flights, passengers[i]);
                                        command2 = menu3.Show_passenger_menu();
                                        break;
                                    case 5:
                                        menu3.ShowMyTickets(passengers[i], flights);
                                        command2 = menu3.Show_passenger_menu();
                                        break;
                                    case 6:
                                        menu3.AddCharge(passengers[i]);
                                        command2 = menu3.Show_passenger_menu();
                                        break;
                                }
                            }
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("enter your user_name:");
                    String userName = input.next();
                    for (int i = 0; i < 100; i++) {
                        while (Objects.equals(userName, passengers[i].getUserName())) {
                            System.err.println("THIS USERNAME IS ALREADY TAKEN, PLEASE CHOICE ANOTHER NAME:");
                            userName = input.next();
                        }
                    }
                    System.out.println("Enter your password:");
                    int Password = input.nextInt();
                    passengers[indexOfPassengers].setUserName(userName);
                    passengers[indexOfPassengers].setPassword(Password);
                    for (int i = 0; i < 10; i++) {
                        passengers[0].setBookedTickets("_",i);
                    }
                    indexOfPassengers++;
                    break;
                }
            }
        }
    }
