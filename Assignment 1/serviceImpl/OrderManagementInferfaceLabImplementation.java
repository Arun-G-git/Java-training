package serviceImpl;

import java.util.ArrayList;

import service.OrderManagementInfLab;

public class OrderManagementInferfaceLabImplementation implements OrderManagementInfLab 
{
	public void getOrdersByOrderNameAndPatientFullName(String orderName, String patientFullName,
			ArrayList<LabOrders> LabOrderlist) 
	{
		boolean found = false;
		int count = 0;
		System.out.println(" *******Display orders by name and patient name full******");
		System.out.println("-------------------------------------------------------------------------------------");

		for (int i = 0; i < LabOrderlist.size(); i++) 
		{
			if (LabOrderlist.get(i) != null) 
			{
				String s_patientfullname = LabOrderlist.get(i).getPatFirstName().concat(LabOrderlist.get(i).getPatLastName());
				if (LabOrderlist.get(i).getOrderName().equals(orderName.toLowerCase())
						&& s_patientfullname.equals(patientFullName.toLowerCase())) 
				{
					found = true;
					count = i;
				}
			}
		}
		if (found) 
		{
			for (int i = 0; i < LabOrderlist.size(); i++) 
			{
				if (i == count) 
				{
					System.out.println("Order name = " + LabOrderlist.get(i).getOrderName() + "\nPatient full name = "
							+ LabOrderlist.get(i).getPatFirstName() + " " + LabOrderlist.get(i).getPatLastName());
				}
			}
		} 
		else 
		{
			System.out.println("********** entered value does not match with existing values************ ");
		}
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("************************************************************************************");
	}

}
