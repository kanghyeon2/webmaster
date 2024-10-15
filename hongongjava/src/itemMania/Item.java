package itemMania;

public class Item {
	private String itemname;	
	private String game;
	private String server;
	private int price;
	private int num;
	private String registrationdate;
	
	public Item() {}	;
	public Item(String itemname, String game, int price, String server, int num) {
		this.itemname = itemname;
		this.game = game;
		this.price = price;
		this.server = server;	
		this.num = num;
//		this.registrationdate = registrationdate;
	}
	
	
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getGame() {
		return game;
	}
	public void setGame(String game) {
		this.game = game;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getRegistrationdate() {
		return registrationdate;
	}
	public void setRegistrationdate(String registrationdate) {
		this.registrationdate = registrationdate;
	}
}
