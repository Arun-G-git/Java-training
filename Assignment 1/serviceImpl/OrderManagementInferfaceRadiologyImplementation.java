package serviceImpl;

import java.util.ArrayList;

import service.OrderManagementInfRadiology;

public class OrderManagementInferfaceRadiologyImplementation implements OrderManagementInfRadiology 
{
	public void getOrdersByOrderNameAndPatientFullName(String orderName, String patientFullName, ArrayList<RadiologyOrder> RadiologyOrderlist)
	{
	   boolean found = false;
	   int count = 0;
	   System.out.println(" *******Display orders by name and patient name full******");
	   System.out.println("-------------------------------------------------------------------------------------");
	   
		for (int i = 0; i < RadiologyOrderlist.size(); i++) 
		{
			if (RadiologyOrderlist.get(i) != null) 
			{
				String s_patientfullname = RadiologyOrderlist.get(i).getPatFirstName()
						.concat(RadiologyOrderlist.get(i).getPatLastName());
				if (RadiologyOrderlist.get(i).getOrderName().equals(orderName.toLowerCase())
						&& s_patientfullname.equals(patientFullName.toLowerCase())) 
				{
					found = true;
					count = i;
				}
			}
		}
		if (found) 
		{
			for (int i = 0; i < RadiologyOrderlist.size(); i++)
			{
				if (i == count)
				{
					System.out.println("Order name = " + RadiologyOrderlist.get(i).getOrderName() + "\nPatient full name = "
							+ RadiologyOrderlist.get(i).getPatFirstName() + " " + RadiologyOrderlist.get(i).getPatLastName());
				}
			}
		}
		else 
		{
			System.out.println("********** entered values does not match with existing values************ ");
		}
	   System.out.println("-------------------------------------------------------------------------------------");
	   System.out.println("************************************************************************************");
	}

}
