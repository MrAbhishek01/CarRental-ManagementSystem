package CustomerServletProgram;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Customerlogout")
@SuppressWarnings("serial")
public class CustomerLogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cookie[] ck = req.getCookies();
		if (ck == null) {
			req.setAttribute("msg", "Session Expired..");
		} else {
			ServletContext sct = req.getServletContext();
			sct.removeAttribute("cbean");
			ck[0].setMaxAge(0);
			req.setAttribute("msg", "User LoggedOut Successfully");
		}
		req.getRequestDispatcher("Massage.jsp").forward(req, res);
		

	}

}
