package ucboulder.ooad.project3.entities;

import ucboulder.ooad.project3.decorator.AddOnDecorator;

public class AccessoryKit extends AddOnDecorator{

	static final int price = 18;
	
	public AccessoryKit(Tool tool, String name) {
		super(tool, name, price);
	}

	
}
