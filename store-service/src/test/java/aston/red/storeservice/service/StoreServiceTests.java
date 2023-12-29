package aston.red.storeservice.service;

import aston.red.storeservice.exception.NotFoundStoreException;
import aston.red.storeservice.model.Store;
import aston.red.storeservice.repository.StoreRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StoreServiceTests {
    @InjectMocks
    private StoreService storeService;
    @Mock
    private StoreRepository storeRepository;

    @Test
    void testGetAll() {
        List<Store> stores = new ArrayList<>();

        when(storeRepository.findAll()).thenReturn(stores);

        List<Store> result = storeService.getAll();

        assertNotNull(result);
        assertEquals(stores, result);

        verify(storeRepository).findAll();
    }

    @Test
    void testGetById_StoreExists() {
        long storeId = 1L;

        Store store = new Store();

        when(storeRepository.findById(storeId)).thenReturn(Optional.of(store));

        Store result = storeService.getById(storeId);

        assertNotNull(result);
        assertEquals(store, result);

        verify(storeRepository).findById(storeId);
    }

    @Test
    void testGetById_StoreDoesNotExist() {
        long storeId = 100L;

        when(storeRepository.findById(storeId)).thenReturn(Optional.empty());

        assertThrows(NotFoundStoreException.class, () -> storeService.getById(storeId));

        verify(storeRepository).findById(storeId);
    }
}
