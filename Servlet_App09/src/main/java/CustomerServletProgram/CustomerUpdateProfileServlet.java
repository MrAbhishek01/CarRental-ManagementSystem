package CustomerServletProgram;

import java.io.IOException;

import CustomerBean.CustomerBean;
import CustomerDAO.CustomerUpdateDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CustomerUpdate")
@SuppressWarnings("serial")
public class CustomerUpdateProfileServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs= req.getSession(false);
		
		if (hs == null) 
		{
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("Massage.jsp").forward(req, res);
		} else 
		{
			
			CustomerBean cb = (CustomerBean) hs.getAttribute("cbean");
			cb.setAddress(req.getParameter("Address"));
			cb.setEmailId(req.getParameter("eid"));
			cb.setPhoneNumber(Long.parseLong(req.getParameter("phone")));

			int k = new CustomerUpdateDAO().updateCustomerDetails(cb);

			if (k > 0) 
			{

				req.setAttribute("msg", "Profile Updated Successfully..");
				req.getRequestDispatcher("CustomerUpdateProfile.jsp").forward(req, res);

			}

		}
	}

}
