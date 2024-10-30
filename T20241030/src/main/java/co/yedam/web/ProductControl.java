package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.ProductService;
import co.yedam.service.ProductServiceImpl;
import co.yedam.vo.ProductVO;

public class ProductControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prdCode = req.getParameter("prdCode");
		
		
		
		ProductService svc = new ProductServiceImpl();
		ProductVO product = svc.searchProduct(prdCode);
		List<ProductVO> stars= svc.stars();
		
		req.setAttribute("prd", product);
		req.setAttribute("stars", stars);
		
		req.getRequestDispatcher("productInfo.tiles").forward(req, resp);

	}

}
