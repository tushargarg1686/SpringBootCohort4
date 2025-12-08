package com.springbootlearning.jpatutorial.controller;

import com.springbootlearning.jpatutorial.entities.Product;
import com.springbootlearning.jpatutorial.repository.ProductRepsository;
import jakarta.persistence.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/api/products")
public class ProductController {

    private final int PAGE_SIZE = 5;

    private final ProductRepsository productRepsository;

    public ProductController(ProductRepsository productRepsository) {
        this.productRepsository = productRepsository;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepsository.findByOrderByPrice();
    }

    @GetMapping("/sort")
    public List<Product> getAllProductsBySort(@RequestParam(defaultValue = "id") String sortBy) {
        //return productRepsository.findBy(Sort.by(Sort.Direction.DESC, sortBy));
        return productRepsository.findBy(Sort.by(Sort.Direction.ASC, sortBy, "title"));
    }

    @GetMapping("/pagination")
    public Page<Product> getAllProductsByPagination(
            @RequestParam(defaultValue = "1") Integer pageNumber,
            @RequestParam(defaultValue = "id") String sortBy) {
        Pageable pageable = PageRequest.of(
                pageNumber,
                PAGE_SIZE,
                Sort.by(sortBy));
        return productRepsository.findAll(pageable);
    }

    @GetMapping("/sortedProducts")
    public List<Product> getAllProductsByTitle(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "0") Integer pageNumber) {

        return productRepsository.findByTitleContainingIgnoreCase(
                title,
                PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy)));
    }
}
