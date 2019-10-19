package ucboulder.ooad.project3.entities;

import ucboulder.ooad.project3.decorator.AddOnDecorator;

//AddOn option for tool. 

public class ProtectiveGearPack extends AddOnDecorator{

	static final int price = 25;
	
	public ProtectiveGearPack(Tool tool, String name,int nytNo) {
		super(tool, name, price,nytNo);
	}

	
}
