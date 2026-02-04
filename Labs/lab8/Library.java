import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<Book>() ;
    private ArrayList<Member> members = new ArrayList<Member>() ;
    // Book books = new Book() ;

    public void addBook(Book book) {
        books.add(book) ;
    }
    public void addMember(Member member) {
        members.add(member) ;
    }
    public void borrowBook(String bookId,String memberId) {
        Book borrowedBook = new Book() ;
        Member borrowingMember = new Member() ;
        Member emptyMember = new Member() ;
    for (Book book : books ) {
        if (book.getId().equals(bookId) ) {
           borrowedBook = book ;
        }
    }
    for (Member member : members ) {
        if (member.getId().equals(memberId)) {
            borrowingMember = member ;
        }
    }

    if (borrowedBook.getIsAvailable() && !borrowingMember.equals(emptyMember)) {
    borrowedBook.borrow(); 
    // borrowingMember.setBorrowedBooks(borrowingMember.getBorrowedBooks().add(borrowedBook));
    borrowingMember.setBorrowedBooksAdd(borrowedBook);
    }

    else if (!borrowedBook.getIsAvailable()){
        System.out.println("book is not available");
    }
        //Member member = new Member(memberId,) ;

    if (borrowingMember.equals(emptyMember)){
        System.out.println("member does not exist");
    }

    }



    public void returnBook(String bookId) {
        Book returnedBook = new Book() ;
        for (Book book : books) {
            if (book.getId().equals(bookId) ) {
                returnedBook = book ;
            }
        }
        

        if ( !returnedBook.getIsAvailable()) {
            returnedBook.returnBook();
        }
        else {
            System.out.println("Book is already available");
        }

    }

    public Member returnMember(String memberId ) {
        Member theMember = new Member() ;
        for (Member member : members ) {
            if (member.getId().equals(memberId)) {
                theMember = member ;
            }
        }
        return theMember ;
    }



   
}
