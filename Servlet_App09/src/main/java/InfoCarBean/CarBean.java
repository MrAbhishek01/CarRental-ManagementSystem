package InfoCarBean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CarBean implements Serializable {

	private String carNumber;
	private String carModel;
	private String carBrand;
	private Double carRent_PER_DAY;
	private String location;
	private String adminUserName;

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public CarBean() {}

	public String getCarNumber() {
		return carNumber;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getCarRent_PER_DAY() {
		return carRent_PER_DAY;
	}

	public void setCarRent_PER_DAY(Double carRent_PER_DAY) {
		this.carRent_PER_DAY = carRent_PER_DAY;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
}

	

/**
 * CREATE TABLE CarDetails (
    CAR_NUMBER VARCHAR(15) PRIMARY KEY,
    BRAND VARCHAR(15),
    MODEL VARCHAR(15),
    CAR_PRICEDAY DECIMAL(10, 2),
    LOCATION VARCHAR(15),
    AVAILABLE NUMBER(1),
    ADMINUSERNAME VARCHAR2(15)
);

 */
