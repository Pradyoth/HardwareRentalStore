package ucboulder.ooad.project3.entities;


import java.util.ArrayList;
import java.util.List;

import ucboulder.ooad.project3.decorator.AddOnDecorator;

public class RentalRecord {

	public int returnedDay;
	boolean status;
	
	public RentalRecord(int returnDay) {
		this.returnedDay = returnDay;
		this.status = true;
	}
	
	public List<AddOnDecorator> docoratedTools = new ArrayList<AddOnDecorator>();
		
	//Returns the list of rented tools for a given rental record
	public List<AddOnDecorator> getDocoratedTools() {
		return docoratedTools;
	}
	
	//Adds a tool to the list of tools for a given rental record
	public void addDocoratedTools(AddOnDecorator docoratedTool) {
	//	System.out.println(docoratedTool);
		docoratedTools.add(docoratedTool);
		
		
	}
	
	// Checks whether rental record is active or not
	public boolean getStatus() {
		return this.status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	// Returns the price of the entire rental record. 
	public int getTotalPrice() {
		
		int price=0;
		
		for(int i=0;i<docoratedTools.size();i++) {
        
		price = price + docoratedTools.get(i).getPrice();
		
		}
        
		return price;
	}
	
	// Handles return of a rental and increases the inventory count for the tools present in the rental record. 
	public void returnRental(Customer c) {
		
		//System.out.println(docoratedTools.size());
		
		for(int i=0;i<docoratedTools.size();i++) {
			
			AddOnDecorator t = docoratedTools.get(i);
	        
			while(!t.getClass().getSimpleName().equals("Painting") || 
					!t.getClass().getSimpleName().equals("Plumbing") ||
					!t.getClass().getSimpleName().equals("Woodwork") ||
					!t.getClass().getSimpleName().equals("Yardwork") ||
					!t.getClass().getSimpleName().equals("Concrete")) {
				
				//System.out.println(t.getClass().getSimpleName());
				
				
				
				
				if(t.tool instanceof AddOnDecorator) {
					t = (AddOnDecorator) t.tool;
				}
				else {
					break;
				}
			}
			//System.out.println("--"+t.tool);
			t.tool.increaseCount();
			System.out.println(t.tool.name + " returned by customer " + c.name);
					
			
			}
		
		
	}
	
	
	
}
