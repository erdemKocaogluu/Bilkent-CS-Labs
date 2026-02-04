public class Movie {
    
    private String title ;
    private String genre;
    private int duration ;
    private double baseTicketPrice ;

    public Movie (String title,String genre,int duration,double baseTicketPrice) {

        this.title = title ;
        this.genre = genre ;
        this.duration = duration ;
        this.baseTicketPrice = baseTicketPrice ;
    }

    public String getTitle () {
        return title ;
    }

    public String getGenre() {
        return genre ;
    }

    public int getDuration() {
        return duration ;
    }

    public double getBaseTicketPrice() {
        return baseTicketPrice ;
    }

    public String toString() {
        return "title: "+title +"/ genre: " + genre + "/ duration: " + duration + "/ base ticket price: " + baseTicketPrice ;

    }
    public boolean equals (Object obj) {
        if (obj == this) {
            return true ;
        }
        if (obj == null || obj.getClass() != getClass() ) return false ;
        Movie otherMovie = (Movie) obj ;
        return (otherMovie.getTitle().equals(getTitle())) ;
    }



}
