package com.proximity.api.dao;

import java.util.List;
import com.proximity.api.bean.Product;

public interface ProductDao {

	public Product getProductById(Long productId);

	public List<Product> getAllProducts();

	public Product save(Product product);

	public Product update(Product product);

	public Product delete(Long productId);

}
