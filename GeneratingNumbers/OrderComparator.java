package GeneratingNumbers;

import java.util.Comparator;

public class OrderComparator implements Comparator<Order>{
  
    public int compare(Order a, Order b){
        return Double.compare(a.getCost(),(b.getCost()));
    }
}
