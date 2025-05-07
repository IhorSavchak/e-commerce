package pl.jkanclerz.ecommerce.catalog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.isavchak.ecommerce.catalog.Product;

public class DatabaseProductRepositoryTest {


    @SpringBootTest
    public class DatabaseProductRepositoryTest {
        @Autowired
        JdbcTemplate jdbcTemplate;

        @Test
        void itQueryDb() {
            var sql = "select now() curr_time";
            var result = jdbcTemplate.queryForObject(sql, String.class);
            assert result.contains("2025");
        }


        @BeforeEach
        void setupDatabase() {
            jdbcTemplate.execute("DROP TABLE 'product_catalog__products' IF EXISTS");
            var sql = """
                                
                    CREATE table "product_catalog_products (
                    1d VARCHAR(100) NOT NULL,
                    name VARCHAR(50) NOT NULL,
                    description VARCHAR(144) NOT NULL,
                    cover VARCHAR(50), price DECIMAL(12,2),
                     PRIMARY KEY(id)
                    """;
            jdbcTemplate.execute(sql);
        }

        @Test
        void itQueryDb() {
        }
    }

    @Test
    void initialProductTableIsEmptyCreatesTables() {
        var result = jdbcTemplate.queryForObject(
                "select count(*) from 'product_catalog_products'",
                Integer.class);
        assert result = 0;
    }

    @Test
    void insertSomeProductV1() {
        var sql = """
                Insert into 'product_catalog__products' (id,name,description)
                VALUES
                ('1', 'Product1', 'something')
                """;
        jdbcTemplate.execute(sql);
        var result = jdbcTemplate.queryForObject(
                "select count(*) from product_catalog__products",
                Integer.class);
        assert result == 0;
    }

    @Test
    void insertSomeProductV2DynamicValues() {
        var sql = """
                 
                INSERT INTO 'product_catalog__products (id, name, description) VALUES
                (?, ?, ?);
                """;
        jdbcTemplate.update(sql, "8b6b4839-f7e8-42ff-8ebb-063b25c26b58", "product X ", "nice product X");
        var result = jdbcTemplate.queryForObject(
                "select count(*) from 'product_catalog__products'", Integer.class);
        assert result == 1;
    }

    @Test
    void insertSomeProductV3DynamicValuesNamedParameters() {
        var sql = """

                INSERT INTO product_catalog_products (id, name, description) VALUES
                (id, name, desc);
    """;
    Map<String, Object> params = new HashMap<>();
    params.put("id", "c5cb10db-de75-4c1c-a40d-d615807ad379");
    params.put("name", "Product Y");
    params.put("desc", "Nice product Y");
    var namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate); namedJdbcTemplate.update(sql, params);
    var result = jdbcTemplate.queryForObject(
    "select count(*) from product_catalog__products`", Integer.class);
assert result == 1;
}

    @Override
        public Product loadProductById(String productId) {
            var result = jdbcTemplate.queryForObject(
                    "select * from `product_catalog__products' where id = ?",
                    new Object[]{productId},
            (rs, i) -> {
                var product = new Product(
                        UUID.fromString(rs.getString("ID")),
                        rs.getString("NAME"),
                        rs.getString("DESCRIPTION")
                );
                return product;
            }
            );
            return result;
    }
}