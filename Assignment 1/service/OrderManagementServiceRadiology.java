package service;

import serviceImpl.*;

import java.util.ArrayList;

// Abstract Class

public abstract class OrderManagementServiceRadiology {

	// Abstract methods
	public abstract void getOrdersById(int orderId, ArrayList<RadiologyOrder> RadiologyOrderlist);

	// Non-abstract methods
	public void updateOrderById(int orderId, RadiologyOrder orders, ArrayList<RadiologyOrder> RadiologyOrderlist) {
	}

	// Non-abstract methods
	public void AddRadiologyOrders(RadiologyOrder orders, ArrayList<RadiologyOrder> RadiologyOrderlist) {

	}

}
