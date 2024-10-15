package itemMania;

public class Review {

	private String itemname;
	private String review;

	public Review (String itemname, String review) {
		this.itemname = itemname;
		this.review = review;
	}
	
	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

}
