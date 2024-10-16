package AdminServletProgram;

import java.io.IOException;
import AdminBeanClass.AdminBean;
import AdminDAO.AdminLoginDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/Adminlogin")
public class AdminLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		AdminBean ab = new AdminLoginDAO().adminLogin(req.getParameter("aUserName"), req.getParameter("uPassword"));

		if (ab == null) {
			req.setAttribute("msg", "Invalid userName or Password");
			req.getRequestDispatcher("Massage.jsp").forward(req, res);

		} else {
			HttpSession hs = req.getSession();
			hs.setAttribute("abean", ab);
			req.getRequestDispatcher("AdminLoginSuccess.jsp").forward(req, res);

		}

	}

}
