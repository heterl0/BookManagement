
package bai3;

/**
 *
 * @author Le Van Hieu CE160866
 */
public class Document {
    private int id;
    private String publisher;
    private int numberRelease;

    public Document(int id, String publisher, int numberRelease) {
        this.id = id;
        this.publisher = publisher;
        this.numberRelease = numberRelease;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumberRelease() {
        return numberRelease;
    }

    public void setNumberRelease(int numberRelease) {
        this.numberRelease = numberRelease;
    }

    @Override
    public String toString() {
        return "Document{" + "id=" + id + ", publisher=" + publisher + ", numberRelease=" + numberRelease + '}';
    }
    
    
}
