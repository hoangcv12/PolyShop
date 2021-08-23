package poly.sof306.restcontroller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poly.sof306.dao.AuthoritiesDao;
import poly.sof306.entity.Account;
import poly.sof306.entity.Authorities;
import poly.sof306.entity.Product;
import poly.sof306.service.AuthService;
import poly.sof306.service.ProductSevrice;

@CrossOrigin("*")
@RestController
@RequestMapping("/products")
public class prodcuts {
	@Autowired
	ProductSevrice proservice;
	
	@GetMapping("getall")
	public List<Product> getAll() {
		return proservice.findAll();
	}

	@GetMapping("/page")
	public Page<Product> page(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
		Pageable pageable = PageRequest.of(page, limit);
		return proservice.findAll(pageable);
	}

	@PostMapping("add")
	public Product create(@RequestBody Product product) {
		return proservice.create(product);
	}
	
	@PutMapping("update")
	public Product update(@RequestBody Product product) {
		return proservice.update(product);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		proservice.delete(id);
	}

	@GetMapping("/{id}")
	public Product getById(@PathVariable("id") Integer id) {
		return proservice.getById(id);
	}
	
}
