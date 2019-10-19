package ucboulder.ooad.project3.decorator;

import ucboulder.ooad.project3.entities.Tool;

// Decorator class
// It has an instance of Tool which can be either tool alone or decorator tool.


public class AddOnDecorator extends Tool {

	 public Tool tool;
	public int price;
	public int nytNo;
	
	
	public AddOnDecorator(Tool tool,String name,int price,int nytNo) {
		
		this.tool = tool;
		this.name = name;
		this.price = price;
		this.nytNo = nytNo;
	}
	// Gives the price of the entire decorator tool. 
	public int getPrice() {
		
		return price+tool.getPrice();
		
	}

	@Override
	public void increaseCount() {
		
		
	}

	
	
	
}
