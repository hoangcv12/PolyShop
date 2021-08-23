package poly.sof306.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poly.sof306.entity.Categories;
import poly.sof306.service.CategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping("categorys")
public class category {
	@Autowired
	CategoryService cateservice;
@GetMapping("")
public List<Categories> getAll(){
	return cateservice.findAll();
}
@GetMapping("/{id}")
public Categories findById(@PathVariable("id") String id) {
	return cateservice.findById(id);
}
@GetMapping("page")
public Page<Categories> getAllpage(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit){
	Pageable pageable = PageRequest.of(page, limit);
	return cateservice.findAll(pageable);
}
}
