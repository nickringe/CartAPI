package co.grandcircus.Unit9Lab1;

public class ItemNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ItemNotFoundException(String id) {
		super("Could not find item with id " + id);
	}

}
