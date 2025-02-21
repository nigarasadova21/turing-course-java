package EcommercePlatform;

import java.util.ArrayList;
import java.util.List;

public class Customer {
   private  final String name;
   private final List<Order> orders=new ArrayList<>();

    public Customer(String name) {
        this.name = name;

    }
    public void addOrder(Order order){
        orders.add(order);
    }
    public List<Order> getOrders(){
        return orders;
    }
    public String getName() {
        return name;
    }
    public double getTotalSpent() {
        return orders
                .stream()
                .mapToDouble(Order::getTotalAmount)
                .sum();
    }

}
