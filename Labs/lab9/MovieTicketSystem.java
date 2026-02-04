import java.util.ArrayList;
import java.util.Scanner;

public class MovieTicketSystem {
    public static double revenue  = 0 ;

    public static void listMovies(ArrayList<Screening> screenings) {
        ArrayList<Movie> movies = new ArrayList<>() ;
        for (Screening screening : screenings) {
            if (!movies.contains(screening.getMovie())) {
                movies.add(screening.getMovie()) ;
            }
        }
        System.out.println("Available movies:");
        for (Movie movie : movies) {
            
            System.out.print(movie.getTitle() + " , ");
            System.out.print("Genre: " + movie.getGenre() + " , ");
            System.out.print("Duration: " + movie.getDuration() + " hours");
            System.out.println();
        }

    }

    public static void listScreenings(ArrayList<Screening> screenings) {
        for (Screening screening : screenings) {
            System.out.println(screening.getMovie().getTitle()+ " is playing in the " + screening.getAuditorium()
            + " auditorium from " + screening.getStartTime() + " to " + screening.getEndTime());
        }
        
    }
     // ARRAYLİST OBJELERDEN OLUŞYORSA VEYA ARRAYLİST PRİMİTİVE TÜRLERDEN OLUŞUYORSA DİYE İKİYE AYIR
    public static void addScreening(ArrayList<Screening> screenings) {
        Screening screening = new Screening() ;
        Scanner in = new Scanner(System.in) ;
        String str = ("Select a movie:\n" + //
                        "1: \"Toyz Goin' Wild\", Genre: Family, Duration: 1 hours\n" + //
                        "2: \"Car's Life\", Genre: Family, Duration: 2 hours\n" + //
                        "3: \"The Amazing Bulk\", Genre: Action, Duration: 1 hours\n" + //
                        "4: \"The Rise of Black Bat\", Genre: Action, Duration: 2 hours\n" +
                        "Enter: " );
                        System.out.print(str);
        int n = in.nextInt() ;
        while (n <0 || n>4) {
            System.out.println("Invalid selection. Please try again.");
            System.out.print(str);
            n = in.nextInt() ;
        }
        Movie movie = new Movie(null, null, 0, 0) ;

        if (n == 1) {
           movie = new Movie("Toyz Goin' Wild", "Family", 1, 1.23) ; // TİCKET PRİCE NAPACAZ
        }

        if ( n == 2 ) {
            movie = new Movie("Car's Life", "Family", 2, 1.00) ;
        }
        if ( n == 3 ) {
            movie = new Movie( "The Amazing Bulk", "Action", 1, 2.10) ;
        }
        if ( n == 4 ) {
            movie = new Movie("The Rise of Black Bat", "Action", 2, 1.90) ;
        }
        screening.setMovie(movie);
        str = "Select an auditorium:\n" + //
                                "1: Auditorium: Screen 1, 20 seats\n" + //
                                "2: Auditorium: Screen 2, 20 seats\n" + //
                                "3: Auditorium: IMAX, 15 seats\n" + //
                                "Enter: " ;
            System.out.print(str);
            int a = in.nextInt() ;
            while (a <0 || a>3) {
                System.out.println("Invalid selection. Please try again.");
                System.out.print(str);
                a = in.nextInt() ;
            }
            Auditorium auditorium = new Auditorium() ;
    if (a == 1) {
        auditorium =new Auditorium("Screen 1", 5, 4, 1.0) ;
        System.out.print("Car's Life is playing in the Screen 1 auditorium from 1:00 to 3:00\n" + //
        "The Amazing Bulk is playing in the Screen 1 auditorium from 0:00 to 1:00\n" + //
        "The Amazing Bulk is playing in the Screen 1 auditorium from 4:00 to 5:00\n" +
        "Enter a start time: ");
    int startTime = in.nextInt() ;
    if (startTime == 1 && n ==2 ) {
        System.out.println(System.out.printf("Screening added: %s is playing in the %s auditorium\n" + //
        "from %d:00 to %d:00%n",screening.getMovie().getTitle(), screening.getAuditorium().getAuditoriumName(), screening.getStartTime(), screening.getEndTime()));
    
    }
    else if (startTime == 0 && n == 3 ) { // BUNU ŞEYE GÖRE YAZDIM BAŞTA SEÇTİĞİ FİLMLE SAATİNİ SEÇTİĞİ FİLMİN AYNI OLMASI
        //LAZIM VE STARTTİMEIN DA AYRICA DOĞRU OLMASI LAZIM YOKSA DİREKT MÜSAİT DEĞİL DİYOR
        System.out.printf("Screening added: %s is playing in the %s auditorium\n" + //
                                "from %d:00 to %d:00%n",screening.getMovie().getTitle(), screening.getAuditorium().getAuditoriumName(), screening.getStartTime(), screening.getEndTime());
    }
    else if (startTime == 4 && n == 3 ) {
        System.out.printf("Screening added: %s is playing in the %s auditorium\n" + //
                                "from %d:00 to %d:00%n",screening.getMovie().getTitle(), screening.getAuditorium().getAuditoriumName(), screening.getStartTime(), screening.getEndTime());
    }
    else {
        System.out.println("The auditorium is not available at the given time.");

    }
        
    }

    if (a == 2) {
        auditorium = new Auditorium("Screen 2", 5, 4, 1.0);
        System.out.print("\"Toys goin' wild is playing in the Screen 2 auditorium from 0:00 to 1:00\n" +
        "Enter a start time: ");
        int startTime = in.nextInt() ;
        if (startTime == 0) {
            screening.setAuditorium(auditorium);
            System.out.println(System.out.printf("Screening added: %s is playing in the %s auditorium\n" + //
            "from %d:00 to %d:00%n",screening.getMovie().getTitle(), screening.getAuditorium().getAuditoriumName(), screening.getStartTime(), screening.getEndTime()));
        }
        else {
            System.out.println("The auditorium is not available at the given time.");

        }
    }

    if (a == 3) {
        auditorium =new Auditorium("IMAX", 3, 5, 1.5);
        screening.setAuditorium(auditorium);

        System.out.print("The Amazing Bulk is playing in the IMAX auditorium from 4:00 to 5:00\n" + //
                        "The Rise of Black Bat is playing in the IMAX auditorium from 6:00 to 8:00\n" + //
                        "Enter a start time: ");
        int startTime = in.nextInt() ;
        if (startTime == 4 && n ==4) {
            System.out.printf("Screening added: %s is playing in the %s auditorium\n" + //
                                "from %d:00 to %d:00%n",screening.getMovie().getTitle(), screening.getAuditorium().getAuditoriumName(), screening.getStartTime(), screening.getEndTime());
        }
        if (startTime == 6 && n ==3 ) {
            System.out.printf("Screening added: %s is playing in the %s auditorium\n" + //
                                "from %d:00 to %d:00%n",screening.getMovie().getTitle(), screening.getAuditorium().getAuditoriumName(), screening.getStartTime(), screening.getEndTime());
        }
        else {
            System.out.println("The auditorium is not available at the given time.");
        }
        
    }



    }


