package ucboulder.ooad.project3.main;

import java.util.List;
import java.util.Random;

import ucboulder.ooad.project3.entities.Customer;
import ucboulder.ooad.project3.entities.RentalRecord;
import ucboulder.ooad.project3.factory.CustomerFactory;
import ucboulder.ooad.project3.factory.ToolFactory;
import ucboulder.ooad.project3.entities.Tool;
import ucboulder.ooad.project3.decorator.AddOnDecorator;
import ucboulder.ooad.project3.entities.Painting;
import ucboulder.ooad.project3.entities.Plumbing;
import ucboulder.ooad.project3.entities.Woodwork;
import ucboulder.ooad.project3.entities.Yardwork;
import ucboulder.ooad.project3.entities.Concrete;




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
		
		int sumOfAllDaysTotal = 0;
		for (int i = 0 ; i < 34 ; i++) {
			System.out.println("List of tools in the inventory");
			if (Painting.count!=0) {
				System.out.println("Painting tools " +Painting.count);
			}
			if (Plumbing.count!=0) {
				System.out.println("Plumbing tools " +Plumbing.count);
			}
			if (Concrete.count!=0) {
				System.out.println("Concrete tools " +Concrete.count);
			}
			if (Woodwork.count!=0) {
				System.out.println("Woodwork tools " +Woodwork.count);
			}
			if (Yardwork.count!=0) {
				System.out.println("Yardwork tools " +Yardwork.count);
			}
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
						customerRentalRecordList.get(j).setStatus(false);
//						temp = j;
//						break;
					}
					else {
						System.out.println("Customer name: " + customer.getCustomerName() + "has rented ");
						
					}
						
				}
//				if(temp!=-1)
//				customerRentalRecordList.remove(customerRentalRecordList.get(temp));
			}
			
		
		
			
			
			System.out.println("Day number ------" +(i+1));
			Random randomGenerator = new Random();
			int randomNumber = randomGenerator.nextInt(11) + 1;
//			for (Customer customer : customers) {
//				System.out.println(customer.getClass().getSimpleName());
//			}
			Customer customer = customers.get(randomNumber);
			int totalPrice = -1;
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
				totalPrice = rentalRecord.getTotalPrice();
				sumOfAllDaysTotal = sumOfAllDaysTotal + totalPrice;
				System.out.println("Price of the rental record is " +totalPrice);
				
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
				totalPrice = rentalRecord.getTotalPrice();
				sumOfAllDaysTotal += totalPrice;
				System.out.println("Price of the rental record is " +totalPrice);
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
				totalPrice = rentalRecord.getTotalPrice();
				sumOfAllDaysTotal += totalPrice;
				System.out.println("Price of the rental record is " +totalPrice);
				
				
				
			}
				if (totalPrice != -1) {
					System.out.println("Total price that the store made for day is" +totalPrice);
				}
			
			
			
			
		}
		List<Customer> customers = store.getCustomersFromStore();//					System.out.println("type is " +type);

		System.out.println("total number of completed rentals");
		int totalCompletedRentals = 0;
		int countBusiness = 0;
		int countRegular = 0;
		int countCasual = 0; 
		for(Customer customer:customers)
		{
			String type = customer.getClass().getSimpleName();
			
			List<RentalRecord> customerRentalRecordList = customer.getRentalRecordList();
			int temp=-1;
			for (RentalRecord rentalRecord: customerRentalRecordList) {
				if (rentalRecord.getStatus() == false ) {
					totalCompletedRentals++;
//					System.out.println("type is " +type);
					if (type.equals("RegularCustomer")){
						countRegular++;
					}
					else if (type.equals("BusinessCustomer")) {
						countBusiness++;
					}
					else if (type.equals("CasualCustomer")) {
						countCasual++;
					}
				}
			}
//			if(temp!=-1)
//			customerRentalRecordList.remove(customerRentalRecordList.get(temp));
		}
		System.out.println("total completed rentals is " +totalCompletedRentals);
		System.out.println("Total completed rentals for regular customer is " +countRegular);
		System.out.println("Total completed rentals for business customer is " +countBusiness);
		System.out.println("Total completed rentals for casual customer is " +countCasual);
		System.out.println("Total profit of store for the entire period " +sumOfAllDaysTotal);
		
	}

}
