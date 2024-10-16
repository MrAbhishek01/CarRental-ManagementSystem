package InfoCarServletProgram;

import java.io.IOException;
import java.util.ArrayList;

import AdminBeanClass.AdminBean;
import InfoCarBean.CarBean;
import InfoCarDAO.AdminCarRentedHistoryDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/RentedCar")
public class AdminCarRentedHistoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs = req.getSession(false);
		if (hs == null) {

		} else {
			AdminBean ab = (AdminBean) hs.getAttribute("abean");
			ArrayList<CarBean> al = new AdminCarRentedHistoryDAO().historyofRentedCar(ab);
			hs.setAttribute("al", al);
			req.getRequestDispatcher("InfoRentedHistory.jsp").forward(req, res);
		}

	}

}
