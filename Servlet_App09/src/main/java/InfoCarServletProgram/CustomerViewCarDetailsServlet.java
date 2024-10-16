package InfoCarServletProgram;

import java.io.IOException;
import java.util.ArrayList;
import InfoCarBean.CarBean;
import InfoCarDAO.CustomerViewCarLocationOrAllWiseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/ViewAvailableAllCars")
public class CustomerViewCarDetailsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs = req.getSession(false);
		if (hs == null) {

		} else {

			ArrayList<CarBean> al = new CustomerViewCarLocationOrAllWiseDAO().viewAllCarDetails();
			hs.setAttribute("al", al);
			req.getRequestDispatcher("ViewCarToCustomer.jsp").forward(req, res);

		}

	}

}
