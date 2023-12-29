package ru.astondevs.goodsservice.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.astondevs.goodsservice.TestData;
import ru.astondevs.goodsservice.model.Product;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.astondevs.goodsservice.util.Constant.DEFAULT_PAGE;
import static ru.astondevs.goodsservice.util.Constant.DEFAULT_SIZE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
class ProductRepositoryTest {
/*
    @Autowired
    ProductRepository productRepository;

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15-alpine");

    @DynamicPropertySource
    static void registerTestcontainersProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Test
    void findAllSuccess() {
        var actualResult = productRepository.findAll();
        assertThat(actualResult).isNotEmpty();
        assertThat(actualResult).hasSize(10);
    }

    @Test
    void findAllShouldReturnEmptyListIfTableEmpty() {
        productRepository.deleteAll();
        var actualResult = productRepository.findAll();
        assertThat(actualResult).isNotNull();
        assertThat(actualResult).isEmpty();
    }

    @Test
    void findByIdSuccess() {
        var expectingResult = TestData.getProduct1();
        var id = expectingResult.getId();

        var actualResult = productRepository.findById(id);

        assertThat(actualResult).isNotNull();
        assertThat(actualResult).isPresent();
        assertThat(actualResult.get()).isEqualTo(expectingResult);
    }

    @Test
    void testFindByIdShouldReturnEmptyOptionalIfElementAbsent() {
        var id = 10000L;
        var actualResult = productRepository.findById(id);
        assertThat(actualResult).isNotNull();
        assertThat(actualResult).isEmpty();
    }

    @Test
    void updateSuccess() {
        var id = TestData.getProduct1().getId();

        var prevListSize = productRepository.findAll().size();

        var optional = productRepository.findById(id);
        assertThat(optional).isPresent();
        var entityInDatabase = optional.get();

        var previousQuantity = entityInDatabase.getQuantity();
        var updatedQuantity = previousQuantity - 1;

        var productWithUpdatedQuantity = new Product(id, entityInDatabase.getName(), entityInDatabase.getDescription(),
                updatedQuantity, entityInDatabase.getPrice(), 1L);

        var updatedValue = productRepository.save(productWithUpdatedQuantity);
        assertThat(updatedValue).isNotNull();
        assertThat(updatedValue.getId()).isEqualTo(id);
        assertThat(updatedValue).isEqualTo(productWithUpdatedQuantity);

        var newListSize = productRepository.findAll().size();
        assertThat(prevListSize).isEqualTo(newListSize);
    }

    @Test
    void findAllSuccessWithPaging() {
        var actualResult = productRepository.findAll(PageRequest.of(0,2));
        assertThat(actualResult).isNotEmpty();
        assertThat(actualResult).hasSize(2);
    }*/
}