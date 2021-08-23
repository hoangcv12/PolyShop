package poly.sof306.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import poly.sof306.entity.Product;

public interface ProductSevrice {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findCategoryById(String cid);

	Page<Product> findAll(Pageable pageable);

	Product create(Product product);

	void delete(Integer id);

	Product getById(Integer id);

	Product update(Product product);



	
	
	

}
