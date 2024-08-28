package service;

import java.util.ArrayList;
import serviceImpl.LabOrders;

// Interface
public interface OrderManagementInfLab {

	public void getOrdersByOrderNameAndPatientFullName(String orderName, String patientFullName,
			ArrayList<LabOrders> LabOrderlist);

}
