import java.util.ArrayList;

public class Book {

    private String id ;
    private String title ;
    private String author ; // String x , y = "345" ;==??
    private boolean isAvailable ;

    public Book () {

    }

    public Book (String id, String title, String author ) {
        this.id = id ;
        this.title = title ;
        this.author = author ;
        this.isAvailable = true ;
    }

    public String getId() {
        return id ;
    }
    public String getTitle() {
        return title ;
    }
    public String getAuthor() {
        return author ;
    }
    public Boolean getIsAvailable() {
        return isAvailable ;
    }
    
    public void changeTitle(String newTitle ) {
        title = newTitle ;
    }
    public void setAuthor(String author ) {
        this.author = author ;
    }
    public void borrow() {
        if (isAvailable) {
        isAvailable = false ;
        }
        else {
            System.out.println("book is not available");
        }
    }
    public void returnBook() { // KİTAP ZATEN AVAİLABLE İSE
        if (!isAvailable) {
            isAvailable = true ;
            }
            else {
                System.out.println("book is already available");
            }
    }

    public String toString(Book book ) {
        return ("id: " + id + "title: " + title + "author: " + author);
    }

    
}