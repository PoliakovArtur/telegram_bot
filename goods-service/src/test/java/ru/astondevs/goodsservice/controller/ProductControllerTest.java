package ru.astondevs.goodsservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;
import ru.astondevs.goodsservice.dto.ProductDto;
import ru.astondevs.goodsservice.service.ProductService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.astondevs.goodsservice.TestData.getProductDto1;
import static ru.astondevs.goodsservice.util.Constant.DEFAULT_PAGE;
import static ru.astondevs.goodsservice.util.Constant.DEFAULT_SIZE;
import static ru.astondevs.goodsservice.util.Constant.SELL_MESSAGE;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ProductService service;

    private final ProductDto productDto = getProductDto1();
    private final List<ProductDto> products= List.of(productDto);

    @SneakyThrows
    @Test
    void getAll_whenRequested_thenReturnListDtoAndStatusOk() {
        List<ProductDto> expected = products;
        when(service.readAll(1L, PageRequest.of(Integer.parseInt(DEFAULT_PAGE), Integer.parseInt(DEFAULT_SIZE)))).thenReturn(expected);

        String actual = mockMvc.perform(get("/api/goods/{storeId}", 1L))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals(objectMapper.writeValueAsString(expected), actual);
    }

    @SneakyThrows
    @Test
    void getById_whenProductFound_thenReturnDtoAndStatusOk() {
        ProductDto expected = productDto;
        when(service.readById(1L, productDto.id())).thenReturn(expected);

        String actual = mockMvc.perform(get("/api/goods/{storeId}/{id}", 1L, productDto.id()))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals(objectMapper.writeValueAsString(expected), actual);

    }

    @SneakyThrows
    @Test
    void sellProduct_whenOperationInServiceDone_thenReturnStringAndStatusAccepted() {
        String expected = SELL_MESSAGE;

        String actual = mockMvc.perform(patch("/api/goods/{storeId}/{id}", 1L, productDto.id())
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(productDto)))
                .andExpect(status().isAccepted())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals(expected, actual);
    }

    @SneakyThrows
    @Test
    void sellProduct_whenIncorrectMethod_thenStatusBadRequest() {
        mockMvc.perform(post("/api/goods/{storeId}/{id}", 1L, productDto.id())
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(productDto)))
                .andExpect(status().isMethodNotAllowed());
    }
}