import com.apple.laf.ScreenMenuBar;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaFilters {

    AddressCollection addresses = new AddressCollection();

    // Call filter function
    List<Address> addressByCity = filterAddresses(addresses, a-> a.getCity().equalsIgnoreCase("Philadelphia"));
    

    List<Address> filterAddresses(List<Address> source, Predicate<Address> criteria) {
        List<Address> result = new ArrayList<>();
        for (Address a: source){
            if(criteria.test(a)) {
                result.add(a);
            }
        }
        return result;
    }
}
