import java.util.Objects;
import java.util.Scanner;

public class searchTest {
    Scanner input=new Scanner(System.in);
    public String search(int command,int index,Flights[] flights,int[] range){
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
                range[1]=flights[index].getIntPrice();
                if (range[1]<=range[2] && range[0]<=range[1]) {
                    returnField = "FINE";
                }
                else {
                    returnField="dont care";
                }
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
        int[] range=new int[3];
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
        for (int i = 0; i < N; i++) {
            if(command[i]==5){
                System.out.println("one of your commands was price, so please do the fallowing orders:");
                System.out.println("your low rage is:");
                range[0]=input.nextInt();
                System.out.println("your high rage is:");
                range[2]=input.nextInt();
            }
        }
        String[] Field=new String[N];
        System.out.println("Enter your phrase:");
        for (int i = 0; i < N; i++) {
            Field[i]=input.next();
        }
        for (int i = 0; i < 10; i++) {
            int flag = 0;
            for (int j = 0; j < N; j++) {
                if (command[j] == 5) {
                    Field[j]=search(5,i,flights,range);
                    if (!Objects.equals(Field[j], "FINE")){
                        break;
                    }
                }
                if (Objects.equals(search(command[j], i, flights,range), Field[j])) {
                    flag++;
                }
            }
            if (flag == N) {
                System.out.print(flights[i].getFlightId() + "  ");
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
