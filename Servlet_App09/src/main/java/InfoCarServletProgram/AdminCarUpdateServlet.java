package InfoCarServletProgram;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import InfoCarBean.CarBean;
import InfoCarDAO.AdminUpdateCarDetailsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/updateCarDetails")
public class AdminCarUpdateServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired..<br>");
			req.getRequestDispatcher("Massage.jsp");
		} else {
			String carNumber = req.getParameter("carNumber");
			Double carPrice = Double.parseDouble(req.getParameter("carPrice"));
			String location = req.getParameter("location");
			ArrayList<CarBean> al = (ArrayList<CarBean>) hs.getAttribute("al");
			Iterator<CarBean> it = al.iterator();

			while (it.hasNext()) {
				CarBean cb = (CarBean) it.next();
				if (carNumber.equals(cb.getCarNumber())) {
					cb.setCarRent_PER_DAY(carPrice);
					cb.setLocation(location);
					int k = new AdminUpdateCarDetailsDAO().updateCarDetails(cb);
					if (k > 0) {
						req.setAttribute("msg", "Details Updated Successfully <br>");
						req.getRequestDispatcher("InfoCarUpdate.jsp").forward(req, res);
					}
				}
			}
		}
	}

}
