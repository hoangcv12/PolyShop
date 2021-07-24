package poly.sof306.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.sof306.entity.Product;
import poly.sof306.service.ProductSevrice;

@Controller
public class ProductController {
	@Autowired
	ProductSevrice productSer;

	@RequestMapping("product/list")
	public String list(Model model, @RequestParam("cid") Optional<String> cid) {
		if(cid.isPresent()) {
			List<Product> list = productSer.findCategoryById(cid.get());
			model.addAttribute("items", list);
		}else {
			List<Product> list = productSer.findAll();
			model.addAttribute("items", list);
		}
		
		return "product/list";
	}

	@RequestMapping("product/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product items = productSer.findById(id);
		
		List<Product> ListPro =items.getCategory().getProducts();
		List<Product> ListPro1=ListPro.stream()
				.filter(pro ->  pro.getId() != id)
				.collect(Collectors.toList());
		
		model.addAttribute("items", items);
		model.addAttribute("ListPro", ListPro1);
		return "product/detail";
	}
}
