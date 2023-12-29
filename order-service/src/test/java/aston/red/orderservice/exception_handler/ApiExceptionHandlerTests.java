package aston.red.orderservice.exception_handler;

import aston.red.orderservice.controller.OrderController;
import aston.red.orderservice.exception.OrderNotFoundException;
import aston.red.orderservice.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ApiExceptionHandler.class)
public class ApiExceptionHandlerTests {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private OrderService orderService;

    @Test
    public void testHandleOrderNotFoundException() throws Exception {
        long orderId = 123L;

        doThrow(new OrderNotFoundException(String.valueOf(orderId))).when(orderService).postDeliveryOrder(orderId);

        mockMvc.perform(get("/order/{orderId}", orderId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(print());
    }
}