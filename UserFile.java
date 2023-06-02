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
            if (!Objects.equals(passenger.getBookedTickets(i), "_")) {
                rFile.writeChars(FixToWrite(passenger.getBookedTickets(i)));
            }
            else {
                for (int j = 0; j < 668; j++) {
                    rFile.writeChars(" ");
                }
            }
        }
    }
    private String FixToWrite(String str){
        StringBuilder strBuilder = new StringBuilder(str);
        while (strBuilder.length()<FIX_SIZE){
            strBuilder.append(" ");
        }
        str = strBuilder.toString();
        return str.substring(0,FIX_SIZE);
    }
}
