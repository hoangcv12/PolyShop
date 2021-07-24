package poly.sof306.service;

import java.util.List;

import poly.sof306.entity.Product;

public interface ProductSevrice {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findCategoryById(String cid);

	
	
	

}
