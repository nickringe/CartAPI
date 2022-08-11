package co.grandcircus.Unit9Lab1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartItemController {
	
	@Autowired
	private CartItemRepository cartRepo;
	
	//Just testing/learning...
//	@GetMapping("/test")
//	public String test() {
//		CartItem cI = new CartItem("Dish soap", 5.99, 2);
//		cartRepo.insert(cI);
//		return "test complete";
//	}
	
	//http://localhost:8080/cart-items/?product=Dish soap
	@GetMapping("/cart-items")
	public List<CartItem> displayAllCartItems(@RequestParam(required=false) String product) {
		if(product != null) {
			return cartRepo.findByProduct(product);
		} else {
		return cartRepo.findAll();
		}
	}
	
	@GetMapping("/cart-items/{id}")
	public CartItem displayCartItemById(@PathVariable("id") String id) {
		return cartRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
	}
	
	@PostMapping("/cart-items")
	@ResponseStatus(HttpStatus.CREATED)
	public CartItem addCartItem(@RequestBody CartItem cartItem) {
		cartRepo.insert(cartItem);
		return cartItem;
	}
	
	@PutMapping("/cart-items/{id}")
	public CartItem updateCartItem(@RequestBody CartItem cartItem, @PathVariable("id") String id) {
		cartItem.setId(id);
		return cartRepo.save(cartItem);
	}
	
	@DeleteMapping("cart-items/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String deleteCartItem(@PathVariable("id") String id) {
		cartRepo.deleteById(id);
		return "Successfully deleted id " + id;
	}
	
	@GetMapping("cart-items/total-cost")
	public Double cartTotal() {
		List<CartItem> cartList = cartRepo.findAll();
		Double total = 0.00;
		for (CartItem c : cartList) {
			total += c.getPrice() * c.getQuantity();
		}
		Double afterTax = total*1.06;
		return afterTax;
	}
	
	//http://localhost:8080/cart-items/62f1bad8cd0487018317d536/add?count=2
	@PatchMapping("/cart-items/{id}/add")
	public CartItem updateCartQuantity(@RequestBody CartItem cartItem, @PathVariable("id") String id, Integer count) {
		cartItem.setQuantity(cartItem.getQuantity()+ count);
		return cartRepo.save(cartItem);
	}

}
