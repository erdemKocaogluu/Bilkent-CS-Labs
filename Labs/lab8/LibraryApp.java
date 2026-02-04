import java.util.Scanner;

public class LibraryApp {
    
    public static void printMenu() {
        System.out.print("Library Management System\n" + //
                        "-------------------------\n" + //
                        "1. Add a new book\n" + //
                        "2. Register a new member\n" + //
                        "3. Borrow a book\n" + //
                        "4. Return a book\n" + //
                        "5. View borrowed books of a member\n" + //
                        "6. Exit\n" + //
                        "Enter your choice:");
    }


    public static void main(String[] args) {
        boolean done = true ;
        Library library = new Library() ;
        Scanner in = new Scanner( System.in ) ;


        while (done) {
        printMenu();
        int choice = in.nextInt() ;
        in.nextLine() ; // CHOİCEDAN SONRA İNNEXTLİNE ALMAYACAK MI NEDEN HATA VERİYOR CHOİCE 7 SONRAKİ FOTODA
        if ( choice == 1 ) {
            System.out.print("Enter book Id: ");
            // in.nextLine() ;
            String bookId = in.nextLine() ;
            System.out.print("Enter book title: ");
            String bookTitle = in.nextLine() ;
            System.out.print("Enter book author: ");
            String bookAuthor = in.nextLine() ;
            Book addedBook = new Book(bookId, bookTitle, bookAuthor) ;
            library.addBook(addedBook);
        }

        if (choice == 2 ) {
            System.out.print("Enter member Id: ");
            String memberId = in.nextLine() ;
            System.out.print("Enter member name: ");
            String memberName = in.nextLine() ;
            Member member = new Member(memberId, memberName) ;
            library.addMember(member);
        }

        if ( choice == 3 ) {
            System.out.print("Enter book Id: ");
            String bookId = in.nextLine() ;
            System.out.print("Enter member Id: ");
            String memberId = in.nextLine() ;
            library.borrowBook(bookId, memberId);


        }

        if (choice == 4 ) {
            System.out.print("Enter book Id: ");
            String bookId = in.nextLine() ;
            library.returnBook(bookId);

        }

        if (choice == 5 ) {
            System.out.print("Enter member Id: ");
            String memberId = in.nextLine() ;
            Member theMember = library.returnMember(memberId) ;
            // System.out.println(theMember.getBorrowedBooks());
            theMember.display(theMember.getBorrowedBooks());

        }

        if (choice == 6 ) {
            done = false ;
        }

        // if (choice == 7 ) {
        //     int x = in.nextInt() ;
        //     System.out.println(x);
        // }




    }
        
    }
}
