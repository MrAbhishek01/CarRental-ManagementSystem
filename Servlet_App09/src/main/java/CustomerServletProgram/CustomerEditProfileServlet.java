package CustomerServletProgram;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/CustomerEdit")
public class CustomerEditProfileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs= req.getSession(false);

		if (hs == null) {
			req.setAttribute("msg", "Session Expired..");
			req.getRequestDispatcher("Massage.jsp").forward(req, res);

		} else {
			req.getRequestDispatcher("CustomerEditProfile.jsp").forward(req, res);

		}

	}

}
