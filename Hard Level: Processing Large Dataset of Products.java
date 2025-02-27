import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + '}';
    }
}

public class ProductProcessing {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics", 800));
        products.add(new Product("Smartphone", "Electronics", 600));
        products.add(new Product("Tablet", "Electronics", 300));
        products.add(new Product("Refrigerator", "Appliances", 1000));
        products.add(new Product("Microwave", "Appliances", 200));
        products.add(new Product("TV", "Electronics", 700));
        products.add(new Product("Blender", "Appliances", 150));

        System.out.println("Original Product List:");
        products.forEach(System.out::println);

        // 1. Grouping products by category
        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));

        System.out.println("\nProducts Grouped by Category:");
        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        // 2. Most expensive product in each category
        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(p -> p.category,
                        Collectors.maxBy(Comparator.comparingDouble(p -> p.price))));

        System.out.println("\nMost Expensive Product in Each Category:");
        mostExpensiveByCategory.forEach((category, product) -> 
                System.out.println(category + ": " + product.orElse(null))
        );

        // 3. Average price of all products
        DoubleSummaryStatistics stats = products.stream()
                .collect(Collectors.summarizingDouble(p -> p.price));

        System.out.println("\nAverage Price of All Products: " + stats.getAverage());
    }
}
