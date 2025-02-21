package EcommercePlatform;

import java.time.LocalDate;
import java.util.Map;

public class Order {
    private final Customer customer;
    private final  Map<Product, Integer> products;
    private final LocalDate orderDate;
    public Order(Customer customer, Map<Product, Integer> products, LocalDate orderDate) {
        this.customer = customer;
        this.products = products;
        this.orderDate = orderDate;
    }
    public double getTotalAmount() {
        return products.entrySet()
                .stream()
                .mapToDouble(entry->entry.getKey().getPrice() * entry.getValue())
                .sum();
    }
    public Map<Product, Integer> getProducts() {
        return products;
    }
    public LocalDate getOrderDate() {
        return orderDate;
    }
    public Customer getCustomer() {
        return customer;
    }
}
