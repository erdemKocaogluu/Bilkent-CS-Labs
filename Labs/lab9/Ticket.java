import java.util.ArrayList;

public class Ticket {
    
    private Screening screening ;
    private ArrayList<Seat> bookedSeats ;
    private double totalPrice ;

    public Ticket() { // HER TÜRLÜ O () PARANTEZLE SÜSLÜ PARANTEZİ KOY
        bookedSeats = new ArrayList<>() ; // bunu koyunca tüm sorunlar düzeldi yani aslında tahminimce int stringde
        // falan sorun çıkmaz ama arraylist falan uzun tanımlama lazım yani new arraylist falan yazman gerekiyor
        // her türlü
    }

    public Ticket(Screening screening, ArrayList<Seat> bookedSeats, double totalPrice ) {
        this.screening = screening ;
        this.bookedSeats = bookedSeats ;
        this.totalPrice = totalPrice ;

    }

    public Screening getScreening() {
        return screening;
    }

    public ArrayList<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public double getTotalPrice() { // DİREKT BOOKED SEATS DENEMEZ GETTER METOD KULLANMALI
        return totalPrice;
    }

    



    public String toString() {
        return "movie: " + getScreening().getMovie() + "\nAuditorium: " + getScreening().getAuditorium() 
        + "\n start time: " + getScreening().getStartTime() + "\nbooked seats: " + getBookedSeats() + "\ntotal price: " + getTotalPrice() ;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public void setAddBookedSeats(Seat seat) {
        bookedSeats.add(seat) ;
        seat.setBookingStatus(false);
        // screening.isSeatAvailable(seat.getRow(), seat.getColumn());
    }

    public void setRemoveBookedSeats(Seat seat) {
        bookedSeats.remove(seat) ;
        seat.setBookingStatus(true);
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
}
