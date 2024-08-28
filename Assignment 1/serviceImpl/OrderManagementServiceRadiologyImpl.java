
package serviceImpl;

import java.util.ArrayList;
import java.util.Scanner;
import service.OrderManagementServiceRadiology;

public class OrderManagementServiceRadiologyImpl extends OrderManagementServiceRadiology 
{
	public void getOrdersById(int orderId, ArrayList<RadiologyOrder> RadiologyOrderlist)
	{
	   boolean found = false;
	   System.out.println("*****************get orders by ID***************");
	   System.out.println("-------------------------------------------------------------------------------------");
		try 
		{
			for (int i = 0; i < RadiologyOrderlist.size(); i++)
			{
				if (RadiologyOrderlist.get(i).getOrderId() == orderId)
				{
					System.out.println("Lab order name = " + RadiologyOrderlist.get(i).getOrderName());
					found = true;
				}
			}
			if (!found) 
			{
				throw new Exception("OrderNotFoundException");
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	   System.out.println("-------------------------------------------------------------------------------------");
	   System.out.println("************************************************************************************");
	}
	
	public void updateOrderById(int orderId, RadiologyOrder orders, ArrayList<RadiologyOrder> RadiologyOrderlist)
	{
	   boolean updated = false;
	   System.out.println("-------------------------------------------------------------------------------------");
	   Scanner sc = new Scanner(System.in);
	   
		for (int i = 0; i < RadiologyOrderlist.size(); i++) 
		{
			if (RadiologyOrderlist.get(i).getOrderId() == orderId)
			{
				System.out.println("existing order name = " + RadiologyOrderlist.get(i).getOrderName());

				System.out.println("Enter new order name");
				String order_name = sc.next();
				orders.setOrderName(order_name.toLowerCase());
				orders.setCatalogId(RadiologyOrderlist.get(i).getCatalogId());
				orders.setOrderId(RadiologyOrderlist.get(i).getOrderId());
				orders.setPatFirstName(RadiologyOrderlist.get(i).getPatFirstName());
				orders.setPatLastName(RadiologyOrderlist.get(i).getPatLastName());
				RadiologyOrderlist.set(i, orders);

				updated = true;
			}
		}  
		if (updated) 
		{
			System.out.println("**********Display all details after update************ ");
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("Catalog-id | " + "Catalog-Type |" + " Order-id |" + "  orders name |"
					+ " orders pat first name |" + " orders pat last name ");System.out.println("-------------------------------------------------------------------------------------");
			for (int j = 0; j < RadiologyOrderlist.size(); j++)
			{
				System.out.println(RadiologyOrderlist.get(j).getCatalogId() + "            "
						+ RadiologyOrderlist.get(j).getCatalog_Type() + "\t\t"
						+ RadiologyOrderlist.get(j).getOrderId() + "\t  "
						+ RadiologyOrderlist.get(j).getOrderName() + "\t\t\t "
						+ RadiologyOrderlist.get(j).getPatFirstName() + "\t\t\t"
						+ RadiologyOrderlist.get(j).getPatLastName());
			}
		} 
		else 
		{
			System.out.println("**********id entered does not match with existing order id************ ");
		}
	   System.out.println("-------------------------------------------------------------------------------------");
	   System.out.println("*******************************************END****************************************");
	   sc.close();
	}
	
	public void AddRadiologyOrders(RadiologyOrder orders, ArrayList<RadiologyOrder> RadiologyOrderlist)
	{ 
		int i = 0, choice;
		while(i>=0)
		{
			Scanner sc = new Scanner(System.in);
			RadiologyOrder Radiologyord = new RadiologyOrder();
			System.out.println("****Enter Radiology order ID**********");
			while (true)
		         try {
		        	 choice = Integer.parseInt(sc.nextLine());
		             break;
		         } catch (NumberFormatException nfe) {
		             System.out.print(" OrderCreationFailException invalid entry Try again with integer: ");
		         }
			Radiologyord.setOrderId(choice);
			
			System.out.println("****Enter Radiology catalog order ID**********");
			while (true)
		         try {
		        	 choice = Integer.parseInt(sc.nextLine());
		             break;
		         } catch (NumberFormatException nfe) {
		             System.out.print("OrderCreationFailException invalid entry Try again with integer: ");
		         }
			Radiologyord.setCatalogId(choice);
			
			System.out.println("****Enter Radiology order Name**********");
			String order_name = sc.next();
			Radiologyord.setOrderName(order_name.toLowerCase());
			
			System.out.println("****Enter Radiology order patient first name**********");
			String firstname = sc.next();
			Radiologyord.setPatFirstName(firstname.toLowerCase());
			
			System.out.println("****Enter Radiology order patient last name**********");
			String lastname = sc.next();
			Radiologyord.setPatLastName(lastname.toLowerCase());
			
			RadiologyOrderlist.add(Radiologyord);
			
			System.out.println("****Do you want to enter more Radiology orders**********");
			System.out.println("1. Y \n2. N");
			
			choice = sc.nextInt();
			if(choice == 1)
			{
				i++;
			}
			else
			{
				break;
			}
	   }
	}
}
