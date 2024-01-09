package com.demo.proofOfConcept.service;

import com.demo.proofOfConcept.dto.Product;
import io.micrometer.core.annotation.Timed;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductService {

    @Timed("product.service.getAll")
    public Flux<Product> getAll() {
        Product p1 = new Product(1, "Product one", 5F);
        Product p2 = new Product(2, "Product two", 6F);

        Flux<Product> products = Flux.just(p1, p2);

        return products;
    }
}
