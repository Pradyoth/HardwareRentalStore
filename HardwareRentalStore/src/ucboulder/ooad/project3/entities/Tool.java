package ucboulder.ooad.project3.entities;

import ucboulder.ooad.project3.decorator.AddOnDecorator;

public abstract class Tool {

	public String name;
	public abstract int getPrice();
	public abstract void increaseCount();
	public int nytNo;
	
}
