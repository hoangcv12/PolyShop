package poly.sof306.service;

import java.util.Collection;

import poly.sof306.entity.CartItem;

public interface ShoppingCartService {
	void add(CartItem items);
	void remove(int id);
	void clear();
	double getAmount();
	Collection<CartItem> getAllcart();
	CartItem update(int Proid, int qty);
}
