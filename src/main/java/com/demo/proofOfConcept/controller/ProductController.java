package com.demo.proofOfConcept.controller;

import com.demo.proofOfConcept.dto.Product;
import com.demo.proofOfConcept.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public Flux<Product> getAll(){
        return productService.getAll();
    }

//    @GetMapping
//    public Mono<String> hello(){
//        return Mono.just("Hello World");
//    }
}
