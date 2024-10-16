package CustomerServletProgram;

import java.io.IOException;

import CustomerBean.CustomerBean;
import CustomerDAO.CustomerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/CustomerRegistration")
public class CustomerRegisterServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		CustomerBean cb = new CustomerBean();
		
		cb.setCustomerUsername(req.getParameter("cUserName"));
		cb.setCustomerPassword(req.getParameter("cPassword"));
		cb.setFirstName(req.getParameter("fName"));
		cb.setLastName(req.getParameter("lName"));
		cb.setDateOfBirth(req.getParameter("dob"));
		cb.setGender(req.getParameter("gender"));
		cb.setAddress(req.getParameter("address"));
		cb.setEmailId(req.getParameter("eid"));
		cb.setPhoneNumber(Long.parseLong(req.getParameter("phone")));
		
		CustomerDAO cdo = new CustomerDAO();
		
		int k = cdo.insertDetails(cb);
		
		if (k > 0) 
		{
			req.setAttribute("msg", "Registration Successfully");
			req.getRequestDispatcher("CustomerRegistrationSuccess.jsp").forward(req, res);
		}

	}

}
