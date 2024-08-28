package MainClass;

import serviceImpl.LabOrders;
import service.OrderManagementServiceLab;
import service.OrderManagementInfLab;
import serviceImpl.OrderManagementServiceLabImpl;
import serviceImpl.OrderManagementInferfaceLabImplementation;

import serviceImpl.RadiologyOrder;
import service.OrderManagementServiceRadiology;
import service.OrderManagementInfRadiology;
import serviceImpl.OrderManagementServiceRadiologyImpl;
import serviceImpl.OrderManagementInferfaceRadiologyImplementation;

import java.util.ArrayList;
import java.util.Scanner;

public class EHR_project {

	public static void main(String[] args) {

		// lab order
		OrderManagementServiceLab objOrdmgtserviceLab = new OrderManagementServiceLabImpl();
		OrderManagementInfLab objOrdMgtInterfaceLab = new OrderManagementInferfaceLabImplementation();

		// Radiology order
		OrderManagementServiceRadiology objOrdmgtserviceRadiology = new OrderManagementServiceRadiologyImpl();
		OrderManagementInfRadiology objOrdMgtInterfaceRadiology = new OrderManagementInferfaceRadiologyImplementation();

		int update_id = 0, userchoice = 0;
		String ordername, fullname;

		Scanner s = new Scanner(System.in);
		System.out.println("*****************Enter choice to select lab or radiology orders***************");
		System.out.println("1. lab order \n2. Radiology order ");

		while (true)
			try {
				userchoice = Integer.parseInt(s.nextLine());
				break;
			} catch (NumberFormatException nfe) {
				System.out.print("Invalid entry Try again integer: ");
			}
		
		LabOrders objlaborders = new LabOrders();
		ArrayList<LabOrders> LabOrderlist = new ArrayList<LabOrders>();

		RadiologyOrder objRadiologyOrder = new RadiologyOrder();
		ArrayList<RadiologyOrder> RadiologyOrderList = new ArrayList<RadiologyOrder>();

		switch (userchoice) {
		case 1:
			objOrdmgtserviceLab.AddLabOrders(objlaborders, LabOrderlist);

			System.out.println("****Do you want to display lab orders or add radiology order**********");
			System.out.println("1. Display orders \n2. Add Radiology order");
			userchoice = s.nextInt();
			if (userchoice == 1) 
			{
				System.out.println("------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("Catalog-id | " + "Catalog-Type |" + " Order-id |" + "  orders name |"
						+ " orders pat first name |" + " orders pat last name ");
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
				for (int j = 0; j < LabOrderlist.size(); j++) 
				{
					System.out.println(LabOrderlist.get(j).getCatalogId() + "            "
							+ LabOrderlist.get(j).getCatalog_Type() + "\t" + LabOrderlist.get(j).getOrderId() + "\t  "
							+ LabOrderlist.get(j).getOrderName() + "\t\t\t " + LabOrderlist.get(j).getPatFirstName()
							+ "\t\t\t" + LabOrderlist.get(j).getPatLastName());
				}
				System.out.println(
						"-------------------------------------------------------------------------------------");
			} 
			else if (userchoice == 2)
			{
				objOrdmgtserviceRadiology.AddRadiologyOrders(objRadiologyOrder, RadiologyOrderList);
				System.out.println("****Do you want to display Radiology orders**********");
				System.out.println("1. Display Radiology order");
				userchoice = s.nextInt();
				if (userchoice == 1) 
				{
					System.out.println("------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Catalog-id | " + "Catalog-Type |" + " Order-id |" + "  orders name |"
							+ " orders pat first name |" + " orders pat last name ");
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
					for (int j = 0; j < RadiologyOrderList.size(); j++) 
					{
						System.out.println(RadiologyOrderList.get(j).getCatalogId() + "            "
								+ RadiologyOrderList.get(j).getCatalog_Type() + "\t\t"
								+ RadiologyOrderList.get(j).getOrderId() + "\t  "
								+ RadiologyOrderList.get(j).getOrderName() + "\t\t\t "
								+ RadiologyOrderList.get(j).getPatFirstName() + "\t\t\t"
								+ RadiologyOrderList.get(j).getPatLastName());
					}
					System.out.println("-------------------------------------------------------------------------------------");
				} 
				else
				{
					System.out.println("invalid input");
				}
			}

			System.out.println("*****************enter lab orders ID to display order name***************");
			Scanner scId = new Scanner(System.in);
			while (true)
				try {
					userchoice = Integer.parseInt(scId.nextLine());
					break;
				} catch (NumberFormatException nfe) {
					System.out.print("invalid entry Try again: ");
				}

			objOrdmgtserviceLab.getOrdersById(userchoice, LabOrderlist);

			System.out.println("*****************enter lab order name and patient full name***************");
			System.out.println("*****************enter lab order name***************");
			ordername = s.next();
			System.out.println("*****************enter patient full name***************");
			fullname = s.next();
			objOrdMgtInterfaceLab.getOrdersByOrderNameAndPatientFullName(ordername, fullname, LabOrderlist);

			System.out.println("*****************enter orders ID of lab order to update***************");
			scId = new Scanner(System.in);
			while (true)
				try {
					update_id = Integer.parseInt(scId.nextLine());
					break;
				} catch (NumberFormatException nfe) {
					System.out.print("invalid entry Try again: ");
				}
			
			objOrdmgtserviceLab.updateOrderById(update_id, objlaborders, LabOrderlist);
			break;

		case 2:
			objOrdmgtserviceRadiology.AddRadiologyOrders(objRadiologyOrder, RadiologyOrderList);

			System.out.println("****Do you want to display Radiology orders or add Lab order**********");
			System.out.println("1. Display orders \n2. Add Lab order");
			userchoice = s.nextInt();
			if (userchoice == 1) 
			{
				System.out.println("------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("Catalog-id | " + "Catalog-Type |" + " Order-id |" + "  orders name |"
						+ " orders pat first name |" + " orders pat last name ");
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
				for (int j = 0; j < RadiologyOrderList.size(); j++)
				{
					System.out.println(RadiologyOrderList.get(j).getCatalogId() + "            "
							+ RadiologyOrderList.get(j).getCatalog_Type() + "\t\t"
							+ RadiologyOrderList.get(j).getOrderId() + "\t " 
							+ RadiologyOrderList.get(j).getOrderName()+ "\t\t\t " 
							+ RadiologyOrderList.get(j).getPatFirstName() + "\t\t\t"
							+ RadiologyOrderList.get(j).getPatLastName());
				}
				System.out.println("-------------------------------------------------------------------------------------");

			} 
			else if (userchoice == 2) 
			{
				objOrdmgtserviceLab.AddLabOrders(objlaborders, LabOrderlist);
				System.out.println("****Do you want to display lab orders **********");
				System.out.println("1. Display lab order");
				userchoice = s.nextInt();
				if (userchoice == 1) 
				{
					System.out.println("------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Catalog-id | " + "Catalog-Type |" + " Order-id |" + "  orders name |"
							+ " orders pat first name |" + " orders pat last name ");
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
					for (int j = 0; j < LabOrderlist.size(); j++)
					{
						System.out.println(LabOrderlist.get(j).getCatalogId() + "            "
								+ LabOrderlist.get(j).getCatalog_Type() + "\t" 
								+ LabOrderlist.get(j).getOrderId()+ "\t  " 
								+ LabOrderlist.get(j).getOrderName() + "\t\t\t "
								+ LabOrderlist.get(j).getPatFirstName() + "\t\t\t"
								+ LabOrderlist.get(j).getPatLastName());
					}
					System.out.println("-------------------------------------------------------------------------------------");
				}

			} 
			else 
			{
				System.out.println("invalid input");
			}

			System.out.println("*****************enter Radiology orders ID to display order name***************");
			scId = new Scanner(System.in);
			while (true)
				try {
					userchoice = Integer.parseInt(scId.nextLine());
					break;
				} catch (NumberFormatException nfe) {
					System.out.print("invalid entry Try again: ");
				}

			objOrdmgtserviceRadiology.getOrdersById(userchoice, RadiologyOrderList);

			System.out.println("*****************enter Radiology order name and patient full name***************");
			System.out.println("*****************enter Radiology order name***************");
			ordername = s.next();
			System.out.println("*****************enter patient full name name***************");
			fullname = s.next();
			
			objOrdMgtInterfaceRadiology.getOrdersByOrderNameAndPatientFullName(ordername, fullname, RadiologyOrderList);

			System.out.println("*****************enter Radiology ID of lab order to update***************");
			scId = new Scanner(System.in);
			while (true)
				try {
					update_id = Integer.parseInt(scId.nextLine());
					break;
				} catch (NumberFormatException nfe) {
					System.out.print("invalid entry Try again: ");
				}
			objOrdmgtserviceRadiology.updateOrderById(update_id, objRadiologyOrder, RadiologyOrderList);
			break;

		default:
			System.out.println("Invalid entry");
			break;

		}
	}

}