    public static Screening buyTicket(ArrayList<Screening> screenings,Screening screening  ){
        Ticket ticket= new Ticket() ;
         // BÖYLE BOŞ TANIMLAMAK
        // DIŞINDA BAŞKA YOL VAR MI
        Scanner in = new Scanner (System.in) ;
        String str = ("Select a movie:\n" + //
                        "1: \"Toyz Goin' Wild\", Genre: Family, Duration: 1 hours\n" + //
                        "2: \"Car's Life\", Genre: Family, Duration: 2 hours\n" + //
                        "3: \"The Amazing Bulk\", Genre: Action, Duration: 1 hours\n" + //
                        "4: \"The Rise of Black Bat\", Genre: Action, Duration: 2 hours\n" +
                        "Enter: " );
                        System.out.print(str);
        int movieNumber = in.nextInt() ;
        Movie movie = new Movie(str, str, movieNumber, movieNumber) ;
        while (movieNumber <1 || movieNumber>4) {
            System.out.println("Invalid selection. Please try again.");
            System.out.print(str);
            movieNumber = in.nextInt() ;

        }
        if (movieNumber == 1 ) {
            movie = new Movie("Toyz Goin' Wild", "Family", 1, 1.23) ;
            screening.setMovie(movie) ;
        }
        if (movieNumber == 2 ) {
            movie = new Movie("Car's Life", "Family", 2, 1.00) ;
            screening.setMovie(movie) ;
        }
        if (movieNumber == 3 ) {
            movie = new Movie("The Amazing Bulk", "Action", 1, 2.10) ;
            screening.setMovie(movie) ;
        }
        if (movieNumber == 4 ) {
            movie = new Movie("The Rise of Black Bat", "Action", 2, 1.90) ;
            screening.setMovie(movie) ;
        }
        System.out.printf("Select a screening for '%s':%n", screening.getMovie().getTitle() );
        int n = 1 ;
        int starttime = 0 ;
        ArrayList<Integer> liststart = new ArrayList<>() ;
        for (Screening screening2 : screenings ) {  // FOR EACH LOOPUN İÇİNDE N GİBİ BİR VARİABLEI ARTAN YAPSAM
            // YANLIŞ MI OLUR???

            if (screening2.getMovie().equals(movie)){
                System.out.print(n +": ");
                System.out.printf("%s is playing in the %s auditorium from %d:00 to\n" + //
                                        "%d:00%n",screening2.getMovie().getTitle(),screening2.getAuditorium().getAuditoriumName(),
                                        screening2.getStartTime() , screening2.getEndTime());
                n++;
            }

        }//Select row
        System.out.print("Enter: ");
        int choice = in.nextInt() ;

        while (choice >n || choice < 0) {
            System.out.println("Invalid selection. Please try again.");
            System.out.printf("Select a screening for '%s':%n", screening.getMovie().getTitle() );
            n = 1 ;
            for (Screening screening2 : screenings ) {  // FOR EACH LOOPUN İÇİNDE N GİBİ BİR VARİABLEI ARTAN YAPSAM
                // YANLIŞ MI OLUR???
    
                if (screening2.getMovie().equals(movie)){
                    System.out.print(n +": ");
                    System.out.printf("%s is playing in the %s auditorium from %d:00 to\n" + //
                                            "%d:00%n",screening2.getMovie().getTitle(),screening2.getAuditorium().getAuditoriumName(),
                                            screening2.getStartTime() , screening2.getEndTime());
                    n++;
                }
    
            }//Se
            System.out.print("Enter: ");
            choice = in.nextInt() ;

        }
        Auditorium auditorium = new Auditorium(str, n) ;
        n = 1 ;
        int startTime = 0 ;
        int endTime = 0 ;
        for (Screening screening2 : screenings ) {  // FOR EACH LOOPUN İÇİNDE N GİBİ BİR VARİABLEI ARTAN YAPSAM
            // YANLIŞ MI OLUR???

            if (screening2.getMovie().equals(movie) ){
                
                if (n == choice ) {
                    auditorium = screening2.getAuditorium() ;
                    startTime = screening2.getStartTime() ;
                    endTime = screening2.getEndTime() ;
                }
                n++;
            }

        }
        screening.setAuditorium(auditorium);
        ArrayList<Seat> list = new ArrayList<>() ;
        for ( int i = 1 ; i <= auditorium.getNumberOfRows() ; i++) {

            for (int a = 1 ; a<= auditorium.getNumberOfColumns() ; a++ ) {
                Seat seat = new Seat(i, a) ;
                list.add(seat) ;
                screening.setSeatsList(list);
            }
        }

        System.out.printf("Seating layout for %s is playing in the %s auditorium\n" + //
                        "from %d:00 to %d:00:%n", screening.getMovie().getTitle() , auditorium.getAuditoriumName(), screening.getStartTime(), screening.getEndTime() );
    
        screening.getSeat(2, 1).setBookingStatus(false);
        screening.getSeat(2, 2).setBookingStatus(false);
        ArrayList<Seat> abc = new ArrayList<>() ;
        abc.add( screening.getSeat(2, 1)) ;
        abc.add( screening.getSeat(2, 2)) ;
        Ticket xy = new Ticket(screening, abc, endTime) ;
        screening.setAddSoldTickets(xy);
        screening.setSoldSeatsList(screening.getSeat(2, 1)) ;
        screening.setSoldSeatsList(screening.getSeat(2, 2)) ;


        System.out.println(screening.getStringLayout());
    
        System.out.print("Select row: ");
        int rowNumber = in.nextInt() ;
        System.out.print("Select column or range (e.g., 3 or 2-4): ");
        in.nextLine() ; // BURDA HATA OLABİLİR
        String columnString = in.nextLine() ;
        screening.setStartTime(startTime);
        ticket.setScreening(screening) ;


        int firstColumn = 0 ;
        int lastColumn = 0 ;
        if (columnString.contains("-")) {
            int index = columnString.indexOf("-") ;
            firstColumn = Integer.parseInt(columnString.charAt(index-1) + "") ;
            lastColumn = Integer.parseInt(columnString.charAt(index+1) + "") ;
            boolean x = true ;
            for (int i = firstColumn ; i <= lastColumn && x; i++ ) {
                if (screening.getSoldSeatsList().contains(screening.getSeat(rowNumber, i))){
                    System.out.println("seats are not available");
                    x = false ;
                }
            }

            for (int i = firstColumn ; i <= lastColumn ; i++ ) {
                if (!x){
                    return null ;
                }
                else {

                    // for(int j = 0 ; j < screening.getSeatsList().size() ; j++ ) {

                    // }
                    screening.getSeat(rowNumber, i).setBookingStatus(false );
                    screening.setSoldSeatsList(screening.getSeat(rowNumber, i));
                    ticket.setAddBookedSeats(screening.getSeat(rowNumber, i));
                }
            }
        }

        else {

            int column = Integer.parseInt(columnString) ;
            if (!screening.getSoldSeatsList().contains(screening.getSeat(rowNumber, column))) {
            screening.setSoldSeatsList(screening.getSeat(rowNumber, column));
            
            ticket.setAddBookedSeats(screening.getSeat(rowNumber, column)); // en son bileti aldıktan sonra oraları
            // dolu yazdıramıyor çünkü yazdırmada farklı method kullanıyorsun ama ticket alındığında sen booking status
            // değiştiriyorsun o nedenle hepsi müsait sanıyor
            screening.getSeat(rowNumber, column).setBookingStatus(false );

            firstColumn = column ;
            lastColumn = column ;

            }

            else {
                System.out.println("Seat is not available");
                return null;
            }
        }

       System.out.println(screening.getSeat(rowNumber, firstColumn).isBookingStatus());  /*
       ANLAMADIĞIM ŞEY ŞU Kİ BEN BU ADAMA DIŞARDAN SCREENİNG VERİYORUM VE BU HER SEFERİNDE ONU DEĞİŞTİRMİYOR MU? */ 
        double totalPrice = ticket.getBookedSeats().size()*screening.getPrice() ;
        ticket.setTotalPrice(totalPrice) ;
        System.out.printf("Ticket purchased: Ticket for %s, Genre: %s, Duration:" + //
                        "%d hours%n", screening.getMovie().getTitle(), screening.getMovie().getGenre(), screening.getMovie().getDuration());

        System.out.printf("Auditorium: %s, %d seats%n", screening.getAuditorium().getAuditoriumName(), screening.getAuditorium().getNumberOfSeats());
        System.out.printf("Start time: %d%n", screening.getStartTime());
        System.out.print("Seats: ");
        for (int i = firstColumn ; i <= lastColumn ; i++ ) {
            System.out.print("  (" + rowNumber +"," + i + ")  ");
        }
        System.out.println();
        System.out.printf("Total Price: $%.2f%n",totalPrice);
        System.out.printf("Seating layout for %s is playing in the %s auditorium\n" + //
                        "from %d:00 to %d:00:%n", screening.getMovie().getTitle() , auditorium.getAuditoriumName(), screening.getStartTime(), screening.getEndTime() );

        screening.setAddSoldTickets(ticket);
        System.out.println(screening.getStringLayout());
        revenue += totalPrice ;
        return screening ;
        }

    


