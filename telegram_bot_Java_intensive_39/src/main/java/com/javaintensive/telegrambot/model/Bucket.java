package com.javaintensive.telegrambot.model;

import com.javaintensive.telegrambot.model.Product;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bucket {

    private Map<Long, Product> bucket;

    private final Long storeId;

    public Bucket(Long storeId, List<Product> products) {
        this.storeId = storeId;
        bucket = new HashMap<>();
        for(Product product : products) {
            bucket.put(product.getId(), product);
        }
    }

    public void add(Long productId) {
        Product product = bucket.get(productId);
        Integer limitQuantity = product.getLimitQuantity();
        Integer quantity = product.getQuantity();
        if(quantity + 1 <= limitQuantity)
            product.setQuantity(quantity + 1);
    }

    public void remove(Long productId) {
        Product product = bucket.get(productId);
        Integer quantity = product.getQuantity();
        if(quantity > 0)
            product.setQuantity(quantity - 1);
    }

    public Collection<Product> getProducts() {
        return Collections.unmodifiableCollection(bucket.values());
    }

    public Long getStoreId() {
        return storeId;
    }
}
