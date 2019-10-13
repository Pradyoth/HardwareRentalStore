package ucboulder.ooad.project3.decorator;

import ucboulder.ooad.project3.entities.Tool;

public class AddOnDecorator extends Tool {

	Tool tool;
	
	
	public AddOnDecorator(Tool tool,String name) {
		
		this.tool = tool;
		this.name = name;
		
	}
	
	
}
