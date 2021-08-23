package poly.sof306.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
	private Integer productId;
	private String name;
	private double price;
	private int qty=1;
}
