import java.util.ArrayList;

public class Member {
    private String id ;
    private String name ;
    private ArrayList<Book> borrowedBooks = new ArrayList<Book>(); // VARİABLELARI PRİVATE YAPMAYI UNUTMA

    public Member () {

    }
    public Member (String id, String name) {
        this.id = id ;
        this.name = name ;
    }

    public String getId () {
        return id ;
    }
    public String getName () {
        return name ;
    }
    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks ;
    }

    public void setName (String newName) {
        name = newName ;
    }

    // public void setBorrowedBooks(ArrayList<Book> newBorrowedBooksList ) {
    //     borrowedBooks = newBorrowedBooksList ;
    // }

    public void setBorrowedBooksAdd(Book newBorrowedBook ) {
        borrowedBooks.add(newBorrowedBook) ;
    }

    public void setBorrowedBooksMinus(Book returnedBorrowedBook ) {
        borrowedBooks.remove(returnedBorrowedBook ) ;
    }

    public boolean equals(Member member) {
        if (member.getId() == this.getId() && member.getName() == this.getName()) {
            return true ;
        }
        return false ;
    }

    public void display(ArrayList<Book> books ) {

        for (Book book : books ) {
            System.out.println("id:"  + book.getId() + "  title:" + book.getTitle() + "  author: " + book.getAuthor());

        }

    }
}
