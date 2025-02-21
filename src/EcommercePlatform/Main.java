package EcommercePlatform;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Product laptop= new Product("Laptop",2000.0);
        Product tablet = new Product("Tablet",1500.0);
        Product phone= new Product("Phone",800.0);

        Customer bob = new Customer("Bob");
        Customer joyce = new Customer("Joyce");
        Customer sara = new Customer("Sara");

        Order order1 =new Order(bob,Map.of(laptop, 1, phone, 2), LocalDate.now().minusDays(10));
        Order order2=new Order(joyce,Map.of(phone, 3,tablet, 2), LocalDate.now().minusDays(5));
        Order order3=new Order(sara,Map.of(tablet, 5,laptop, 1), LocalDate.now().minusDays(40));
        Order order4=new Order(bob,Map.of(phone, 1), LocalDate.now().minusDays(2));

        bob.addOrder(order1);
        bob.addOrder(order4);
        joyce.addOrder(order2);
        sara.addOrder(order3);

        List<Customer> customers = List.of(bob,joyce,sara);
        List<Order> orders = List.of(order1, order2, order3, order4);


        List<Customer> topSpenders=customers
                .stream()
                .sorted(Comparator.comparingDouble(Customer::getTotalSpent)
                        .reversed())
                .limit(3)
                .toList();
        System.out.println("Top 3 spending customers: ");
        topSpenders.forEach(c -> System.out.println(c.getName() + " - $" + c.getTotalSpent()));

        Map<Product,Integer> productSales=new HashMap<>();
        orders.forEach(order-> order.getProducts()
                .forEach((product,quantity)->productSales.merge(product, quantity, Integer::sum)));

            Product mostPurchasedProduct=productSales.entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse(null);
        System.out.println("\n Most purchased product: " + (mostPurchasedProduct != null ? mostPurchasedProduct.getName() : "Not Found"));

            double avgOrdersPerCustomer=customers
                    .stream()
                    .mapToInt(c -> c.getOrders().size())
                    .average()
                    .orElse(0);
        System.out.println("\n Average orders per customer: " + avgOrdersPerCustomer);

        double totalRevenue = orders.stream()
                .mapToDouble(Order::getTotalAmount)
                .sum();
        System.out.println("\n Total revenue: $" + totalRevenue);

            LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
            List<Order> recentOrders=orders
                    .stream()
                    .filter(order-> order.getOrderDate().isAfter(thirtyDaysAgo))
                    .toList();
        System.out.println("\n Orders in the last 30 days: " + recentOrders.size());

        System.out.println("\n Customer order summary:");
        customers.forEach(c -> System.out.println(c.getName() + " - $" + c.getTotalSpent()));

        List<Order> expensiveOrders=orders
                    .stream()
                    .filter(order->order.getTotalAmount() > 1000)
                    .toList();

        System.out.println("\n Orders exceeding $1000:");
        expensiveOrders.forEach(o -> System.out.println(o.getCustomer().getName() + " - $" + o.getTotalAmount()));

    }
}
