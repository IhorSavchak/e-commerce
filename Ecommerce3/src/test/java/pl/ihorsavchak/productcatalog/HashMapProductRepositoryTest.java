package pl.ihorsavchak.productcatalog;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapProductRepositoryTest {
    @Test
    void isStoreAndLoadsProducts() {
        Product product = thereIsProduct();
        ProductRepository repository = thereIsProductRepository();

        repository.save(product);
        Product loaded = repository.loadProductById(product.getId());

        assertEquals(product.getId(), loaded.getId());
        assertEquals(product.getDescription(), loaded.getDescription());
    }
    private Product thereIsProduct() {
        return new Product(UUID.randomUUID(), "test", "?");
    }

    private ProductRepository thereIsProductRepository() {
        return null;
    }
    private List<Product> allProducts() {
        return null;
    }

    @Test
    void loadsAllProducts() {
        Product product = thereIsProduct();
        ProductRepository repository = thereIsProductRepository();

        repository.save(product);
        List<Product> loaded = repository.allProducts();
        assertEquals(1, loaded.size());
    }
}
