package poly.sof306.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import poly.sof306.entity.Categories;

public interface CategoryService {

	List<Categories> findAll();

	Categories findById(String id);

	Page<Categories> findAll(Pageable pageable);

}
