package ru.astondevs.goodsservice.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.astondevs.goodsservice.dto.ProductDto;
import ru.astondevs.goodsservice.exception.PriceIncorrectException;
import ru.astondevs.goodsservice.exception.ProductOutOfStockException;
import ru.astondevs.goodsservice.mapper.ProductMapper;
import ru.astondevs.goodsservice.model.Product;
import ru.astondevs.goodsservice.repository.ProductRepository;
import ru.astondevs.goodsservice.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static ru.astondevs.goodsservice.util.Constant.SELL_MESSAGE;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> readAll(Long storeId, PageRequest pageRequest) {
        return productRepository.findByStoreId(storeId, pageRequest).stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto readById(Long storeId, Long id) {
        Objects.requireNonNull(id);

        var product = productRepository.findByStoreIdAndId(storeId, id).orElseThrow(() ->
                new EntityNotFoundException("Product with id = " + id + " not found"));
        return productMapper.toDto(product);
    }

    @Override
    public ProductDto sellProduct(Long storeId, Long id, ProductDto productDto) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(productDto);
        var requestedQuantity = productDto.quantity();
        Objects.requireNonNull(requestedQuantity);

        var product = productRepository.findByStoreIdAndId(storeId, id).orElseThrow(() ->
                new EntityNotFoundException("Product with id = " + id + " not found"));

        var quantityInDataBase = product.getQuantity();
        if (quantityInDataBase <= 0) {
            throw new ProductOutOfStockException("Sorry, the product is currently out of stock.");
        } else if (requestedQuantity > quantityInDataBase) {
            throw new ProductOutOfStockException("Sorry, the remain quantity of product " + quantityInDataBase);
        }

        quantityInDataBase -= requestedQuantity;
        product.setQuantity(quantityInDataBase);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    @Override
    public Map<Long, String> sellProducts(Long storeId, List<ProductDto> productsDto) {
        Map<Long, String> sellingStatus = new HashMap<>();
        String message = null;
        for (ProductDto dto : productsDto) {
            ProductDto savedProduct = null;
            try {
                savedProduct = sellProduct(storeId, dto.id(), dto);
            } catch (ProductOutOfStockException | PriceIncorrectException | EntityNotFoundException e) {
                message = e.getMessage();
            }
            if (savedProduct != null) {
                sellingStatus.put(dto.id(), SELL_MESSAGE);
            } else {
                sellingStatus.put(dto.id(), message);
            }
        }
        return sellingStatus;
    }
}
