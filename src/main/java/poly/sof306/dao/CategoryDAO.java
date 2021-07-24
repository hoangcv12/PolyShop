package poly.sof306.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.sof306.entity.Categories;

public interface  CategoryDAO extends JpaRepository<Categories, String> {

}
