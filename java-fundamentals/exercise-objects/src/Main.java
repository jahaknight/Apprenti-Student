//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Hyundai", "Santa-Fe", 2022);
        Car car2 = new Car("Acura", "NSX", 1994);

        System.out.println(car1.displayInfo());
        System.out.println(car2.displayInfo());
        System.out.println(car1 == car2);
        System.out.println(car1.equals(car2));

        Book book1 = new Book("The Hobbit", "Tolkein");
        Book book2 = new Book("The Lord of the Rings", "Tolkein", false);
        Book book3= new Book();

        System.out.println(book2.isAvailable);
        if (book2.isAvailable) {
            book2.borrowBook();
        } else {
            System.out.println("Book Unavailable");
        }

    }
}