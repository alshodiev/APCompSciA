public class ProductReview {
	private String name;
	private String review;

  /** Constructs a ProductReview object and initializes the instance variables. */
	public ProductReview(String pName, String pReview) {
		name = pName;
		review = pReview;
	}

 	/** Returns the name of the product. */
	public String getName() { 
		return name; 
	}

  /** Returns the review of the product. */
	public String getReview() { 
		return review; 
	}
}