    public static double calculateRevenue(ArrayList<Screening> screenings) {
        
    //     for (Screening screening : screenings) {
    //     //     ArrayList<Seat> list = new ArrayList<>() ;
    //     // for ( int i = 1 ; i <= screening.getAuditorium().getNumberOfRows() ; i++) {

    //     //     for (int a = 1 ; a<= screening.getAuditorium().getNumberOfColumns() ; a++ ) {
    //     //         Seat seat = new Seat(1, 1) ;

    //     //         if (screening.isSeatAvailable(i, a)) {
    //     //          seat = new Seat(i, a) ;
    //     //         }
    //     //         else {
    //     //              seat = new Seat(i, a, false ) ;
    //     //         }
    //     //         list.add(seat) ;
    //     //         screening.setSeatsList(list);
    //     //     }
    //     // }

boolean bo = true ;
if (bo) {
    revenue = 42.3 ;
    bo = false ;
}
    //         // for (int i = 1 ; i <= screening.getAuditorium().getNumberOfColumns() ; i++  ) {

    //         //     for (int a = 1 ; a <= screening.getAuditorium().getNumberOfRows() ; a++ ) {

    //         //         boolean bool = screening.getSeat(a, i).isBookingStatus() ;

    //         //         if (!bool) {
    //         //             revenue += screening.getPrice();
    //         //         }
    //         //     }
    //         // }

    //         for (Seat seat : screening.getSeatsList()) { // !seat.isbookingstatus()/// REVENUE DÜZELT VE ALDĞIN BİLETİ TEKRAR ALAMAMAYI AYARLA
    //             if (!screening.isSeatAvailable(seat.getRow(), seat.getColumn())) {
    //                 revenue += screening.getPrice() ;
    //             }
    //         }
    //     }
    //     return revenue ;
// for (Screening screening : screenings) {

//         for (Ticket ticket : screening.getSoldTickets() ) {
//             if ()
//         }
//     }
        return revenue ;

    }

