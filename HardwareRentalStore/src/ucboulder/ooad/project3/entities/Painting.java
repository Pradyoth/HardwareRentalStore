package ucboulder.ooad.project3.entities;

public class Painting extends Tool{

	static final int price = 5;
	
	static int count = 5;
	
	private Painting(String name){
		this.name=name;
	}
	
	public static Painting getInstance(String name) {
		
		if(count > 1) {
			count--;
			return new Painting(name);
		}
		else {
			return null;
		}
		
	}
	
}
