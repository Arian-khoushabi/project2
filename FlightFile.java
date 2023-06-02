import java.io.IOException;
import java.io.RandomAccessFile;

public class FlightFile {
    private RandomAccessFile rFile;
    private final int FIX_SIZE=30;

    public FlightFile(RandomAccessFile rFile) {
        this.rFile = rFile;
    }

    private String FixToWrite(String str){
        while (str.length()<FIX_SIZE){
            str+=" ";
        }
        return str.substring(0,FIX_SIZE);
    }
    public void writeFlightsInfoFile(Flights flights)throws IOException{
        rFile.writeChars(FixToWrite(flights.getFlightId()));
        rFile.writeChars(FixToWrite(flights.getOrigin()));
        rFile.writeChars(FixToWrite(flights.getDestination()));
        rFile.writeChars(FixToWrite(flights.getDate()));
        rFile.writeChars(FixToWrite(flights.getTime()));
        rFile.writeInt(flights.getIntPrice());
        rFile.writeInt(flights.getSeats());
    }
}
