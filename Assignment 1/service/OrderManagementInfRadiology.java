package service;

import java.util.ArrayList;
import serviceImpl.RadiologyOrder;

// Interface
public interface OrderManagementInfRadiology {

	public void getOrdersByOrderNameAndPatientFullName(String orderName, String patientFullName,
			ArrayList<RadiologyOrder> RadiologyOrderlist);
}
