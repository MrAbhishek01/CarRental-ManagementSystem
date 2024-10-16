package InfoCarServletProgram;

import java.io.IOException;
import java.util.ArrayList;

import AdminBeanClass.AdminBean;
import InfoCarBean.CarBean;
import InfoCarDAO.AdminViewCarDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ViewCar")
@SuppressWarnings("serial")
public class AdminCarViewToAdminServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs = req.getSession(false);

		if (hs == null) {
			req.setAttribute("msg", "Session Expired..");
			req.getRequestDispatcher("Massage.jsp").forward(req, res);

		} else {
			AdminBean ab = (AdminBean) hs.getAttribute("abean");
			ArrayList<CarBean> al = new AdminViewCarDAO().viewCarDetails(ab);

			hs.setAttribute("al", al);
			req.getRequestDispatcher("InfoCarViewToAdmin.jsp").forward(req, res);
		}
	}

}
