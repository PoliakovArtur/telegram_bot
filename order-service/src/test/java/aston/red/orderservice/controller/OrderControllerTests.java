package aston.red.orderservice.controller;

import aston.red.orderservice.dto.OrderGoodsDto;
import aston.red.orderservice.dto.OrderPreparedToPayDto;
import aston.red.orderservice.service.OrderService;
import aston.red.orderservice.service.OrdersGoodsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class OrderControllerTests {
    private MockMvc mockMvc;
    @InjectMocks
    private OrderController orderController;
    @Mock
    private OrdersGoodsService goodsService;
    @Mock
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(orderController).build();
    }

    @Test
    void testPayedOrder() throws Exception {
        Long orderId = 123L;

        mockMvc.perform(post("/order/{orderId}", orderId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("orderId", String.valueOf(orderId))
                )
                .andExpect(status().isOk())
                .andDo(print());

        verify(orderService).postDeliveryOrder(orderId);
        verify(goodsService).patchOrdersGoodsShortsDtoByOrderId(orderId);
    }

    @Test
    void testProcessOrder() throws Exception {
        OrderGoodsDto orderGoodsDto = OrderGoodsDto.builder()
                .storeId(1L)
                .userId(1L)
                .products(new ArrayList<>())
                .build();

        OrderPreparedToPayDto preparedToPayDto = OrderPreparedToPayDto.builder()
                .orderId(12345L)
                .sum(BigDecimal.valueOf(1000))
                .build();

        when(orderService.processOrder(orderGoodsDto)).thenReturn(preparedToPayDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/order")
                        .content(asJsonString(orderGoodsDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idOrder").value("12345"))
                .andExpect(jsonPath("$.sum").value("1000"))
                .andDo(print());

        verify(orderService).processOrder(orderGoodsDto);
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
