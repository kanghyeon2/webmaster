package chap06;

public class ShopServiceMaint {

	public static void main(String[] args) {
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();
		
		if(obj1 == obj2) {
			System.out.println("동일");
		}else System.out.println("다름");
	}

}
