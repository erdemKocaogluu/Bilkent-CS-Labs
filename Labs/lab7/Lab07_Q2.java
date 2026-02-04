import java.util.ArrayList;

public class Lab07_Q2 {
    
    public static void reserveBook(int bookId, ArrayList<Integer> reservations) {
        System.out.println();
        if (reservations.contains(bookId)) {
            System.out.printf("Book %d is already reserved.", bookId);
            System.out.println();

        }
        else {
        System.out.printf("Book %d reserved successfully.", bookId);
        System.out.println();
        reservations.add(  bookId) ;
        }
    }

    public static void returnBook(int bookId, ArrayList<Integer> reservations) {
        System.out.println();
        if (reservations.contains(bookId)) {
            System.out.printf("Book %d returned successfully.", bookId);
            System.out.println();
            int x = reservations.indexOf(bookId) ;
            reservations.remove(x) ;
        }
        else {
        System.out.printf("Book %d was not reserved.", bookId); // %n İ NİYE PRİNTLİYOR
        System.out.println();
        }
    }

    public static void displayBooks(ArrayList<Integer> reservations) {
        System.out.println();
        System.out.println("Current Book Status:");
        for (int i = 1 ; i <= 10 ; i++ ) {

            System.out.printf("Book %d: ", i);
            if (reservations.contains(i)) {
                System.out.print("Reserved");
                System.out.println();

            }
            else {
                System.out.print("Available");
                System.out.println();

            }

        }
    }

    public static void processBatchReservations(int[] batch, ArrayList<Integer> reservations) {
        System.out.println();
        for (int i : batch) {
            if (reservations.contains(i)) {
                System.out.printf("Book %d is already reserved.", i);
                System.out.println();

            }
            else {
                System.out.printf("Book %d reserved successfully.", i);
                System.out.println();

                reservations.add(i) ;
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> reservations = new ArrayList<>();
        reserveBook(3, reservations);
        reserveBook(7, reservations);
        reserveBook(3, reservations); 
        displayBooks(reservations);
        returnBook(3, reservations);
        returnBook(5, reservations); 
        displayBooks(reservations);
        int[] batch = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        processBatchReservations(batch, reservations);
        displayBooks(reservations);
    }
}