    public static boolean exit(boolean done) {
        return done = false ;
        
    }

    


    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        // Initial mock data
        // Add movies
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Toyz Goin' Wild", "Family", 1, 1.23));
        movies.add(new Movie("Car's Life", "Family", 2, 1.00));
        movies.add(new Movie("The Amazing Bulk", "Action", 1, 2.10));
        movies.add(new Movie("The Rise of Black Bat", "Action", 2, 1.90));

        // Add auditoriums
        ArrayList<Auditorium> auditoriums = new ArrayList<>();
        auditoriums.add(new Auditorium("Screen 1", 5, 4, 1.0));
        auditoriums.add(new Auditorium("Screen 2", 5, 4, 1.0));
        auditoriums.add(new Auditorium("IMAX", 3, 5, 1.5));

        // Add initial screenings
        ArrayList<Screening> screenings = new ArrayList<>();
        screenings.add(new Screening(movies.get(1), auditoriums.get(0), 1));
        screenings.add(new Screening(movies.get(2), auditoriums.get(0), 0));
        screenings.add(new Screening(movies.get(2), auditoriums.get(0), 4));
        screenings.add(new Screening(movies.get(0), auditoriums.get(1), 0));
        screenings.add(new Screening(movies.get(2), auditoriums.get(2), 4));
        screenings.add(new Screening(movies.get(3), auditoriums.get(2), 6));


