package ucboulder.ooad.project3.entities;


import java.util.ArrayList;
import java.util.List;

import ucboulder.ooad.project3.decorator.AddOnDecorator;

public class RentalRecord {

	public int returnedDay;
	
	public RentalRecord(int returnDay) {
		this.returnedDay = returnDay;
	}
	
	public List<AddOnDecorator> docoratedTools = new ArrayList<AddOnDecorator>();
		
	
	public List<AddOnDecorator> getDocoratedTools() {
		return docoratedTools;
	}

	public void addDocoratedTools(AddOnDecorator docoratedTool) {
	//	System.out.println(docoratedTool);
		docoratedTools.add(docoratedTool);
		
		
	}

	public int getTotalPrice() {
		
		int price=0;
		
		for(int i=0;i<docoratedTools.size();i++) {
        
		price = price + docoratedTools.get(i).getPrice();
		
		}
        
		return price;
	}
	
	public void returnRental() {
		
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
			System.out.println(t.tool.name + " being returned");
					
			
			}
		
		
	}
	
	
	
}
