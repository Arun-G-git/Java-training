package serviceImpl;

import java.util.ArrayList;
import java.util.Scanner;
import service.OrderManagementServiceLab;

public class OrderManagementServiceLabImpl extends OrderManagementServiceLab 
{
	public void getOrdersById(int orderId, ArrayList<LabOrders> LabOrderlist) {
		boolean found = false;
		System.out.println("*****************get orders by ID***************");
		System.out.println("-------------------------------------------------------------------------------------");
		try {
			for (int i = 0; i < LabOrderlist.size(); i++)
			{
				if (LabOrderlist.get(i).getOrderId() == orderId)
				{
					System.out.println("Lab order name = " + LabOrderlist.get(i).getOrderName());
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

	public void updateOrderById(int orderId, LabOrders orders, ArrayList<LabOrders> LabOrderlist) 
	{
		boolean updated = false;
		System.out.println("-------------------------------------------------------------------------------------");
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < LabOrderlist.size(); i++) 
		{
			if (LabOrderlist.get(i).getOrderId() == orderId) 
			{
				System.out.println("existing order name = " + LabOrderlist.get(i).getOrderName());

				System.out.println("Enter new order name");
				String order_name = sc.next();
				orders.setOrderName(order_name.toLowerCase());
				orders.setCatalogId(LabOrderlist.get(i).getCatalogId());
				orders.setOrderId(LabOrderlist.get(i).getOrderId());
				orders.setPatFirstName(LabOrderlist.get(i).getPatFirstName());
				orders.setPatLastName(LabOrderlist.get(i).getPatLastName());
				LabOrderlist.set(i, orders);

				updated = true;
			}
		}
		if (updated) 
		{
			System.out.println("**********display details after update************ ");
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("Catalog-id | " + "Catalog-Type |" + " Order-id |" + "  orders name |"
					+ " orders pat first name |" + " orders pat last name ");
			System.out.println("-------------------------------------------------------------------------------------");
			for (int j = 0; j < LabOrderlist.size(); j++) 
			{
				System.out.println(LabOrderlist.get(j).getCatalogId() + "            "
						+ LabOrderlist.get(j).getCatalog_Type() + "\t" 
						+ LabOrderlist.get(j).getOrderId() + "\t  "
						+ LabOrderlist.get(j).getOrderName() + "\t\t\t " 
						+ LabOrderlist.get(j).getPatFirstName()+ "\t\t\t" 
						+ LabOrderlist.get(j).getPatLastName());
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

	public void AddLabOrders(LabOrders orders, ArrayList<LabOrders> LabOrderlist) 
	{
		int i = 0, choice;
		while (i >= 0)
		{
			Scanner sc = new Scanner(System.in);
			LabOrders labord = new LabOrders();
			
			System.out.println("****Enter lab order ID**********");
			while (true)
				try {
					choice = Integer.parseInt(sc.nextLine());
					break;
				} catch (NumberFormatException nfe) {
					System.out.print(" OrderCreationFailException invalid entry Try again with integer: ");
				}
			labord.setOrderId(choice);
			
			System.out.println("****Enter lab catalog order ID**********");
			while (true)
				try {
					choice = Integer.parseInt(sc.nextLine());
					break;
				} catch (NumberFormatException nfe) {
					System.out.print("OrderCreationFailException invalid entry Try again with integer: ");
				}
			labord.setCatalogId(choice);
			
			System.out.println("****Enter lab order Name**********");
			String order_name = sc.next();
			labord.setOrderName(order_name.toLowerCase());
			
			System.out.println("****Enter lab order patient first name**********");
			String firstname = sc.next();
			labord.setPatFirstName(firstname.toLowerCase());
			
			System.out.println("****Enter lab order patient last name**********");
			String lastname = sc.next();
			labord.setPatLastName(lastname.toLowerCase());
			
			LabOrderlist.add(labord);
			
			System.out.println("****Do you want to enter more lab orders**********");
			System.out.println("1. Y \n2. N");
			
			choice = sc.nextInt();
			if (choice == 1)
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
