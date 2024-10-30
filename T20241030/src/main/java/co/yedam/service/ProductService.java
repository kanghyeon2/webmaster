package co.yedam.service;

import java.util.List;

import co.yedam.vo.ProductVO;

public interface ProductService {
	String cheeringMessage();
	String hintMessage(String remainTimeString);
	
	
	List<ProductVO> products();
	ProductVO searchProduct(String prdCode);
	List<ProductVO> stars();
}
