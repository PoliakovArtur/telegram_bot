package aston.red.storeservice.feign;

import aston.red.storeservice.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
@ExtendWith(MockitoExtension.class)
public class GoodsFeignTest {
    @Mock
    private GoodsFeignClient goodsFeignClient;

    @Test
    public void testGetAllGoodsFromStore() {
        long storeId = 123L;
        List<ProductDto> productDtos = new ArrayList<>();

        when(goodsFeignClient.getAllGoodsFromStore(storeId)).thenReturn(productDtos);

        List<ProductDto> result = goodsFeignClient.getAllGoodsFromStore(storeId);

        verify(goodsFeignClient, times(1)).getAllGoodsFromStore(storeId);
        assertNotNull(result);
    }

    @Test
    public void testGetGoodFromStore() {
        long storeId = 123L;
        long goodId = 456L;
        ProductDto productDto = ProductDto.builder().build();

        when(goodsFeignClient.getGoodFromStore(storeId, goodId)).thenReturn(productDto);

        ProductDto result = goodsFeignClient.getGoodFromStore(storeId, goodId);

        verify(goodsFeignClient, times(1)).getGoodFromStore(storeId, goodId);
        assertNotNull(result);
    }
}
