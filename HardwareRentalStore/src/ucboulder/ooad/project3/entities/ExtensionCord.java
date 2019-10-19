package ucboulder.ooad.project3.entities;

import ucboulder.ooad.project3.decorator.AddOnDecorator;

//AddOn option for tool. 

public class ExtensionCord extends AddOnDecorator{

	static final int price = 16;
	
	public ExtensionCord(Tool tool, String name,int nytNo) {
		super(tool, name, price,nytNo);
	}

	
}
