import java.util.Arrays;

/* ;
        int[] y  = {1} ;
        boolean a  = Arrays.equals(x, y) ;
        System.out.println(x == y);
         */

public class Auditorium {
    
    private String name ;
    private int numberOfRows ;
    private int numberOfColumns ;
    private double baseTicketPrice ;
    private double priceMultiplier ;
    private int numberOfSeats ;

    public Auditorium () {
        
    }
    
    public Auditorium(String name, int numberOfSeats) {
        this.name = name ;
        this.numberOfSeats = numberOfSeats ; // BURADA NUMBEROFCOLUMNS İLE NUMBEROFROWU SOYLMİYORUM ZATEN ONLAR 
        // ARRAYLİST YA DA ARRAY FALAN YA DA HERHANGİ BİR OBJECT DEĞİL YA ONLAR 0 A TNAIMLANIYOR ONLAR PRİMİTİVE
        // ZATEN
    }

    public Auditorium (String name,int numberOfRows,int numberOfColumns,double priceMultiplier ) {
        this.name = name ;
        this.numberOfRows = numberOfRows ;
        this.numberOfColumns = numberOfColumns ;
        this.priceMultiplier = priceMultiplier ;

    }

    public int getNumberOfSeats() {
        return getNumberOfColumns() * getNumberOfRows() ; 
    }

    /* int duration diyip
     * aşağı methodda double getDuration
     * return duration.
     * desek nolur
     */

    public String getAuditoriumName() {
        return name ;
    }
    
    public int getNumberOfRows() {
        return numberOfRows ;
    }

    public int getNumberOfColumns() {
        return numberOfColumns ;
    }

    public double getPriceMultiplier() {
        return priceMultiplier ;
    }

    public String toString() {
        return "name:" + name + " total seat count: " + numberOfColumns * numberOfRows ; //ÇARPMA ÖNCELİĞİ VAR
        // SIKINTI YOK 
    }

    public boolean equals(Object obj ) {
        if (obj == this) {
            return true ;
        }
        if (obj == null || obj.getClass().equals(getClass()) ) {
            return false ;
        }
        Auditorium other = (Auditorium) obj ;
        if (other.getAuditoriumName().equals(getAuditoriumName())){
             return true ;
        }
        return false ;
    }


   
}
