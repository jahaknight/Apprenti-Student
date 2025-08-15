public class CoffeeMeNow {
    public static void main(String[] args) {
        //A café uses enums to manage coffee sizes.

        //1. Create an enum named CoffeeSize with three constants:
            //SMALL
            //MEDIUM
            //LARGE
enum CoffeeSizes {
    TALL,
    GRANDE,
    VENTI
}
        //2. Declare and initialize a variable of type CoffeeSize to store a predefined coffee order.
        CoffeeSizes myOrder = CoffeeSizes.TALL;

        //3. Print the selected coffee size.
        System.out.println("My Order is of size: " + myOrder);

    }
}
