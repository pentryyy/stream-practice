package GeneratingNumbers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectorsExample {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );
        
        // Группировка по продуктам
        Map<String, List<Order>> productGrouping = orders.stream()
                                                         .collect(Collectors.groupingBy(Order::getProduct));
        
        System.out.println("-----Общая стоимость продуктов-----");
        productGrouping.entrySet().forEach(entry -> {

            String product = entry.getKey();
            Double sum     = entry.getValue()
                                  .stream()
                                  .collect(Collectors.summingDouble(Order::getCost));
            
            System.out.println(product + " " + sum);
        });
        
        System.out.println("-------Топ 3 продукта по цене------");
        orders.stream()
              .sorted(new OrderComparator().reversed())
              .limit(3)
              .forEach(order -> System.out.print(order.getProduct() + " " + order.getCost() + "\n"));
    }
}
