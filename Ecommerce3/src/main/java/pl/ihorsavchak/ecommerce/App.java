package pl.ihorsavchak.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.ihorsavchak.productcatalog.ArrayListProductRepository;
import pl.ihorsavchak.productcatalog.ProductCatalog;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        System.out.println("works");
        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createProductCatalog() {
        ProductCatalog catalog = new ProductCatalog(
                new ArrayListProductRepository()
        );
        catalog.createProduct("something", "100");
        catalog.createProduct("something more", "200");

        return catalog;
    }
}