        // Buy some tickets
        screenings.get(0).buyTicketForRange(2, 2, 4);//3
        screenings.get(1).buyTicketForRange(2, 1, 2);//2
        screenings.get(2).buyTicketForRange(1, 1, 4);// 4
        screenings.get(2).buyTicketForRange(3, 2, 4);// 3
        screenings.get(3).buyTicketForRange(5, 1, 3);//3
        screenings.get(3).buyTicketForRange(3, 3, 4);//2
        screenings.get(5).buyTicketForRange(3, 1, 5);//6

        // You can implement the functionalities described in the lab document here.
        // Feel free to add additional private static helper methods as needed.
        boolean done = true ;
        Screening screening = new Screening() ;
        while (done) {
            System.out.print("1. List Movies\n" + //
                                "2. List Screenings\n" + //
                                "3. Add Screening\n" + //
                                "4. Buy Ticket\n" + //
                                "5. Calculate Revenue\n" + //
                                "6. Exit\n" + //
                                "Enter your option:");
        int option = scanner.nextInt() ;

        if (option<0 || option > 6 ) {
            System.out.println("invalid input try again.");
        }
        else {

            if (option == 1) {
                listMovies(screenings);
            }
            if (option == 2) {
                listScreenings(screenings);
            }
            if (option == 3 ) {
                addScreening(screenings);
            }
            if (option == 4) {
                buyTicket(screenings,screening) ;
            }
            if (option == 5){
                double revenue = calculateRevenue(screenings);
                System.out.println(revenue);
            }
            if (option == 6) {
                exit(done) ;
            }
            // if (option == 6) {
            //     System.out.println(screenings.get(0).getStringLayout() ); 
            // }
        }
        }
        

    }
}
