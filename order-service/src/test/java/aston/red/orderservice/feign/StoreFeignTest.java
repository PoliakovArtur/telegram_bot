package aston.red.orderservice.feign;

import aston.red.orderservice.dto.StoreDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
@ExtendWith(MockitoExtension.class)
public class StoreFeignTest {

    private final StoreFeign storeFeign = Mockito.mock(StoreFeign.class);

    @Test
    public void testGetById() {
        long storeId = 123L;

        StoreDto storeDto = StoreDto.builder()
                .id(storeId)
                .build();

        when(storeFeign.getById(storeId)).thenReturn(storeDto);
        storeFeign.getById(storeId);

        verify(storeFeign, times(1)).getById(anyLong());
        assertNotNull(storeDto.getId());
    }
}
