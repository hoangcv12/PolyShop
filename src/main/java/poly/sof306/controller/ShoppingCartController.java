package poly.sof306.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.sof306.entity.CartItem;
import poly.sof306.entity.Product;
import poly.sof306.service.ProductSevrice;
import poly.sof306.service.ShoppingCartService;

@Controller
public class ShoppingCartController {
	
	@Autowired
	ProductSevrice productSer;
	@Autowired
	ShoppingCartService  cartitem;
	@Autowired
	HttpServletRequest request;
	
	
	@RequestMapping("cart/view")
	public String list( Model model,HttpServletResponse response) {
		model.addAttribute("cart", cartitem.getAllcart() );
		model.addAttribute("total", cartitem.getAmount() );
		return "cart/view";
	}
	
	@GetMapping("addcart/{id}")
	public String add(@PathVariable("id") Integer id ) {
		
		Product pro = productSer.findById(id);
		if(pro != null  ) {
			CartItem item = new CartItem();
			item.setProductId(pro.getId());
			item.setName(pro.getName());
			item.setPrice(pro.getPrice());
			item.setQty(1);
			cartitem.add(item); 
		}
		return "redirect:/cart/view";
	}
	
	@PostMapping("updatecart")
	public String update(
			@RequestParam("id") Integer id,
			@RequestParam("qty") Integer qty
			) {
		cartitem.update(id, qty);
		return "redirect:/cart/view";
	}
	@GetMapping("delcart/{id}")
	public String removeCart(@PathVariable("id") Integer id) {
		cartitem.remove(id);
		return  "redirect:/cart/view";
	}
	
	@GetMapping("clearcart")
	public String clear() {
		cartitem.clear();
		return  "redirect:/cart/view";
	}
}
