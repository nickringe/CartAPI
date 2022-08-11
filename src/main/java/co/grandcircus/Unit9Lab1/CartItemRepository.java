package co.grandcircus.Unit9Lab1;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartItemRepository extends MongoRepository<CartItem, String>{
	
	List<CartItem> findByProduct(String product);
	//List<CartItem> findByMaxPrice(Double maxPrice);
}
