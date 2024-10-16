package BillServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import InfoCarBean.CarBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/BookServlet")
public class BillCheckServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);

		if (hs == null) {

		} else {
			String carNumber = req.getParameter("carNumber");
			ArrayList<CarBean> al = (ArrayList<CarBean>) hs.getAttribute("al");
			Iterator<CarBean> it = al.iterator();
			while (it.hasNext()) {

				CarBean carbean = (CarBean) it.next();
				if (carNumber.equals(carbean.getCarNumber())) {
					
					hs.setAttribute("car", carbean);
					req.getRequestDispatcher("RentOrBookCar.jsp").forward(req, res);;
				}
			}

		}
	}

}
