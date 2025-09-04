import java.time.LocalDateTime;

public class Logger {

    public void logToScreen(String msg) {
        System.out.println("Screen log for " + msg);
    }

    public void timeStampedLog(String msg) {
        logToScreen(msg + " : at timestamp " + LocalDateTime.now());
    }




//
// System.out.println("Screen log for " + msg +
//            " : at timestamp " + LocalDateTime.now());
//           // Output: what am i doing when
//           System.out.println("Screen Log for starting processing orders " +
//                   " : at timestamp: " + LocalDateTime.now());
//
//           // Output : Each order IF
//           System.out.println("Screen Log for Order: " +
//                   o.getOrderId() +
//                   " : at timestamp: " + LocalDateTime.now());
//
//           // Output : Each order ID and Item storing
//           System.out.println("Screen Log for Processing Order: " + o.getOrderId() + " Item : " + i.itemName);
//
//
//           // Output: completion
//           System.out.println("Screen Log for ending processing orders " +
//                   " : at timestamp: " + LocalDateTime.now());
}
