package poly.sof306.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.sof306.dao.CategoryDAO;
import poly.sof306.dao.ProductDAO;
import poly.sof306.entity.Categories;
import poly.sof306.entity.Product;
import poly.sof306.service.CategoryService;
import poly.sof306.service.ProductSevrice;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDAO cate;

	@Override
	public List<Categories> findAll() {
		
		return cate.findAll();
	}




}
