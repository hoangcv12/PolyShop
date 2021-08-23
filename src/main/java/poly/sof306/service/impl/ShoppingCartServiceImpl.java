package poly.sof306.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import poly.sof306.entity.CartItem;
import poly.sof306.service.ShoppingCartService;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	Map<Integer, CartItem> maps = new HashMap<>();
	@Override
	public void add(CartItem items) {
		CartItem cartItem = maps.get(items.getProductId());
		if(cartItem == null) {
			maps.put(items.getProductId(), items);
		}
		else {
			cartItem.setQty(cartItem.getQty()+1);
		}
	}
	@Override
	public Collection<CartItem> getAllcart() {
		return maps.values();
	}
	@Override
	public CartItem update(int Proid, int qty) {
		CartItem cartitem = maps.get(Proid);
		
		cartitem.setQty(qty);
		return cartitem;
	}
	@Override
	public void remove(int id) {
		maps.remove(id);
		
	}
	@Override
	public void clear() {
		maps.clear();
	}
	@Override
	public double getAmount() {
		return maps.values().stream().mapToDouble(item -> item.getQty() * item.getPrice()).sum();
	}
	
	
}
