package InfoCarServletProgram;

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
@WebServlet("/deleteCarDetails")
public class AdminDeleteCar extends HttpServlet {

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs = req.getSession(false);
		if (hs == null) {
				req.setAttribute("msg", "Session Expired..");
				req.getRequestDispatcher("Massage.jsp");
			
		} else {

			String carNumber = req.getParameter("cNumber");
			ArrayList<CarBean> al = (ArrayList<CarBean>) hs.getAttribute("al");
			Iterator<CarBean> it = al.iterator();
			while (it.hasNext()) {

				CarBean cb = (CarBean) it.next();

				if (carNumber.equals(cb.getCarNumber())) {
					req.setAttribute("cb", cb);
					req.getRequestDispatcher("InfoCarDelete.jsp").forward(req, res);
				}
			}

		}
	}

}
