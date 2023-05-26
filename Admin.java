public class Admin {
    private int Password;
    private String UserName;
    private int Charge;

    public Admin(int password, String userName, int charge, String[] bookedTickets) {
        Password = password;
        UserName = userName;
        Charge = charge;
        BookedTickets = bookedTickets;
    }

    private String[] BookedTickets;
    public int getPassword() {
        return Password;
    }

    public void setPassword(int password) {
        Password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getCharge() {
        return Charge;
    }
    public void setCharge(int charge) {
        Charge = charge;
    }
    public String getBookedTickets(int index) {
        return BookedTickets[index];
    }
    public void setBookedTickets(String bookedTickets,int index) {
        BookedTickets[index] = bookedTickets;
    }
    public String[] getAllBookedTickets(){
        return BookedTickets;
    }
}
