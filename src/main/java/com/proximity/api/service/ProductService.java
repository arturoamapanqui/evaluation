package com.proximity.api.service;

import java.util.List;

import com.proximity.api.bean.Product;

public interface ProductService {

	Product getProductById(Long productId);

	List<Product> getAllProducts();

	Product save(Product product);

	Product update(Product product);

	Product delete(Long productId);

}
