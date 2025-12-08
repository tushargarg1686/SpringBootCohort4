package com.springbootlearning.jpatutorial;

import com.springbootlearning.jpatutorial.entities.Product;
import com.springbootlearning.jpatutorial.repository.ProductRepsository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpatutorialApplicationTests {

	@Autowired
	ProductRepsository productRepsository;

	@Test
	void contextLoads() {
	}

	@Test
	public void saveAllProducts() {
		Product product = Product.builder()
				.sku("softdrink3")
				.price(BigDecimal.valueOf(10))
				.title("cocacolaaa")
				.quantity(1)
				.build();

		productRepsository.save(product);
	}

	@Test
	public void getProductById() {
		Product productEntity = productRepsository.findById(Long.valueOf(1)).orElse(null);
		System.out.println("getProductById called and product Entity is " + productEntity);
	}

	@Test
	public void findByTitleLike() {
		Optional<Product> productEntity = productRepsository.findByTitleLike("pep");
		System.out.println("findByTitleLike called and productEntity is " + productEntity);

	}

	//Sorting technique
	@Test
	public void findByTitleOrderByPrice() {
		List<Product> productEntity = productRepsository.findByOrderByPrice();
		System.out.println("findByTitleLike called and productEntity is " + productEntity);

	}
}
