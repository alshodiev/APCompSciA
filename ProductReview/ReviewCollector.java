import java.util.Arrays;
import java.util.ArrayList;

public class ReviewCollector {
	private ArrayList<ProductReview> reviewList;
	private ArrayList<String> productList;

  /** Constructs a ReviewCollector object and initializes the instance variables. */
	public ReviewCollector() {
		reviewList = new ArrayList<ProductReview>();
		productList = new ArrayList<String>();
	}

  /** Adds a new review to the collection of reviews, as described in part (a). */
	public void addReview(ProductReview prodReview) { 
		reviewList.add(prodReview);
  	boolean flag = true;
  	for(String name: productList)
  		if(name.equals(prodReview.getName()))
  			flag = false;
  	if(flag)
  		productList.add(prodReview.getName());
	}

  /** Returns the number of good reviews for a given product name, as described in part (b). */
	public int getNumGoodReviews(String prodName) { 
		int count = 0;
  	for(ProductReview review: reviewList)
  		if(review.getName().equals(prodName) && review.getReview().indexOf("best") != -1)
  			count++;
    return count;
 	}

  public void print() {
    for(ProductReview test: reviewList)
      System.out.println("Name: " + test.getName() + " - Review: " + test.getReview());
    System.out.println();
    System.out.println(Arrays.toString(productList.toArray()));
  }
  
  // There may be instance variables, constructors, and methods not shown.
}