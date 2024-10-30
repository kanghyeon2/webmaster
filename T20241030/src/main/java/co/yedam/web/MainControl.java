package co.yedam.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.ProductService;
import co.yedam.service.ProductServiceImpl;

public class MainControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		Date dueDate = new Date();
		dueDate.setHours(17);
		dueDate.setMinutes(50);
		dueDate.setSeconds(0);

		String remainTimeStr = "";

		try {

			long diff = dueDate.getTime() - now.getTime();
			long h = diff / (1000 * 60 * 60);
			diff -= (h * (1000 * 60 * 60));
			long m = diff / (1000 * 60);
			diff -= (m * (1000 * 60));
			long s = diff / 1000;
			remainTimeStr = h + "시간 " //
					+ ("0" + m).substring(("0" + m).length() - 2) + "분 "//
					+ ("0" + s).substring(("0" + s).length() - 2) + "초 남음.";

		} catch (Exception e) {
			e.printStackTrace();
		}

		ProductService svc = new ProductServiceImpl();
		String cheers = svc.cheeringMessage();
		String hints = svc.hintMessage(remainTimeStr);

		req.setAttribute("message", cheers);
		req.setAttribute("hint", hints);

		req.getRequestDispatcher("index.jsp")//
				.forward(req, resp);
	}

}
