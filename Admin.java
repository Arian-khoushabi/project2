public class Admin {
    private int Password;
    private String UserName;

    public Admin(int password, String userName,int charge) {
        Password = password;
        UserName = userName;
    }

    private int Charge;

    private String[] BookedTickets = new String[10];

    private String[] searchTickets = new String[14];

    public String getSearchTickets(int index) {
        return searchTickets[index];
    }

    public void setSearchTickets(String searchTickets,int index) {
        this.searchTickets[index] = searchTickets;
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

    public boolean EnterPassword(int password){
        if (getPassword()==password){
            return true;
        }
        else {
            return false;
        }
    }
}
