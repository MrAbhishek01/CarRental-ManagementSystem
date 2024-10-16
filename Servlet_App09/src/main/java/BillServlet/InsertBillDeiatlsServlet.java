package BillServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import BillBeanClass.BillBean;
import BillDAO.BillDAO;
import CustomerBean.CustomerBean;
import InfoCarBean.CarBean;
import InfoCarDAO.RentCarAvaility;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/insertBill")
public class InsertBillDeiatlsServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs = req.getSession(false);

		if (hs == null) {

		} else {

			ArrayList<CarBean> carBean = (ArrayList<CarBean>) hs.getAttribute("al");
			BillBean bb = (BillBean) hs.getAttribute("bill");
			CustomerBean cb = (CustomerBean) hs.getAttribute("cbean");

			String carNumber = req.getParameter("carNumber");

			Iterator<CarBean> it = carBean.iterator();

			while (it.hasNext()) {
				CarBean cardetails = (CarBean) it.next();

				if (cardetails.getCarNumber().equals(carNumber)) {

					int k = new BillDAO().insertbill(cb, cardetails, bb);
					int u = new RentCarAvaility().rentedCarAvaility(cardetails);
					
					if (k > 0 && u > 0) {

						req.setAttribute("msg", "Car Rented Successfully");
						req.getRequestDispatcher("RentedSucceed.jsp").forward(req, res);
					}
					break;
				}

			}

		}

	}

}
