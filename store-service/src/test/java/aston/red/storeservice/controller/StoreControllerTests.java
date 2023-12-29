package aston.red.storeservice.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import aston.red.storeservice.dto.ProductDto;
import aston.red.storeservice.dto.StoreDto;
import aston.red.storeservice.dto.StoreToOrderDto;
import aston.red.storeservice.feign.GoodsFeignClient;
import aston.red.storeservice.mapper.StoreMapper;
import aston.red.storeservice.model.Store;
import aston.red.storeservice.service.StoreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class StoreControllerTests {
    private MockMvc mockMvc;

    @InjectMocks
    private StoreController storeController;
    @Mock
    private StoreService storeService;
    @Mock
    private GoodsFeignClient goodsFeignClient;
    @Mock
    private StoreMapper storeMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(storeController).build();
    }

    @Test
    void testGetAllStores() throws Exception {
        List<Store> stores = new ArrayList<>();
        List<StoreDto> storeDtos = new ArrayList<>();

        when(storeService.getAll()).thenReturn(stores);
        when(storeMapper.fromAllStoreToAllDto(stores)).thenReturn(storeDtos);

        mockMvc.perform(get("/store")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andReturn();

        verify(storeService).getAll();
    }

    @Test
    void testGetByIdWithAllProducts() throws Exception {
        long storeId = 1L;
        List<ProductDto> productDtos = new ArrayList<>();

        when(goodsFeignClient.getAllGoodsFromStore(storeId)).thenReturn(productDtos);

        mockMvc.perform(get("/store/{storeId}", storeId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andReturn();

        verify(goodsFeignClient).getAllGoodsFromStore(storeId);
    }

    @Test
    void testGetByIdWithProduct() throws Exception {
        long storeId = 1L;
        long productId = 123L;

        ProductDto productDto = ProductDto.builder().build();

        when(goodsFeignClient.getGoodFromStore(storeId, productId)).thenReturn(productDto);

        mockMvc.perform(get("/store/{storeId}/{productId}", storeId, productId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(goodsFeignClient).getGoodFromStore(storeId, productId);
    }

    @Test
    void testGetToOrderService() throws Exception {
        long storeId = 1L;

        StoreToOrderDto storeToOrderDto = new StoreToOrderDto();
        Store store = new Store();

        when(storeService.getById(storeId)).thenReturn(new Store());
        when(storeMapper.fromStoreToOrderService(store)).thenReturn(storeToOrderDto);

        mockMvc.perform(get("/store/transfer/{storeId}", storeId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(storeService).getById(storeId);
    }
}