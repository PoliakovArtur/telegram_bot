package aston.red.storeservice.mapper;

import aston.red.storeservice.dto.StoreDto;
import aston.red.storeservice.dto.StoreToOrderDto;
import aston.red.storeservice.model.Store;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StoreMapperTest {
    private final StoreMapper storeMapper = Mappers.getMapper(StoreMapper.class);

    @Test
    public void testFromAllStoreToAllDto() {
        Store store = new Store();
        store.setPhone("1234567890");

        List<Store> storeList = Collections.singletonList(store);
        List<StoreDto> storeDtoList = storeMapper.fromAllStoreToAllDto(storeList);

        assertNotNull(storeDtoList);
        assertEquals(storeList.size(), storeDtoList.size());

        StoreDto storeDto = storeDtoList.get(0);

        assertNotNull(storeDto);
        assertEquals(store.getPhone(), storeDto.getPhoneNumber());
    }

    @Test
    public void testFromStoreToDto() {
        Store store = new Store();
        store.setPhone("1234567890");

        StoreDto storeDto = storeMapper.fromStoreToDto(store);

        assertNotNull(storeDto);
        assertEquals(store.getPhone(), storeDto.getPhoneNumber());
    }

    @Test
    public void testFromStoreToOrderService() {
        Store store = new Store();

        StoreToOrderDto storeToOrderDto = storeMapper.fromStoreToOrderService(store);

        assertNotNull(storeToOrderDto);
    }
}
