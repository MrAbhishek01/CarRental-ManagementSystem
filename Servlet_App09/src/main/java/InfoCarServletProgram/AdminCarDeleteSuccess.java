package InfoCarServletProgram;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import InfoCarBean.CarBean;
import InfoCarDAO.AdminDeleteCarDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@SuppressWarnings("serial")
@WebServlet("/deleteCar")
public class AdminCarDeleteSuccess extends HttpServlet {

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired..<br>");
			req.getRequestDispatcher("Massage.jsp");
		} else {
			String carNumber = req.getParameter("carNumber");

			ArrayList<CarBean> al = (ArrayList<CarBean>) hs.getAttribute("al");
			Iterator<CarBean> it = al.iterator();

			while (it.hasNext()) {
				CarBean cb = (CarBean) it.next();
				if (carNumber.equals(cb.getCarNumber())) {

					if (new AdminDeleteCarDAO().deleteCar(cb)) {
						req.setAttribute("msg", "Car Deleted Successfully <br>");
						req.getRequestDispatcher("InfoCarDeleteSuccess.jsp").forward(req, res);
					}
				}
			}
		}

	}
}