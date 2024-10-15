package itemMania;

public class Purchase {
	private int purchaseid;
	private String itemname;
	private String purchasedate;
	private int quantity;
	private int totalPrice;

	public Purchase(int purchaseid, String itemname, String purchasedate, int quantity, int totalprice) {
		this.purchaseid = purchaseid;
		this.itemname = itemname;
		this.purchasedate = purchasedate;
		this.quantity = quantity;
		this.totalPrice = totalprice;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getPurchaseDate() {
		return purchasedate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchasedate = purchaseDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getPurchaseid() {
		return purchaseid;
	}

	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
	}

	@Override
	public String toString() {
		return getPurchaseid() + " 아이템명 : " + getItemname() + "\t구매수량 : " + getQuantity() + "개" + "\t결제금액 : "
				+ getTotalPrice() + "원" + "\t구매날짜 : " + getPurchaseDate();
	}
}
