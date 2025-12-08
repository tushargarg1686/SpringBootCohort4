package com.springbootlearning.jpatutorial.repository;

import com.springbootlearning.jpatutorial.entities.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepsository extends JpaRepository<Product, Long> {

    Optional<Product> findByTitleLike(String title);

    List<Product> findByOrderByPrice();

    List<Product> findByTitleOrderByPrice(String title);

    //List<Product> getSortedData(Sort sortBy);

    List<Product> findBy(Sort sortBy);

    List<Product> findByTitleContainingIgnoreCase(String title, PageRequest of);
}
