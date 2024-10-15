package itemMania;

public class Purchase {
	private String itemname;
	private String purchaseDate;
	private int quantity;
    private int totalPrice;
    
    public Purchase(String itemname, String purchasedate, int quantity, int totalprice) {
        this.itemname = itemname;
        this.purchaseDate = purchasedate;
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
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
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
	
	
	@Override
	public String toString() {
		return "아이템명 : " + getItemname() +"\n구매수량 : " + getQuantity()+"개" +"\n결제금액 : "+ getTotalPrice()+"원" + "\n구매날짜 : " +  getPurchaseDate() ;
	}
}
