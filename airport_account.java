import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Objects;
import java.util.Scanner;

public class airport_account {
    public static void main(String[] args)  {
        String[] admin=new String[2];
        admin[0]="Admin";
        admin[1]="12345";
        Admin[] passengers= new Admin[100];
        for(int i=0;i<100;i++){
            passengers[i]=new Admin(0,"NotSignedYet",0, new String[]{"_","_","_","_","_","_","_","_","_","_"});
        }
        int indexOfPassengers=0;
        int lastIndexOfFlights;
        project_function menu1 = new project_function();
        Admin_menu_option menu2 = new Admin_menu_option();
        passenger_menu_options menu3 = new passenger_menu_options();
        searchTest search=new searchTest();
        Flights[] flights = new Flights[10];
        for(int i=0;i<10;i++){
            flights[i]=new Flights("_","_","_","_","_",0,0);
        }
        Scanner input = new Scanner(System.in);
        menu1.setFlights(flights);
        lastIndexOfFlights=2;
        try {
            RandomAccessFile fFile = new RandomAccessFile("Flight.dat", "rw");
            FlightFile flightFile=new FlightFile(fFile);
            RandomAccessFile pFile = new RandomAccessFile("User.dat", "rw");
            UserFile userFile = new UserFile(pFile);
            for (int i = 0; i <= lastIndexOfFlights; i++) {
                    fFile.seek(i*308L);
                    flightFile.writeFlightsInfoFile(flights[i]);
            }
        while (true) {
            int command0 = menu1.Show_menu_options();
            switch (command0) {
                case 1:
                    System.out.println("PLEASE ENTER YOUR USERNAME");
                    String name = input.next();
                    System.out.println("PLEASE ENTER YOUR PASSWORD");
                    int pass = input.nextInt();
                    if (String.valueOf(pass).equals(admin[1]) && Objects.equals(name, admin[0])) {
                        int command1 = menu2.Show_Admin_menu();
                        while (command1 != 0) {
                            switch (command1) {
                                case 1:
                                    lastIndexOfFlights++;
                                    flights[lastIndexOfFlights]=menu2.ADD_update(flights,lastIndexOfFlights);
                                    try {
                                            fFile.seek(lastIndexOfFlights* 308L);
                                            flightFile.writeFlightsInfoFile(flights[lastIndexOfFlights]);
                                        }
                                        catch (IOException e){
                                            e.printStackTrace();
                                        }
                                        command1 = menu2.Show_Admin_menu();
                                    break;
                                case 2:
                                    System.out.println("please enter your FlightId:");
                                    String flightID = input.next();
                                    int flag = 0;
                                    for (int i = 0; i <= lastIndexOfFlights; i++) {
                                        if (Objects.equals(flightID, flights[i].getFlightId())) {
                                            flights[i]=menu2.ADD_update(flights, i);
                                            try {
                                                fFile.seek(i*308);
                                                flightFile.writeFlightsInfoFile(flights[i]);
                                            }
                                            catch (IOException e){
                                                e.printStackTrace();
                                            }
                                            flag++;
                                            break;
                                        }
                                    }
                                    if (flag == 0) {
                                        System.err.println("FLIGHT_ID COULD NOT FOUND");
                                    }
                                    command1 = menu2.Show_Admin_menu();
                                    break;
                                case 3:
                                    System.out.println("please enter your FlightId:");
                                    flightID = input.next();
                                    flag = 0;
                                    for (int i = 0; i <= lastIndexOfFlights; i++) {
                                        if (Objects.equals(flightID, flights[i].getFlightId())) {
                                            menu2.Remove(flights, i, passengers);
                                            try {
                                                fFile.seek(lastIndexOfFlights*308L);
                                                for (int j = 0; j < 308; j++) {
                                                    fFile.writeChars(" ");
                                                }
                                                for (int j = 0; j <=lastIndexOfFlights-1; j++) {
                                                    fFile.seek(j* 308L);
                                                    flightFile.writeFlightsInfoFile(flights[j]);
                                                }
                                                for (int j = 0; j < indexOfPassengers; j++) {
                                                    pFile.seek(j* 668L);
                                                    userFile.writeUserFile(passengers[i]);
                                                }
                                            }
                                            catch (IOException e){
                                                e.printStackTrace();
                                            }
                                            lastIndexOfFlights--;
                                            flag++;
                                            break;
                                        }
                                    }
                                    if (flag == 0) {
                                        System.err.println("FLIGHT_ID COULD NOT FOUND");
                                    }
                                    command1 = menu2.Show_Admin_menu();
                                    break;

                                case 4:
                                    menu1.FlightTable(lastIndexOfFlights,flights);
                                    command1 = menu2.Show_Admin_menu();
                                    break;
                            }
                        }
                        break;
                    }
                    for (int i = 0; i < indexOfPassengers; i++) {
                        int validation=0;
                        pFile.seek(i* 668L);
                        if (Objects.equals(pFile.readInt(),pass)){
                            validation++;
                        }
                        String readName="";
                        pFile.seek((i* 668L)+4);
                        for (int j=0;j<30;j++){
                            readName+=pFile.readChar();
                        }
                        if (readName.trim().equals(name)){
                            validation++;
                        }
                        if (validation==2){
                            System.out.println("WELCOME " + passengers[i].getUserName());
                            int command2 = menu3.Show_passenger_menu();
                            while (command2 != 0) {
                                switch (command2) {
                                    case 1:
                                        System.out.println("please enter your new password");
                                        int password = input.nextInt();
                                        passengers[i].setPassword(password);
                                        try {
                                                pFile.seek(i*668);
                                                userFile.writeUserFile(passengers[i]);
                                        }
                                        catch (IOException e){
                                            e.printStackTrace();
                                        }
                                        command2 = menu3.Show_passenger_menu();
                                        break;
                                    case 2:
                                        search.Find(flights);
                                        System.out.println();
                                        command2 = menu3.Show_passenger_menu();
                                        break;
                                    case 3:
                                        menu3.BookTickets(flights, passengers[i],lastIndexOfFlights);
                                        try {
                                            pFile.seek(i*668);
                                            userFile.writeUserFile(passengers[i]);
                                        }
                                        catch (IOException e){
                                            e.printStackTrace();
                                        }
                                        command2 = menu3.Show_passenger_menu();
                                        break;
                                    case 4:
                                        menu3.CancelTickets(flights, passengers[i]);
                                        try {
                                            pFile.seek(i*668);
                                            userFile.writeUserFile(passengers[i]);
                                        }
                                        catch (IOException e){
                                            e.printStackTrace();
                                        }
                                        command2 = menu3.Show_passenger_menu();
                                        break;
                                    case 5:
                                        menu3.ShowMyTickets(passengers[i], flights);
                                        command2 = menu3.Show_passenger_menu();
                                        break;
                                    case 6:
                                        menu3.AddCharge(passengers[i]);
                                        try {
                                            pFile.seek(i*668);
                                            userFile.writeUserFile(passengers[i]);
                                        }
                                        catch (IOException e){
                                            e.printStackTrace();
                                        }
                                        command2 = menu3.Show_passenger_menu();
                                        break;
                                }
                            }
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter your user_name:");
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
                    passengers[indexOfPassengers].setCharge(0);
                    for (int i = 0; i < 10; i++) {
                        passengers[indexOfPassengers].setBookedTickets("_", i);
                    }
                    try {
                        pFile.seek(indexOfPassengers*668);
                        userFile.writeUserFile(passengers[indexOfPassengers]);
                        }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                    indexOfPassengers++;
                    break;
                    }
                }
        }
        catch (IOException e){
            e.printStackTrace();
        }
            }
        }
