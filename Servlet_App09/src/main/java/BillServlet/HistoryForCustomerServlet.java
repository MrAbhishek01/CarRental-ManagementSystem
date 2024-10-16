package BillServlet;

import java.io.IOException;
import java.util.ArrayList;

import BillBeanClass.BillBean;
import BillDAO.HistoryForCustomer;
import CustomerBean.CustomerBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/checkallHistory")
public class HistoryForCustomerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired..");
			req.getRequestDispatcher("Massage.jsp");
		} else {

			CustomerBean cb = (CustomerBean) hs.getAttribute("cbean");
			ArrayList<BillBean> cHistory = new HistoryForCustomer().returnBill(cb);
			hs.setAttribute("bl", cHistory);
			req.getRequestDispatcher("ReturnedAndRentedHistoryForCustomer.jsp").forward(req, res);

		}
	}

}
