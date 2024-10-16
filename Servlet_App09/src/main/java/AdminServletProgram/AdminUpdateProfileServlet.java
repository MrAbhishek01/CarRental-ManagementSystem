package AdminServletProgram;

import java.io.IOException;
import AdminBeanClass.AdminBean;
import AdminDAO.AdminUpdateDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/AdminUpdate")
public class AdminUpdateProfileServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession hs= req.getSession(false);
		if (hs == null) 
		{
			req.setAttribute("msg", "Session Expired..");
			req.getRequestDispatcher("Massage.jsp").forward(req, res);
		} else 
		{
		
			AdminBean ab = (AdminBean) hs.getAttribute("abean");
			ab.setAddress(req.getParameter("Address"));
			ab.setEmailId(req.getParameter("eid"));
			ab.setPhoneNumber(Long.parseLong(req.getParameter("phone")));

			AdminUpdateDAO auo = new AdminUpdateDAO();
			int k = auo.updateAdminDetails(ab);

			if (k > 0) 
			{
				req.setAttribute("msg", "Profile Updated Successfully");
				req.getRequestDispatcher("AdminUpdateProfile.jsp").forward(req, res);
			}
		}
	}

}
