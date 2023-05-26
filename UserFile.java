import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Objects;

public class UserFile {
    private RandomAccessFile rFile;
    private final int FIX_SIZE=30;
    public UserFile(RandomAccessFile rFile) {
        this.rFile = rFile;
    }
    public void writeUserFile(Admin passenger)throws IOException {
        rFile.writeInt(passenger.getPassword());
        rFile.writeChars(FixToWrite(passenger.getUserName()));
        rFile.writeInt(passenger.getCharge());
        for (int i = 0; i <10 ; i++) {
            rFile.writeChars(FixToWrite(passenger.getBookedTickets(i)));
        }
    }
    public Admin readUserFile(Admin passenger)throws IOException{
        passenger.setPassword(rFile.readInt());
        passenger.setUserName(FixToRead());
        passenger.setCharge(rFile.readInt());
        for (int i = 0; i < 10; i++) {
            if (!Objects.equals(passenger.getBookedTickets(i), "_"))
                 passenger.setBookedTickets(FixToRead(),i);
        }
        return new Admin(passenger.getPassword(),passenger.getUserName(),passenger.getCharge(),passenger.getAllBookedTickets());
    }
    private String FixToWrite(String str){
        StringBuilder strBuilder = new StringBuilder(str);
        while (strBuilder.length()<FIX_SIZE){
            strBuilder.append(" ");
        }
        str = strBuilder.toString();
        return str.substring(0,FIX_SIZE);
    }
    private String FixToRead()throws IOException{
        StringBuilder tmp= new StringBuilder();
        for (int i = 0; i < FIX_SIZE; i++) {
            tmp.append(rFile.readChar());
        }
        return tmp.toString().trim();
    }
}
