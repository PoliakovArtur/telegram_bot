package ru.astondevs.goodsservice.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import ru.astondevs.goodsservice.TestData;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = ProductMapperImpl.class)
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
class ProductMapperTest {

    @Autowired
    ProductMapper productMapper;

    @Test
    void toDtoSuccess() {
        var givenEntity = TestData.getProduct1();

        var expectedResult = TestData.getProductDto1();

        var actualResult = productMapper.toDto(givenEntity);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void toEntitySuccess() {
        var givenDto = TestData.getProductDto1();

        var expectedResult = TestData.getProduct1();

        var actualResult = productMapper.toEntity(givenDto);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void toDtoListSuccess() {
        var givenList = List.of(TestData.getProduct1(), TestData.getProduct2(), TestData.getProduct3());
        var expectedResult = List.of(TestData.getProductDto1(), TestData.getProductDto2(), TestData.getProductDto3());

        var actualResult = productMapper.toDtoList(givenList);

        assertThat(actualResult).isNotEmpty();
        assertThat(actualResult).hasSize(3);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void toEntityListSuccess() {
        var givenList = List.of(TestData.getProductDto1(), TestData.getProductDto2(), TestData.getProductDto3());
        var expectedResult = List.of(TestData.getProduct1(), TestData.getProduct2(), TestData.getProduct3());

        var actualResult = productMapper.toEntityList(givenList);

        assertThat(actualResult).isNotEmpty();
        assertThat(actualResult).hasSize(3);
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}