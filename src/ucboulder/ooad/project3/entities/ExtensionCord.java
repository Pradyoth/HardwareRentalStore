package ucboulder.ooad.project3.entities;

import ucboulder.ooad.project3.decorator.AddOnDecorator;

public class ExtensionCord extends AddOnDecorator{

	static final int price = 16;
	
	public ExtensionCord(Tool tool, String name) {
		super(tool, name, price);
	}

	
}
