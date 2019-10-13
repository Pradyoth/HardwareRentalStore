package ucboulder.ooad.project3.decorator;

import ucboulder.ooad.project3.entities.Tool;

public class AddOnDecorator extends Tool {

	 public Tool tool;
	public int price;
	
	
	public AddOnDecorator(Tool tool,String name,int price) {
		
		this.tool = tool;
		this.name = name;
		this.price = price;
	}
	
	public int getPrice() {
		
		return price+tool.getPrice();
		
	}

	@Override
	public void increaseCount() {
		
		
	}

	
	
	
}
