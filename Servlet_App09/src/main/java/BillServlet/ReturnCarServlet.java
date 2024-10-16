package BillServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import BillBeanClass.BillBean;
import BillDAO.UpdateBillStatus;
import InfoCarDAO.ReturnCarAvaility;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/ReturnRentedCar")
public class ReturnCarServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs = req.getSession(false);
		if (hs == null) {

		} else {
			String carNumber = (req.getParameter("CarNumber"));
			ArrayList<BillBean> bb = (ArrayList<BillBean>) hs.getAttribute("ShowBill");

			Iterator<BillBean> it = bb.iterator();

			while (it.hasNext()) {
				BillBean billBean = it.next();

				if (carNumber.equals(billBean.getCarNumber())) {
					int k = new ReturnCarAvaility().returnCarAvaility(carNumber);
					int u = new UpdateBillStatus().updateBillStatus(billBean);
					if (k > 0 && u > 0) {
						req.setAttribute("msg", "Car Return Successfully..");
						req.getRequestDispatcher("ReturnSuccess.jsp").forward(req, res);
					}
				}

			}
		}

	}

}
