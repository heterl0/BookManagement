package bai3;

/**
 *
 * @author Le Van Hieu CE160866
 */
public class Book extends Document{
    private String author;
    private int numOfPage;

    public Book(int id, String publisher, int numberRelease, String author, int numOfPage) {
        super(id, publisher, numberRelease);
        this.author = author;
        this.numOfPage = numOfPage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumOfPage() {
        return numOfPage;
    }

    public void setNumOfPage(int numOfPage) {
        this.numOfPage = numOfPage;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + this.getId() + ", publisher=" + this.getPublisher() + ", numberRelease=" + this.getNumberRelease() + "author=" + author + ", numOfPage=" + numOfPage + '}';
    }
    
    
}
