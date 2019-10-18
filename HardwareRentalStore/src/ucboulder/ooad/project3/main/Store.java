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
	
	
	public void addCustomersToStore(Customer customer) {
		this.customers.add(customer);
	}
	public List<Customer> getCustomersFromStore(){
		return this.customers;
	}

	/*public static void main(String[] args) {
		
		System.out.println(Painting.count);
		
		
		for (int i = 0 ; i < 35 ; i++) {
			Random randomGenerator = new Random();
			
			int randomNumber = randomGenerator.nextInt(3) + 1;
			if (randomNumber == 1) {
				 customer = CustomerFactory.getCustomer("BusinessCustomer", "Customer" + (i));

			}
			else if (randomNumber ==2) {
				 customer = CustomerFactory.getCustomer("RegualarCustomer", "Customer" + (i));
			}
			else {
				 casualCustomer = CustomerFactory.getCustomer("CasualCustomer", "Customer" + (i));		
			}
			
			
		}
		Tool t = ToolFactory.getTool("Painting","Painting tool 1", 3);
		
		Tool at = ToolFactory.getAddOnTool("ExtensionCord","Extension Cord 1",t);
		Tool at2 = ToolFactory.getAddOnTool("ExtensionCord","Extension Cord 2",at);
		
		System.out.println(at2.getPrice());
		Tool t2 = ToolFactory.getTool("Concrete","Concrete tool 1", 4);
		Tool addOn = ToolFactory.getAddOnTool("AccessoryKit", "Accessory kit 1", t2);
		
		
		RentalRecord rr = new RentalRecord();
		
		rr.addDocoratedTools((AddOnDecorator) at2);
		rr.addDocoratedTools((AddOnDecorator) addOn);
		List<AddOnDecorator> toolList = rr.getDocoratedTools();
		System.out.println("Tools list is");
		for (AddOnDecorator tool : toolList) {
			System.out.println(tool);
		}
//		System.out.println("rr");
//		System.out.println(rr);
//		System.out.println(rr.getTotalPrice());	
	
		
		
		System.out.println(Painting.count);
		Tool t3 = ToolFactory.getTool("Woodwork","Woodwork tool 1", 7);
		Tool addOn2 = ToolFactory.getAddOnTool("ExtensionCord", "Extension Cord 3 ", t3);
		Tool t4 = ToolFactory.getTool("Yardwork","Yardwork tool 1", 7);
		Tool addOn3 = ToolFactory.getAddOnTool("ProtectiveGearPack", "Protective Gear Pack 1", t4);
		Tool addOn4 = ToolFactory.getAddOnTool("ExtensionCord", "Extension Cord 4", addOn3);
		Tool t5 = ToolFactory.getTool("Plumbing","Plumbing tool 1", 7);
		Tool addOn5 = ToolFactory.getAddOnTool("AccessoryKit", "Accessory Kit 2", t5);

//	rr.returnRental();
	   
	   
	Customer regularCustomer1 = CustomerFactory.getCustomer("RegularCustomer","Pete");
	regularCustomer1.addRentalRecord(rr);
	List<RentalRecord> peteRentalRecord = regularCustomer1.getRentalRecordList();
	System.out.println("Pete rental record details");
	for (RentalRecord record : peteRentalRecord) {
		System.out.println(record);
	}
	RentalRecord rr2 = new RentalRecord();
	rr2.addDocoratedTools((AddOnDecorator) addOn2);
	rr2.addDocoratedTools((AddOnDecorator) addOn4);
	rr2.addDocoratedTools((AddOnDecorator) addOn5);
	Customer businessCustomer1 = CustomerFactory.getCustomer("BusinessCustomer", "David");
	businessCustomer1.addRentalRecord(rr2);
	List<RentalRecord> davidRentalRecord = businessCustomer1.getRentalRecordList();
	System.out.println("David rental record details");
	for (RentalRecord record: davidRentalRecord) {
		System.out.println(record);
	}
	

	Tool t6 = ToolFactory.getTool("Painting", "Painting tool 2", 1);
	Tool addOn6 = ToolFactory.getAddOnTool("AccessoryKit", "Accessory Kit 3", t6);
	RentalRecord rr3 = new RentalRecord();
	rr3.addDocoratedTools((AddOnDecorator) addOn6);
	
	Tool t7 = ToolFactory.getTool("Plumbing", "Plumbing tool 2", 1);
	Tool addOn7 = ToolFactory.getAddOnTool("ProtectiveGearPack", "Protective gear pack 2", t7);
	RentalRecord rr4 = new RentalRecord();
	rr4.addDocoratedTools((AddOnDecorator) addOn7);
	Customer casualCustomer1 = CustomerFactory.getCustomer("CasualCustomer", "Andy");
	casualCustomer1.addRentalRecord(rr3);
	casualCustomer1.addRentalRecord(rr4);
	List<RentalRecord> andyRentalRecord = casualCustomer1.getRentalRecordList();
	System.out.println("Andy rental record details");
	for (RentalRecord record: andyRentalRecord) {
		System.out.println(record);
	}
	
	
	

	
	System.out.println(Painting.count);

	}*/

}
