import java.util.Objects;
import java.util.Scanner;

public class searchTest {
    Scanner input=new Scanner(System.in);
    public String search(int command,int index,Flights[] flights){
        String returnField;
        switch (command) {
            case 0:
                returnField = flights[index].getFlightId();
                break;
            case 1:
                returnField = flights[index].getOrigin();
                break;
            case 2:
                returnField = flights[index].getDestination();
                break;
            case 3:
                returnField = flights[index].getDate();
                break;
            case 4:
                returnField = flights[index].getTime();
                break;
            case 5:
                returnField = flights[index].getStringPrice();
                break;
            case 6:
                returnField = flights[index].getSeat();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
        return returnField;
    }
    public void Find(Flights[] flights){
        System.out.println("please enter the number of fields you wanna search:");
        int N=input.nextInt();
        int[] command=new int[N];
        System.out.println("according to your search fields, enter one of this fallowing numbers:");
        System.out.println("0 for Flight_id");
        System.out.println("1 for origin");
        System.out.println("2 for Destination");
        System.out.println("3 for date");
        System.out.println("4 for Time");
        System.out.println("5 for price");
        System.out.println("6 for seats");
        for (int i = 0; i < N; i++) {
            command[i]=input.nextInt();
        }
        String[] Field=new String[N];
        System.out.println("Enter your phrase:");
        for (int i = 0; i < N; i++) {
            Field[i]=input.next();
        }
        for (int i = 0; i < 10; i++) {
            int flag = 0;
            for (int j = 0; j < N; j++) {
                if (Objects.equals(search(command[j], i, flights), Field[j])) {
                    flag++;
                }
                if (flag == N) {
                    System.out.println(flights[i].getFlightId() + "  ");
                    System.out.print(flights[i].getOrigin() + "   ");
                    System.out.print(flights[i].getDestination() + "  ");
                    System.out.print(flights[i].getDate() + "   ");
                    System.out.print(flights[i].getTime() + "   ");
                    System.out.print(flights[i].getStringPrice() + "   ");
                    System.out.print(flights[i].getSeat());
                }
            }
        }
    }
}
