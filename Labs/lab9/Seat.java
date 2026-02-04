public class Seat {
    

    private int row ;
    private int column ;
    private boolean bookingStatus ; // gives true if empty

    public Seat(int row , int column) {
        this.row = row ;
        this.column = column ;
        bookingStatus = true ;
    }
    public Seat(int row , int column, boolean bookingStatus) {
        this.row = row ;
        this.column = column ;
        this.bookingStatus = bookingStatus ;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(boolean bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String toString() {
        return "(" + row + "," + column + ")" ;
    }

    public boolean equals(Seat seat ) {
        if (seat.getRow() == getRow() && seat.getColumn() == getColumn() ) {
            return true ;
        }
        return false ;
    }

    public boolean equals(Object obj ) {
        if (obj == null) {
            return false ;
        }

        if (obj.getClass() != getClass()) {
            return false ;
        }

        Seat other = (Seat) obj ;

        if (other.getRow() == getRow() && other.getColumn() == getColumn() ) {
            return true ;
        }
        return false ;
    }

    
}
