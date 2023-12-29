package aston.red.storeservice.exception_handler;

import aston.red.storeservice.exception.NotFoundStoreException;
import aston.red.storeservice.service.StoreService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ApiExceptionHandler.class)
public class ApiExceptionHandlerTests {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private StoreService storeService;

    @Test
    public void testHandleNotFoundStoreException() throws Exception {
        long storeId = 123L;
        String exceptionMessage = "Store not found for ID: " + storeId;

        when(storeService.getById(storeId)).thenThrow(new NotFoundStoreException(exceptionMessage));

        mockMvc.perform(get("/store/{storeId}", storeId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }
}