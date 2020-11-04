package com.proximity.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proximity.api.bean.Product;
import com.proximity.api.dao.ProductDao;
import com.proximity.api.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public Product getProductById(Long productId) {
		return productDao.getProductById(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	@Override
	public Product save(Product product) {
		return productDao.save(product);
	}

	@Override
	public Product update(Product product) {
		return productDao.update(product);
	}

	@Override
	public Product delete(Long productId) {
		return productDao.delete(productId);
	}

}
