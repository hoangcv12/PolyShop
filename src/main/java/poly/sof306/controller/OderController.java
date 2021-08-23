package poly.sof306.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.sof306.service.ShoppingCartService;

@Controller
public class OderController {
	@Autowired
	ShoppingCartService  cartitem;
@RequestMapping("order/checkout")
public String checkout(Model model) {
	model.addAttribute("cart", cartitem.getAllcart() );
	model.addAttribute("total", cartitem.getAmount() );
	return "order/checkout";
}
@RequestMapping("order/list")
public String list() {
	return "order/list";
}
@RequestMapping("order/detail/{id}")
public String detail() {
	return "order/detail";
}
}
