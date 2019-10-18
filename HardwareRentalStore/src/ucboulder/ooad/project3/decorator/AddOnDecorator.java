package ucboulder.ooad.project3.decorator;

import ucboulder.ooad.project3.entities.Tool;

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
	
	public int getPrice() {
		
		return price+tool.getPrice();
		
	}

	@Override
	public void increaseCount() {
		
		
	}

	
	
	
}
