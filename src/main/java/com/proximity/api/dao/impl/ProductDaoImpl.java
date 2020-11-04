package com.proximity.api.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.proximity.api.bean.Product;
import com.proximity.api.dao.ProductDao;
import com.proximity.api.mapper.ProductMapper;

@Component
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	private final String QUERY_PRODUCT_BY_ID = "select id, name, cost from proximity_product where id = ?";
	
	private final String QUERY_PRODUCT = "select id, name, cost from proximity_product";
	
	private final String SAVE_PRODUCT = "insert into proximity_product (name, cost) values (?,?)";
	
	private final String UPDATE_PRODUCT = "update proximity_product set name = ?, cost = ? where id = ?";
	
	private final String DELETE_PRODUCT = "delete from proximity_product where id = ?";
	
	@Override
	public Product getProductById(Long productId) {
		return jdbcTemplate.queryForObject(QUERY_PRODUCT_BY_ID, new Object[]{productId},new ProductMapper());
	}

	@Override
	public List<Product> getAllProducts() {
		return jdbcTemplate.query(QUERY_PRODUCT, new Object[]{},new ProductMapper());
	}

	@Override
	public Product save(Product product) {
		int result = jdbcTemplate.update(SAVE_PRODUCT, new Object[]{product.getName(), product.getCost()});
		return result == 1 ? product : null;
	}

	@Override
	public Product update(Product product) {
		int result = jdbcTemplate.update(UPDATE_PRODUCT, new Object[]{product.getName(), product.getCost(), product.getId()});
		return result == 1 ? product : null;
	}

	@Override
	public Product delete(Long productId) {
		int result = jdbcTemplate.update(DELETE_PRODUCT, new Object[]{productId});
		return result == 1 ? new Product(): null;
	}

}
