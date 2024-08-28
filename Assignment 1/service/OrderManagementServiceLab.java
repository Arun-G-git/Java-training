package service;

import serviceImpl.*;
import java.util.ArrayList;

// Abstract Class
public abstract class OrderManagementServiceLab {

	// Abstract method
	public abstract void getOrdersById(int orderId, ArrayList<LabOrders> LabOrderlist);

	// Non-abstract methods
	public void updateOrderById(int orderId, LabOrders orders, ArrayList<LabOrders> LabOrderlist) {

	}

	// Non-abstract methods
	public void AddLabOrders(LabOrders orders, ArrayList<LabOrders> LabOrderlist) {

	}
}
