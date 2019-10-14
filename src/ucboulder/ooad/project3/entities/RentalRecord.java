package ucboulder.ooad.project3.entities;


import java.util.ArrayList;
import java.util.List;

import ucboulder.ooad.project3.decorator.AddOnDecorator;

public class RentalRecord {

	
	//public List<AddOnDecorator> docoratedTools = new ArrayList<AddOnDecorator>();
	public List<Tool> docoratedTools = new ArrayList<Tool>();
	
	public List<Tool> getDocoratedTools() {
		return docoratedTools;
	}

	public void addDocoratedTools(Tool docoratedTool) {
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
		
		for(int i=0;i<docoratedTools.size();i++) {
			
			Tool t = docoratedTools.get(i);
	      //  System.out.println(t.getClass().getSimpleName());
			while(!t.getClass().getSimpleName().equals("Painting") || 
					!t.getClass().getSimpleName().equals("Plumbing") ||
					!t.getClass().getSimpleName().equals("Woodwork") ||
					!t.getClass().getSimpleName().equals("Yardwork") ||
					!t.getClass().getSimpleName().equals("Concrete")) {
				
				//System.out.println(t.getClass().getSimpleName());
				
			//	System.out.println("Inside");
				
				
				if(t instanceof AddOnDecorator) {
					t = ((AddOnDecorator) t).tool;
				}
				else {
					break;
				}
			}
		//	System.out.println("--");
			//((AddOnDecorator)t).tool.increaseCount();
				
			if(t instanceof AddOnDecorator) {
				t = ((AddOnDecorator) t).tool;
				t.increaseCount();
				//System.out.println("++");
						
			}
			else {
				t.increaseCount();
			}
			
			
			}
		
		
	}
	
	
	
}
