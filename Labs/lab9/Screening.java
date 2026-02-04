import java.util.ArrayList;

public class Screening {
    
    private Movie movie ;
    private Auditorium auditorium ;
    private int startTime ;
    private int[][] seats ;
    private ArrayList<Seat> seatsList  ;
    private ArrayList<Seat> soldSeatsList ;
    

    private ArrayList<Ticket> soldTickets ;
    public Screening() { // YA BU CONSTRUCTORI TANIMLAYIP İÇİNE BİR ŞEY YAZMAYINCA BİR ŞEY OLMUYOR
        // SOLD TİCEKTS KULLANMADIM TABİ
        soldTickets = new ArrayList<>() ;
        seats = new int[100][100] ;
        seatsList = new ArrayList<>() ;
        soldSeatsList = new ArrayList<>() ;
        // for ( int i = 1 ; i <= this.getAuditorium().getNumberOfRows() ; i++) {

        //     for (int a = 1 ; a<= this.getAuditorium().getNumberOfColumns() ; a++ ) {
                
        //             Seat x = new Seat(i, a) ;
        //             seatsList.add(x) ;
                                
        //     }
        // }
    }
    
    public void setSoldSeatsList(Seat seat) {
        soldSeatsList.add(seat);
    }

    public ArrayList<Seat> getSoldSeatsList() {
        return soldSeatsList;
    }

    public Screening(Movie movie , Auditorium auditorium , int startTime ) { // AMA BUNU YAZIP HEPSİNE DEFAULT
        // DEĞERLERİ YAZIYORUM SIKINTI OLUYOR NEDEN
        soldTickets = new ArrayList<>() ;
        this.movie = movie ;
        this.auditorium = auditorium ;
        this.startTime = startTime ;
        seats = new int[auditorium.getNumberOfRows()][auditorium.getNumberOfColumns()] ;
        seatsList = new ArrayList<>() ;
        soldSeatsList = new ArrayList<>() ;
        // for ( int i = 1 ; i <= this.getAuditorium().getNumberOfRows() ; i++) {

        //     for (int a = 1 ; a<= this.getAuditorium().getNumberOfColumns() ; a++ ) {
                
        //             Seat x = new Seat(i, a) ;
        //             seatsList.add(x) ;
                                
        //     }
        // }
    }

