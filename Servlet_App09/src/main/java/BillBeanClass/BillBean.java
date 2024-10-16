package BillBeanClass;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BillBean implements Serializable {

	private String orderbill;
	private String customerUserID;
	private String customerName;
	private Long customerMobileNumber;
	private String customerEmailId;
	private String carBrand;
	private String carModel;
	private String carNumber;
	private String journeyStartDate;
	private String journeyEndDate;
	private int totalDays;
	private String rentedStatus;
	private Double totalBill;
	private String adminUserName;

	public BillBean() {
		super();
	}

	public String getOrderbill() {
		return orderbill;
	}

	public void setOrderbill(String orderbill) {
		this.orderbill = orderbill;
	}

	public String getCustomerUserID() {
		return customerUserID;
	}

	public void setCustomerUserID(String customerUserID) {
		this.customerUserID = customerUserID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getCustomerMobileNumber() {
		return customerMobileNumber;
	}

	public void setCustomerMobileNumber(Long customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getJourneyStartDate() {
		return journeyStartDate;
	}

	public void setJourneyStartDate(String journeyStartDate) {
		this.journeyStartDate = journeyStartDate;
	}

	public String getJourneyEndDate() {
		return journeyEndDate;
	}

	public void setJourneyEndDate(String journeyEndDate) {
		this.journeyEndDate = journeyEndDate;
	}

	public int getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}

	public String getRentedStatus() {
		return rentedStatus;
	}

	public void setRentedStatus(String rentedStatus) {
		this.rentedStatus = rentedStatus;
	}

	public Double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(Double totalBill) {
		this.totalBill = totalBill;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

}
