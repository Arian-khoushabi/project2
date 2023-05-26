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
    private String FixToRead()throws IOException {
        String tmp=" ";
        for (int i = 0; i < FIX_SIZE; i++) {
            tmp+=rFile.readChar();
        }
        return tmp.trim();
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
    public Flights readFlightsInfoFile(Flights flights)throws IOException{
        flights.setFlightId(FixToRead());
        flights.setOrigin(FixToRead());
        flights.setDestination(FixToRead());
        flights.setDate(FixToRead());
        flights.setTime(FixToRead());
        flights.setPrice(rFile.readInt());
        flights.setSeats(rFile.readInt());
        return new Flights(flights.getFlightId(),flights.getOrigin(),flights.getDestination(),flights.getDate(),flights.getTime(),flights.getIntPrice(),flights.getSeats());
    }
}