    public Movie getMovie() {
        return movie;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public int getStartTime() {
        return startTime;
    }

    public int[] getSeats(int rowNumber) {
        return seats[rowNumber];
    }

    public ArrayList<Ticket> getSoldTickets() {
        return soldTickets;
    }

    public int getEndTime() {
        return startTime + movie.getDuration();
    } 

    public double getPrice() {
        return movie.getBaseTicketPrice() * auditorium.getPriceMultiplier() ; // parantez var mı bak SONDA METHODDA
    }

    public Seat getSeat(int row , int column) {
        if (row <= auditorium.getNumberOfRows() && row > 0 && column <= auditorium.getNumberOfColumns() && column >0) {
            
            for (int k = 0 ; k < seatsList.size() ; k++ ) {
                if (seatsList.get(k).getRow() == row && seatsList.get(k).getColumn() == column ) {
                    return seatsList.get(k) ;
                }
            }
            /* for (Seat seat : seatsList) {
                if (seat.getRow() == row && seat.getColumn() == column ) { // BÖYLE OLUNCA KOPYASINI YAPIP YENİ SEAT
                // KOPYASINDAN DOLAYI BOŞ GÖRÜNÜYOR OLMA İHTİMALİ FALAN NEDİR??
                    return seat ;
                }
            } */
        }
        return null ;
    }

    public void setSeatAvailability(Seat seat, boolean bool) {
        for (Seat seat1 : seatsList ) {
            if (seat.getRow() == seat1.getRow() && seat.getColumn() == seat1.getColumn() ) {
                seat.setBookingStatus(bool);
            }
        }
    }

    public boolean isSeatAvailable(int row, int column) {
        if (getSeat(row, column) != null ) {

            for (Ticket ticket : soldTickets ) {

                for (Seat seat : ticket.getBookedSeats()) {

                    if (seat.getRow() == row && seat.getColumn() == column && !seat.isBookingStatus()) {
                        return false ;
                    }
                }
            }
        }
        else {
            return false ;
        }

        return true ;

        // for (Seat seat : seatsList ) {

        //     if (seat.getRow() == row && seat.getColumn() == column ) {
        //         return seat.isBookingStatus() ;
        //     }
        // }
        // return false ;










        // Seat seat = new Seat(row, column) ; // BU DOĞRU DEĞİL SEN YENİ SEAT TANIMLIYORSUN
        // VE O SEAT NEREYE AİT HANGİ SCREENİNGE AİT BELLİ DEĞİL VE ZATEN SEAT OBJECT TANIMLADIĞINDA
        // BOOKİNG STATUS TRUE OLACAK ŞEKİLDE YAPTIK BU HER ZAMAN TRUE VERİR
        // if (seat.isBookingStatus()) {
        //     return true ;
        // }
        // else {
        //     return false ;
        // }

    }



    public Ticket buyTicket(Seat... seats ) { // ÖNEMLİ KULLANIM seat VARİABLE INI array OLARAK / arraylist değil
        Ticket ticket = new Ticket() ;
        double totalPrice  = 0 ;
        for (Seat seat : seats) {
            if (seat.isBookingStatus() && seat.getRow() <= auditorium.getNumberOfRows() && seat.getRow() > 0 && seat.getColumn() <= auditorium.getNumberOfColumns() && seat.getColumn() >0) {
                ticket.setAddBookedSeats(seat) ;
                totalPrice += getPrice() ;
            }
            else {
                return null ;
            }
            }
            Ticket returnedTicket = new Ticket(this, ticket.getBookedSeats(), totalPrice) ; // GÜZEL YAZDIK BURAYI
        return returnedTicket ; 
    }

    public Ticket buyTicketForRange(int row, int startColumn, int endColumn ) {
        Ticket ticket = new Ticket() ;
        double totalPrice  = 0 ;
        for (int i = startColumn ; i <= endColumn ; i++ ) {
            Seat seat = new Seat(row, endColumn) ;
             Ticket returnedTicket = new Ticket() ;
            if ( returnedTicket  != null ) {
                returnedTicket= null ;
                //                returnedTicket.setRemoveBookedSeats(seat) ;

                ticket.setAddBookedSeats(seat) ; // BOOKED SEATSİ BOŞ CONSTRUCTORIN İÇİNE YAZMADIM VE TİCKET 
                //OLUŞTURURKEN BOŞ CONSTRUCTORI ÇAĞIRDIM BAK VE SONUÇ OLARAK BOOKEDSEATS ARRAYLİSTİ NULL OLUŞTU
                // NULL İLE BOŞ ARASINDAKİ FARKI İYİ ANLA NULL DEMEK YOK DEMEK BOŞ DEMEK DEĞİL
                // O NEDENLE ZATEN OLMAYAN BİR ARRAYLİSTE ADAM YENİ BİR OBJE EKLEYEMEM DİYOR TİCKET SINIFI 
                // SONRAKİ FOTODA VE BURDA ÖNEMLİ OLA BEN SADECE ARRAYLİS BOOKEDSEATS DEMİŞİM YANİ = NEW ARRAYLİST
                //HİÇBİR YERDE YAZMADIM O YÜZDEN NULL OLUŞMUŞ AMA STRİNGİ MESELA BOŞ OLUŞTURUYOR YANİ ANLAYAACAĞIN
                //SENİN TÜM VARİABLELARIN CONSTRUCTORLARININ İÇİNDE OLMALI SIKINTI ÇIKMAMASI İÇİN AMA
                //MESELA HİÇ CONSTRUCTOR KOYMAYIP STRİNG VE İNT TANIMLARSAN VE ONLARI SADECE CONSTRUCTOR
                // DIŞINA PRİVATE İNT X VEE PRİVATE STRİNG Y DİYE YAZARSAN ONLAR DA MI NULL OLUYOR
                // YOKSA ONLAR DEFAULT DEĞERE Mİ ATANIYOR ///////// SÖZÜN ÖZÜ SEN HER ZAMAN
                // HER ZAAAMAAAN HER CONSTRUCTORIN İÇİNDE ONLARI TANIMLA
                // this.getSeat(row, i).setBookingStatus(false);
                ArrayList<Seat> abc = new ArrayList<>() ;
                abc.add( this.getSeat(row, i)) ;
                Ticket xy = new Ticket(this, abc, 1) ;
                // this.setAddSoldTickets(xy);
                this.setSoldSeatsList(this.getSeat(row, i)) ;




                totalPrice += getPrice() ;

            }
            else {
                return null ;
            }

        }
        MovieTicketSystem.revenue += totalPrice ;
        Ticket returnedTicket = new Ticket(this, ticket.getBookedSeats(), totalPrice) ; // GÜZEL YAZDIK BURAYI
        return returnedTicket ;
    }

    public String getStringLayout() { // printfde neresi boşluk oluyor NEGATİF VE POZİTİFTE
        String output = " " ;
        for (int a = 1 ; a <= getAuditorium().getNumberOfColumns() ; a++ ) {
            output += a ;
        }
        output += "\n" ;
        for (int x = 1 ; x <= getAuditorium().getNumberOfRows() ; x ++) {

            output += x ;
            for (int y = 1 ; y <= getAuditorium().getNumberOfColumns() ; y++ ) {
                if (/*getSeat(y, x).isBookingStatus()*/ isSeatAvailable(x, y)) {getSeat(x, y) ;
                    output += "_" ;
                }
                else {
                    output += "#" ;
                }
            }
            output += "\n" ;
        }
        return output ;
    }



    public String toString() {
        return "movie title: " + getMovie().getTitle() + "auditorium name: " +getAuditorium().getAuditoriumName() + "start time: " + getStartTime() + "end time: " + getEndTime() ;
    }

    public boolean equals(Screening screening) { // COMPARE TWO SCREENİNG OBJECTS DİYOR VE OVERRİDE DEMİYOR
        // O NEDENLE BÖYLE YAPTIM

        return (this.getMovie().equals(screening.getMovie())) && (this.getAuditorium().equals(screening.getAuditorium()) )
        && (this.getStartTime() == screening.getStartTime() ) ;
        
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setAddSoldTickets(Ticket ticket) {
        soldTickets.add(ticket) ;
        for (int i = 0 ; i < ticket.getBookedSeats().size() ;  i++  ) {

            ticket.getBookedSeats().get(i).setBookingStatus(false);
            
        }
    }

    public void setSeatsList(ArrayList<Seat> seatsList) {
        this.seatsList = seatsList;
    }

    public ArrayList<Seat> getSeatsList() {
        return seatsList;
    }

    // public void setSeatsList( ArrayList<Seat> seatsList) {

    //     for (int k= 0 ; k < auditorium.getNumberOfRows() ; k++ ) {


    //         for (int c = 0 ; c < auditorium.getNumberOfColumns() ; c++ ) {

    //             seatsList.add(getSeat(k, c)) ;
    //         }
    //     }
        
    // }

    

        // public void sett() {
        //     ArrayList<Seat> list = new ArrayList<>() ;
        //     for ( int i = 1 ; i <= auditorium.getNumberOfRows() ; i++) {
    
        //         for (int a = 1 ; a<= auditorium.getNumberOfColumns() ; a++ ) {
        //             Seat seat = new Seat(i, a) ;
        //             list.add(seat) ;
        //             this.setSeatsList(list);
        //         }
        //     }
        // }

}


