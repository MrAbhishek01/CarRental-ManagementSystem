package BillServlet;

import java.io.IOException;
import java.util.ArrayList;

import BillBeanClass.BillBean;
import BillDAO.ReturnBill;
import CustomerBean.CustomerBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/CarReturn")
public class ShowBillForReturnCarServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs = req.getSession(false);
		if (hs == null) {

		} else {
			CustomerBean cb = (CustomerBean) hs.getAttribute("cbean");
			ArrayList<BillBean> bill = new ReturnBill().returnBill(cb);
			hs.setAttribute("ShowBill", bill);
			req.getRequestDispatcher("ShowBillForReturnCar.jsp").forward(req, res);

		}

	}

}
