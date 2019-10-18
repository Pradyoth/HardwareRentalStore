package ucboulder.ooad.project3.main;

import java.util.List;
import java.util.Random;

import ucboulder.ooad.project3.entities.Customer;
import ucboulder.ooad.project3.entities.RentalRecord;
import ucboulder.ooad.project3.factory.CustomerFactory;
import ucboulder.ooad.project3.factory.ToolFactory;
import ucboulder.ooad.project3.entities.Tool;
import ucboulder.ooad.project3.decorator.AddOnDecorator;



public class Main {

	public static void main(String[] args) {
		Store store = new Store();
		for(int i = 0; i < 12 ; i++) {
			Random randomGenerator = new Random();
			int randomNumber = randomGenerator.nextInt(3) + 1;
			Customer customer;
			if (randomNumber == 1) {
				customer = CustomerFactory.getCustomer("BusinessCustomer", "Customer" + (i));
			}
			else if (randomNumber ==2) {
				customer = CustomerFactory.getCustomer("RegularCustomer", "Customer" + (i));
			}
			else {
				customer = CustomerFactory.getCustomer("CasualCustomer", "Customer" + (i));
			}
			store.addCustomersToStore(customer);
		}
		
		
		for (int i = 0 ; i < 34 ; i++) {
			List<Customer> customers = store.getCustomersFromStore();
			for(Customer customer:customers)
			{
				List<RentalRecord> customerRentalRecordList = customer.getRentalRecordList();
				int temp=-1;
				for (int j = 0; j < customerRentalRecordList.size(); j++) {
					int noOfRentedNights = customerRentalRecordList.get(j).getDocoratedTools().get(0).nytNo;
					int boughtDay = customerRentalRecordList.get(j).returnedDay;
					//System.out.println(noOfRentedNights+"---"+boughtDay);
					if(i==(boughtDay+noOfRentedNights)) {
						
						customerRentalRecordList.get(j).returnRental();
						temp = j;
						break;
					}
						
				}
				if(temp!=-1)
				customerRentalRecordList.remove(customerRentalRecordList.get(temp));
			}
			
		
		
			
			
			System.out.println("Day number ------" +(i+1));
			Random randomGenerator = new Random();
			int randomNumber = randomGenerator.nextInt(11) + 1;
//			for (Customer customer : customers) {
//				System.out.println(customer.getClass().getSimpleName());
//			}
			Customer customer = customers.get(randomNumber);
			System.out.println("Customer " + customer.getCustomerName() + " comes to the store");
			if (customer.getClass().getSimpleName().equals("BusinessCustomer")) {
				int numberOfTools = 3;
				int numberOfNights = 7;
				RentalRecord rentalRecord = new RentalRecord(i);
				
				for (int j = 0 ; j < 3 ; j++) {
					int rnum = randomGenerator.nextInt(5) + 1;
					Tool tool;
					Tool at;
					String type;
					if (rnum ==1) {
						tool = ToolFactory.getTool("Painting", "Painting"+(rnum+1), numberOfNights);
						type = "Painting";
						at = ToolFactory.getAddOnTool("ExtensionCord", "Extension cord" +(rnum+1), tool,numberOfNights);
						
					}
					else if (rnum ==2) {
						 tool = ToolFactory.getTool("Plumbing", "Plumbing"+(rnum+1), numberOfNights);
						 type = "Plumbing";
						 at = ToolFactory.getAddOnTool("ProtectiveGearPack", "Protective Gear Pack" +(rnum+1), tool,numberOfNights);

					}
					else if (rnum ==3) {
						 tool = ToolFactory.getTool("Concrete", "Concrete"+(rnum+1),numberOfNights);
						 type = "Concrete";
						 at = ToolFactory.getAddOnTool("AccessoryKit", "Accessory Kit "+(rnum+1), tool,numberOfNights);
					}
					else if (rnum ==4) {
						 tool = ToolFactory.getTool("Woodwork", "Woodwork"+(rnum+1), numberOfNights);
						 type = "Woodwork";
						 at = ToolFactory.getAddOnTool("ExtensionCord","Extension cord" + (rnum+1), tool,numberOfNights);
					}
					else {
						tool = ToolFactory.getTool("Yardwork", "Yardwork"+(rnum+1), numberOfNights);
						type = "Yardwork";
						at = ToolFactory.getAddOnTool("ProtectiveGearPack","Protective Gear Pack" + (rnum+1), tool,numberOfNights);
					}
					if (tool != null)
					rentalRecord.addDocoratedTools((AddOnDecorator)at);
					if (tool == null) {
						System.out.println("He was not able to purchase tool " + type);
					}
					else if (tool != null){
						System.out.println("He purchases tool " + tool.name);
						System.out.println("Add Ons" + at.name);
					}
					
					
					
				}
				customer.addRentalRecord(rentalRecord);			
			}
			if (customer.getClass().getSimpleName().equals("RegularCustomer")) {
				
				int numberOfTools = 2;
				int numberOfNights = 4;
				RentalRecord rentalRecord = new RentalRecord(i);
				
				for (int j = 0 ; j < 2 ; j++) {
					int rnum = randomGenerator.nextInt(5) + 1;
					Tool tool;
					Tool at;
					String type;
					if (rnum ==1) {
						tool = ToolFactory.getTool("Painting", "Painting"+(rnum+1), numberOfNights);
						type = "Painting";
						at = ToolFactory.getAddOnTool("ExtensionCord", "Extension cord" +(rnum+1), tool,numberOfNights);
						
					}
					else if (rnum ==2) {
						 tool = ToolFactory.getTool("Plumbing", "Plumbing"+(rnum+1), numberOfNights);
						 type = "Plumbing";
						 at = ToolFactory.getAddOnTool("ProtectiveGearPack", "Protective Gear Pack" +(rnum+1), tool,numberOfNights);

					}
					else if (rnum ==3) {
						 tool = ToolFactory.getTool("Concrete", "Concrete"+(rnum+1),numberOfNights);
						 type = "Concrete";
						 at = ToolFactory.getAddOnTool("AccessoryKit", "Accessory Kit "+(rnum+1), tool,numberOfNights);
					}
					else if (rnum ==4) {
						 tool = ToolFactory.getTool("Woodwork", "Woodwork"+(rnum+1), numberOfNights);
						 type = "Woodwork";
						 at = ToolFactory.getAddOnTool("ExtensionCord","Extension cord" + (rnum+1), tool,numberOfNights);
					}
					else {
						tool = ToolFactory.getTool("Yardwork", "Yardwork"+(rnum+1), numberOfNights);
						type = "Yardwork";
						at = ToolFactory.getAddOnTool("ProtectiveGearPack","Protective Gear Pack" + (rnum+1), tool,numberOfNights);
					}
					if (tool != null)
					rentalRecord.addDocoratedTools((AddOnDecorator)at);
					if (tool == null) {
						System.out.println("He was not able to purchase tool " + type);
					}
					else if (tool != null){
						System.out.println("He purchases tool " + tool.name);
						System.out.println("Add Ons" + at.name);
					}
					
					
					
				}
				customer.addRentalRecord(rentalRecord);
			}
				if (customer.getClass().getSimpleName().equals("CasualCustomer")) {
				
				int numberOfTools = 1;
				int numberOfNights = 2;
				RentalRecord rentalRecord = new RentalRecord(i);
				
				for (int j = 0 ; j < 2 ; j++) {
					int rnum = randomGenerator.nextInt(5) + 1;
					Tool tool;
					Tool at;
					String type;
					if (rnum ==1) {
						tool = ToolFactory.getTool("Painting", "Painting"+(rnum+1), numberOfNights);
						type = "Painting";
						at = ToolFactory.getAddOnTool("ExtensionCord", "Extension cord" +(rnum+1), tool,numberOfNights);
						
					}
					else if (rnum ==2) {
						 tool = ToolFactory.getTool("Plumbing", "Plumbing"+(rnum+1), numberOfNights);
						 type = "Plumbing";
						 at = ToolFactory.getAddOnTool("ProtectiveGearPack", "Protective Gear Pack" +(rnum+1), tool,numberOfNights);

					}
					else if (rnum ==3) {
						 tool = ToolFactory.getTool("Concrete", "Concrete"+(rnum+1),numberOfNights);
						 type = "Concrete";
						 at = ToolFactory.getAddOnTool("AccessoryKit", "Accessory Kit "+(rnum+1), tool,numberOfNights);
					}
					else if (rnum ==4) {
						 tool = ToolFactory.getTool("Woodwork", "Woodwork"+(rnum+1), numberOfNights);
						 type = "Woodwork";
						 at = ToolFactory.getAddOnTool("ExtensionCord","Extension cord" + (rnum+1), tool,numberOfNights);
					}
					else {
						tool = ToolFactory.getTool("Yardwork", "Yardwork"+(rnum+1), numberOfNights);
						type = "Yardwork";
						at = ToolFactory.getAddOnTool("ProtectiveGearPack","Protective Gear Pack" + (rnum+1), tool,numberOfNights);
					}
					if (tool != null)
					rentalRecord.addDocoratedTools((AddOnDecorator)at);
					if (tool == null) {
						System.out.println("He was not able to purchase tool " + type);
					}
					else if (tool != null){
						System.out.println("He purchases tool " + tool.name);
						System.out.println("Add Ons" + at.name);
					}
					
					
					
				}
				customer.addRentalRecord(rentalRecord);
				
				
				
			}
			
			
			
			
		}
		
	}

}
