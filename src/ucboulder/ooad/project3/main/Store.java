package ucboulder.ooad.project3.main;

import ucboulder.ooad.project3.decorator.AddOnDecorator;
import ucboulder.ooad.project3.entities.Painting;
import ucboulder.ooad.project3.entities.RentalRecord;
import ucboulder.ooad.project3.entities.Tool;

import ucboulder.ooad.project3.factory.ToolFactory;

public class Store {

	public static void main(String[] args) {
		
		//System.out.println(Painting.count);
		
		
		Tool t = ToolFactory.getTool("Painting","Painting tool 1", 3);
		
		Tool at = ToolFactory.getAddOnTool("ExtensionCord","Extension Cord 1",t);
		Tool at2 = ToolFactory.getAddOnTool("ExtensionCord","Extension Cord 2",at);
		
		//System.out.println(at2.getPrice());
		
		RentalRecord rr = new RentalRecord();
		rr.addDocoratedTools((AddOnDecorator) at2);
		//rr.addDocoratedTools(t);
		
		
	//System.out.println(rr.getTotalPrice());	
	
	//System.out.println(Painting.count);
	
	rr.returnRental();

	
	//System.out.println(Painting.count);

	}

}
