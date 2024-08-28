package serviceImpl;

public class LabOrders extends Orders {
	public final String catalog_Type;
	int catalog_id;

	//constructor
	public LabOrders() {
		catalog_Type = "General lab";
	}

	//setter
	public void setCatalogId(int order_ID) {
		catalog_id = order_ID;
	}

	public void setOrderId(int order_ID) {
		order_id = order_ID;
	}

	public void setOrderName(String orderName) {
		order_name = orderName;
	}

	public void setPatFirstName(String FirstName) {
		patient_first_name = FirstName;
	}

	public void setPatLastName(String LastName) {
		patient_last_name = LastName;
	}

	//getter
	public int getCatalogId() {
		return catalog_id;
	}

	public String getCatalog_Type() {
		return catalog_Type;
	}

	public int getOrderId() {
		return order_id;
	}

	public String getOrderName() {
		return order_name;
	}

	public String getPatFirstName() {
		return patient_first_name;
	}

	public String getPatLastName() {
		return patient_last_name;
	}

}