class Main {
  public static void main(String[] args) {
    ProductReview goodreview1 = new ProductReview("Toy Tank", "Woah, best toy tank");
    ProductReview goodreview2 = new ProductReview("Toy Tank", "Amazing asbestos tank");
    ProductReview review3 = new ProductReview("Toy Tank", "good tank. Probably BEST");
    
    ProductReview review_d = new ProductReview("Ur a wizward hary", "a what");
    ProductReview review_d1 = new ProductReview("Game", "great");
    ProductReview review_d2 = new ProductReview("Stock Market", "great");
    ProductReview review_d3 = new ProductReview("Free Dobby", "awesome");

    ReviewCollector collector = new ReviewCollector();
    collector.addReview(goodreview1);
    collector.addReview(goodreview2);
    collector.addReview(review3);
    collector.addReview(review_d);
    collector.addReview(review_d1);
    collector.addReview(review_d2);
    collector.addReview(review_d3);

    System.out.println();
    System.out.println("Out of 3 reviews for \"Toy Tank\", there are " + collector.getNumGoodReviews("Toy Tank") + " good reviews.");

    System.out.println();
    collector.print();
  }
}