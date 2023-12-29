package ru.astondevs.goodsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.astondevs.goodsservice.dto.ProductDto;
import ru.astondevs.goodsservice.service.ProductService;

import java.util.List;
import java.util.Map;

import static ru.astondevs.goodsservice.util.Constant.DEFAULT_PAGE;
import static ru.astondevs.goodsservice.util.Constant.DEFAULT_SIZE;
import static ru.astondevs.goodsservice.util.Constant.SELL_MESSAGE;

@RestController
@RequestMapping("/api/goods/")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<?> getAll(@PathVariable("storeId") Long storeId,
                                    @RequestParam(required = false, defaultValue = DEFAULT_PAGE) int page,
                                    @RequestParam(required = false, defaultValue = DEFAULT_SIZE) int size) {
        return ResponseEntity.ok(productService.readAll(storeId, PageRequest.of(page, size)));
    }

    @GetMapping("/{storeId}/{id}")
    public ResponseEntity<?> getById(@PathVariable("storeId") Long storeId,
                                     @PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.readById(storeId, id));
    }

    @PatchMapping("/{storeId}/{id}")
    public ResponseEntity<?> sellProduct(@PathVariable("storeId") Long storeId,
                                         @PathVariable("id") Long id, @RequestBody ProductDto dto) {
        productService.sellProduct(storeId, id, dto);
        return ResponseEntity.accepted().body(SELL_MESSAGE);
    }

    @PatchMapping("/{storeId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<Long, String> sellProducts(@PathVariable("storeId") Long storeId,
                                            @RequestBody List<ProductDto> dtos) {
        return productService.sellProducts(storeId, dtos);
    }
}
