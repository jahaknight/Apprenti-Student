public class Book {
    private String title;
    private String author;
    boolean isAvailable;



    public Book () {}

    public Book(String title, String author){
        this.title = title;
        this.author = author;
        this.isAvailable = true;

    }

    public Book(String title, String author, boolean isAvailable){
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public void borrowBook(){
        this.isAvailable = false;
    }
}
