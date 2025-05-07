package pl.isavchak.ecommerce.catalog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductCatalogConfiguration {
    @Bean
    ProductCatalog createProductCatalog(ProductRepository productRepository) {
        ProductCatalog catalog = new ProductCatalog(productRepository);
        catalog.createProduct ( "nice one 1","desc");
        catalog.createProduct ( "nice one 2", "desc");
        catalog.createProduct ( "nice one 3", "desc");
        catalog.createProduct ( "nice one 4", "desc");
        return catalog;
    }
}
@Bean
ProductRepository createMyProductRepository (JdbcTemplate jdbcTemplate) {
    return new DbProductRepository(jdbcTemplate);
}