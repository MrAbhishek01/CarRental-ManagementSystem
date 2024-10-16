package InfoCarServletProgram;

import java.io.IOException;

import AdminBeanClass.AdminBean;
import InfoCarBean.CarBean;
import InfoCarDAO.AdminCarAddDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addCar")
@SuppressWarnings("serial")
public class AdminCarAddingServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession hs = req.getSession(false);

		if (hs == null) 
		{
			req.setAttribute("msg", "Session Expired..");
			req.getRequestDispatcher("Massage.jsp").forward(req, res);
		} else 
		{
			CarBean cb = new CarBean();
			AdminBean ad = (AdminBean) hs.getAttribute("abean");
			cb.setCarNumber(req.getParameter("carNumber"));
			cb.setCarBrand(req.getParameter("carBrand"));
			cb.setCarModel(req.getParameter("carModel"));
			cb.setCarRent_PER_DAY(Double.parseDouble(req.getParameter("dayPrice")));
			cb.setLocation(req.getParameter("location"));

			int k = new AdminCarAddDAO().addCar(cb, ad);
			if (k > 0) 
			{

				req.setAttribute("msg", "Car Added Successfully.");
				req.getRequestDispatcher("InfoCarAdding.jsp").forward(req, res);;
			}

		}

	}

}
