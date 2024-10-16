package CustomerServletProgram;

import java.io.IOException;

import CustomerBean.CustomerBean;
import CustomerDAO.CustomerLoginDAO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/Customerlogin")
public class CustomerLoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		
		CustomerBean cb = new CustomerLoginDAO().Customerlogin(req.getParameter("cUserName"), req.getParameter("cPassword"));

		if (cb == null) 
		{
			req.setAttribute("msg", "Invalid userName or Password");
			req.getRequestDispatcher("Massage.jsp").forward(req, res);

		} else 
		{
			HttpSession hs=req.getSession();
			hs.setAttribute("cbean", cb);
			ServletContext sct = req.getServletContext();
			sct.setAttribute("cbean", cb);
						
			req.getRequestDispatcher("CustomerLoginSuccess.jsp").forward(req, res);
		}

	}
}
