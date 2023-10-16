/* 
 * Author: Abhijeet Rathore
 * Date: 14/10/2023
 * Description: Example of Association Relationship 
 */

//Base Class 
class Writer {

    // Declaring Variable to store the name of a writer
    String writerName;

    // constructor that will assign the value
    public Writer(String writerName) {
        this.writerName = writerName;
    }

    void write() {
        System.out.println(writerName + " is Writing!");
    }

}

// this class represents the properties of the book
class Book {
    String bookTitle; // stores the title of the book
    String bookGenre; // store the genre of the book
    int bookPublicationYear; // stores the publication year of the book

    // constructor that will assign the details of the book
    public Book(String bookTitle, String bookGenre, int bookPublicationYear) {
        this.bookTitle = bookTitle;
        this.bookGenre = bookGenre;
        this.bookPublicationYear = bookPublicationYear;
    }

}

class Publisher {
    String publisherName;

    // This constructor will assign the name of the publisher
    public Publisher(String publisherName) {
        this.publisherName = publisherName;
    }

    // this function prints the name of the book, that is publishing
    void publish(Book bookObj) {
        System.out.println("Publishing the Book: " + bookObj.bookTitle + " in " + publisherName);

    }

}

// sub class which extends the properties of the Writer Class
class BookAuthor extends Writer {
    Book bookObj2;

    public BookAuthor(String writerName, String bookTitle, String bookGenre, int bookPublicationYear) {
        super(writerName); // Initializing the name of writer & details of a book first, by refereing
                           // parant object
        bookObj2 = new Book(bookTitle, bookGenre, bookPublicationYear); // initializing the book class object
    }

    void writeBook() {
        super.write(); // parent class write function will be called
        System.out.println(writerName + " is writing the book " + bookObj2.bookTitle);
    }

    void sendToPublisher(Publisher publisherObj) {
        publisherObj.publish(bookObj2);
    }

    // returning reference of the book
    Book publishStatus() {
        return bookObj2;
    }

    // this function will print the details of the book
    void bookDetails() {
        System.out.println("Book Name: " + bookObj2.bookTitle);
        System.out.println("Book Genre: " + bookObj2.bookGenre);
        System.out.println("Book Publication Year: " + bookObj2.bookPublicationYear);
    }

}

// Driver Module
public class WriterTest {
    public static void main(String[] args) {

        // First Book
        BookAuthor bookAuthorObj1 = new BookAuthor("Joshua Bloch", "Effective Java", "Programming", 2001);
        bookAuthorObj1.writeBook();

        Publisher publisherObj1 = new Publisher("Addison-Wesley Professional");
        bookAuthorObj1.sendToPublisher(publisherObj1);

        // ref of book1 object
        Book bookStatus1 = bookAuthorObj1.publishStatus();
        System.out.println(bookStatus1.bookTitle + " has been published");

        System.out.println("-------------------------------------");
        System.out.println("\nBook Information :");
        System.out.println("-------------------------------");
        bookAuthorObj1.bookDetails();
        System.out.println("-------------------------------");

        // Second Book
        BookAuthor bookAuthorObj2 = new BookAuthor("Arthur Conan Doyle", "The Adventure of Sherlock Homes", "Mystery",
                1892);
        bookAuthorObj2.writeBook();

        Publisher publisherObj2 = new Publisher("The Strand Magazine");
        bookAuthorObj2.sendToPublisher(publisherObj2);

        // ref of book2 object
        Book bookStatus2 = bookAuthorObj2.publishStatus();
        System.out.println(bookStatus2.bookTitle + " has been published"); // prints the status of the book

        System.out.println("-------------------------------------");
        System.out.println("\nBook Information :");
        System.out.println("-------------------------------");
        bookAuthorObj2.bookDetails();
        System.out.println("-------------------------------");

    }
}
