package BillServlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import BillBeanClass.BillBean;
import CustomerBean.CustomerBean;
import InfoCarBean.CarBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/checkBill")
public class CustomerBillCheck extends HttpServlet {

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs = req.getSession(false);
		if (hs == null) {

		} else {
			CustomerBean cb = (CustomerBean) hs.getAttribute("cbean");
			String carNumber = req.getParameter("carNumber");
			ArrayList<CarBean> al = (ArrayList<CarBean>) hs.getAttribute("al");
			Iterator<CarBean> it = al.iterator();
			while (it.hasNext()) {

				CarBean carbean = (CarBean) it.next();
				if (carNumber.equals(carbean.getCarNumber())) {

					BillBean bb = new BillBean();

					Random random = new Random();
					int billId = 100 + random.nextInt(90);
					bb.setCarNumber(carbean.getCarNumber());
					bb.setOrderbill(carbean.getCarNumber() + billId);
					bb.setCustomerName(cb.getFirstName() + " " + cb.getLastName());
					bb.setCustomerUserID(cb.getCustomerUsername());
					bb.setCarBrand(carbean.getCarBrand());
					bb.setCarModel(carbean.getCarModel());
					bb.setRentedStatus("Not Rented");
					bb.setCustomerMobileNumber(cb.getPhoneNumber());
					bb.setCustomerEmailId(cb.getEmailId());

					DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

					LocalDate startDate = LocalDate.parse(req.getParameter("startDate"), inputFormatter);
					LocalDate endDate = LocalDate.parse(req.getParameter("endDate"), inputFormatter);

					String startDateString = startDate.format(outputFormatter);
					String endDateString = endDate.format(outputFormatter);

					int totalDays = (int) ChronoUnit.DAYS.between(startDate, endDate);

					bb.setJourneyStartDate(startDateString);
					bb.setJourneyEndDate(endDateString);
					bb.setTotalDays(totalDays);
					bb.setTotalBill(totalDays * carbean.getCarRent_PER_DAY());

					hs.setAttribute("bill", bb);
					req.setAttribute("carBran", carbean);
					req.getRequestDispatcher("VieworChaekBill.jsp").forward(req, res);
					
					break;
				}

			}
		}
	}

}
