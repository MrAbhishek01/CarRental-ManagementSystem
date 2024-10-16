package AdminServletProgram;

import java.io.IOException;

import AdminBeanClass.AdminBean;
import AdminDAO.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminRegistration")
@SuppressWarnings("serial")
public class AdminRegisterServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
			AdminBean ab = new AdminBean();

		ab.setAdminUsername(req.getParameter("aUserName"));
		ab.setAdminPassword(req.getParameter("aPassword"));
		ab.setFirstName(req.getParameter("fName"));
		ab.setLastName(req.getParameter("lName"));
		ab.setGender(req.getParameter("gender"));
		ab.setDateOfBirth(req.getParameter("dob"));
		ab.setAddress(req.getParameter("address"));
		ab.setEmailId(req.getParameter("eid"));
		ab.setPhoneNumber(Long.parseLong(req.getParameter("phone")));

		AdminDAO ad = new AdminDAO();
		int k = ad.insertDetails(ab);

		if (k > 0) 
		{
			req.setAttribute("msg", "Registration Successfully..");
			req.getRequestDispatcher("AdminRegistrationSuccess.jsp").forward(req, res);

		}
	}
}
