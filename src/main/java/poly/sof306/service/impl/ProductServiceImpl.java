package poly.sof306.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.sof306.dao.ProductDAO;
import poly.sof306.entity.Product;
import poly.sof306.service.ProductSevrice;

@Service
public class ProductServiceImpl implements ProductSevrice{
@Autowired
ProductDAO pdao;

@Override
public List<Product> findAll() {
	
	return pdao.findAll();
}

@Override
public Product findById(Integer id) {
	// TODO Auto-generated method stub
	return pdao.findById(id).get();
}

@Override
public List<Product> findCategoryById(String cid) {
	// TODO Auto-generated method stub
	return pdao.findCategoryById(cid);
}


}
