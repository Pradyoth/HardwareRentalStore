package ucboulder.ooad.project3.main;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ucboulder.ooad.project3.decorator.AddOnDecorator;
import ucboulder.ooad.project3.entities.Customer;
import ucboulder.ooad.project3.entities.Painting;
import ucboulder.ooad.project3.entities.RentalRecord;
import ucboulder.ooad.project3.entities.Tool;
import ucboulder.ooad.project3.factory.CustomerFactory;

import ucboulder.ooad.project3.factory.ToolFactory;

public class Store {
	public List<Customer> customers = new ArrayList<Customer>();
	
	//Adds the customers to store
	public void addCustomersToStore(Customer customer) {
		this.customers.add(customer);
	}
	
	// returns list of customers present in store
	public List<Customer> getCustomersFromStore(){
		return this.customers;
	}

	

}
