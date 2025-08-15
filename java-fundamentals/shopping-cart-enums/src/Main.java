//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Create enum
        enum OrderStatus {
            PENDING,
            PROCESSING,
            SHIPPED,
            DELIVERED

        }
        enum ShippingStatus {
            STANDARD,
            TWO_DAY,
            OVERNIGHT
        }
        System.out.printf("Hello and welcome to the shopping cart app 🛒!");

        // Print OrderStatus Values
        System.out.println("All OrderStatus values: ");
        for (OrderStatus status : OrderStatus.values()) {
            System.out.println("-" + status);
        }

        // Print ShippingStatus
        System.out.println("\nAll ShippingStatus values");
        for (ShippingStatus status : ShippingStatus.values()){
            System.out.println("-" + status);
        }

        // Variables and enum values
        OrderStatus currentOrderStatus = OrderStatus.PROCESSING;
        ShippingStatus currentShippingStatus = ShippingStatus.TWO_DAY;

        // print current status
        System.out.println("\nCurrent order status:");
        System.out.println("Current shipping status");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}